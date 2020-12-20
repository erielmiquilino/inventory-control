import { Component, OnInit } from '@angular/core';
import {LocalityService} from '../../shared/locality/locality.service';
import {State} from '../../shared/locality/model/State';
import {City} from '../../shared/locality/model/city';
import {CepService} from '../../shared/cep/cep.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-seller-form',
  templateUrl: './seller-form.component.html',
  styleUrls: ['./seller-form.component.sass']
})
export class SellerFormComponent implements OnInit {

  constructor(private localityService: LocalityService, private cepService: CepService) { }

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
    this.sellerForm = new FormGroup({
      cpf: new FormControl(''),
      name: new FormControl(''),
      cellphone: new FormControl(''),
      alternativePhone: new FormControl(''),
      email: new FormControl(''),
      dateOfBirth: new FormControl(''),
      street: new FormControl(''),
      number: new FormControl(''),
      neighborhood: new FormControl(''),
      city: new FormControl(''),
      state: new FormControl(''),
      cep: new FormControl(''),
      complement: new FormControl('')
    });
  }

  public filterState(event: any): void {
    const filtered: State[] = [];
    const query = event.query;
    for (const state of this.states) {
      if (state.nome.toLowerCase().indexOf(query.toLowerCase()) === 0) {
        filtered.push(state);
      }
    }
    this.filteredStates = filtered;
  }

  public filterCity(event: any): void {
    const filtered: City[] = [];
    const query = event.query;
    for (const city of this.cities) {
      if (city.nome.toLowerCase().indexOf(query.toLowerCase()) === 0) {
        filtered.push(city);
      }
    }
    this.filteredCities = filtered;
  }

  public findCep(): void {
    this.cepService.getAddressByCep('88501030').subscribe(cep => {
      if (cep.uf && cep.ibge) {
        const stateName = this.states.find(x => x.sigla === cep.uf)?.nome;
        this.loadCities().then(() => {
          const cityName = this.cities.find(x => x.id === parseInt(cep.ibge, 10))?.nome;
        });
      }
    });
  }

  public async loadCities(): Promise<void> {
    this.cities = await this.localityService.getAllCitiesByStateId(42).toPromise();
  }

  private loadStates(): void {
    this.localityService.getAllStates().subscribe(states => {
      this.states = states;
    });
  }

}
