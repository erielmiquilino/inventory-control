import { Component, OnInit } from '@angular/core';
import {SellerViewModel} from '../model/sellerViewModel';
import {SellerService} from '../seller.service';
import {ConfirmationService, LazyLoadEvent, MessageService} from 'primeng/api';
import {Subject} from 'rxjs';
import {debounceTime} from 'rxjs/operators';

@Component({
  selector: 'app-seller-list',
  templateUrl: './seller-list.component.html',
  styleUrls: ['./seller-list.component.sass']
})
export class SellerListComponent implements OnInit {

  public subject: Subject<string> = new Subject();
  public filterKey!: string;
  public sellers!: SellerViewModel[];
  public totalRecords = 0;
  public loading = true;

  constructor(private sellerService: SellerService,
              private messageService: MessageService,
              private confirmationService: ConfirmationService) { }

  ngOnInit(): void {
    this.subject
      .pipe(debounceTime(700))
      .subscribe(() => {
        this.loadSellers(null);
      });
  }

  confirmDelete(sellerId: string): void {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir esse item?',
      header: 'Excluir',
      accept: () => {
        this.sellerService.deleteSeller(sellerId)
          .subscribe(() => {
            this.messageService.add({
              severity: 'success',
              summary: 'Sucesso',
              detail: 'O Vendedor foi removido com sucesso!'
            });
          });

        this.sellers = this.sellers.filter(seller => seller.id !== sellerId);
      }
    });
  }

  loadSellers(event: LazyLoadEvent | null): void {
    this.loading = true;

    const pageSize = event?.rows ?? 12;
    const pageNumber = (event?.first ?? 0) / pageSize;

    this.sellerService.getPaginatedSellers(pageNumber, pageSize, this.filterKey).subscribe(sellers => {
      this.sellers = sellers.content;
      this.totalRecords = sellers.totalElements;
      this.loading = false;
    });
  }

  findSellers(key: string): void {
    this.subject.next(key);
  }
}
