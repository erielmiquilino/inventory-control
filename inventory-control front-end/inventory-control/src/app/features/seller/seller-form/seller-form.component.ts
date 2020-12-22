import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {LocalityService} from '../../shared/locality/locality.service';
import {State} from '../../shared/locality/model/State';
import {City} from '../../shared/locality/model/city';
import {CepService} from '../../shared/cep/cep.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Cep} from '../../shared/cep/model/cep';
import {SellerService} from '../seller.service';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-seller-form',
  templateUrl: './seller-form.component.html',
  styleUrls: ['./seller-form.component.sass']
})
export class SellerFormComponent implements OnInit {

  @ViewChild('number') numberElementRef!: ElementRef;

  constructor(private localityService: LocalityService,
              private cepService: CepService,
              private sellerService: SellerService,
              private messageService: MessageService,
              private formBuilder: FormBuilder) { }

  public states!: State[];
  public filteredStates!: State[];
  public cities: City[] = [];
  public filteredCities: City[] = [];

  public sellerForm!: FormGroup;

  ngOnInit(): void {
    this.loadStates();
    this.initializeFormGroup();
  }

  initializeFormGroup(): void {
    this.sellerForm = this.formBuilder.group({
      cpf: ['', Validators.required],
      name: ['', Validators.required],
      cellphone: ['', Validators.required],
      alternativePhone: [''],
      email: ['', Validators.email],
      dateOfBirth: [''],
      street: ['', Validators.required],
      number: ['', Validators.required],
      neighborhood: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
      cep: ['', Validators.required],
      complement: ['', Validators.required]
    });
  }

  filterState(event: any): void {
    const filtered: State[] = [];
    const query = event.query;
    for (const state of this.states) {
      if (state.nome.toLowerCase().indexOf(query.toLowerCase()) === 0) {
        filtered.push(state);
      }
    }
    this.filteredStates = filtered;
  }

  filterCity(event: any): void {
    const filtered: City[] = [];
    const query = event.query;
    for (const city of this.cities) {
      if (city.nome.toLowerCase().indexOf(query.toLowerCase()) === 0) {
        filtered.push(city);
      }
    }
    this.filteredCities = filtered;
  }

  findCep(): void {
    if (this.sellerForm.get('cep')?.value.length === 8){
      this.cepService.getAddressByCep(this.sellerForm.get('cep')?.value).subscribe(cep => {
        if (cep.uf && cep.ibge) {
          const state = this.states.find(x => x.sigla === cep.uf);
          this.sellerForm.get('state')?.setValue(state);
          this.loadCities().then(() => {
            const city = this.cities.find(x => x.id === parseInt(cep.ibge, 10));
            this.updateFormByCep(city, cep);
            this.numberElementRef.nativeElement.focus();
          });
        }
      });
    }
  }

  async loadCities(): Promise<void> {
    const selectedState = this.sellerForm.get('state')?.value;
    if (selectedState){
      this.cities = await this.localityService.getAllCitiesByStateId(selectedState.id).toPromise();
    }
  }

  loadStates(): void {
    this.localityService.getAllStates().subscribe(states => {
      this.states = states;
    });
  }

  validate(field: string, validation: string): boolean {
    return (this.sellerForm.get(field)?.hasError(validation) ?? false)
      && (this.sellerForm.get(field)?.dirty ?? false);
  }

  submit(): void {
    const seller = this.sellerForm.value;
    seller.state = this.sellerForm.get('state')?.value.sigla;
    seller.city = this.sellerForm.get('city')?.value.nome;

    this.sellerService.saveSeller(seller).subscribe(result => {
      if (result) {
        this.messageService.add({
          severity: 'success',
          summary: 'Sucesso',
          detail: 'O Vendedor foi cadatrado.'
        });
        this.sellerForm.reset();
      } else {
        this.messageService.add({
          severity: 'warn',
          summary: 'Erro',
          detail: 'Não foi possível salvar os dados do vendedor'
        });
      }
    });
  }

  private updateFormByCep(city: City | undefined, cep: Cep): void {
    this.sellerForm.patchValue({
      city,
      street: cep.logradouro,
      neighborhood: cep.bairro
    });
  }
}

