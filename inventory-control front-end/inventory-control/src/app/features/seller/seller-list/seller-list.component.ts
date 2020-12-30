import { Component, OnInit } from '@angular/core';
import {SellerViewModel} from '../model/sellerViewModel';
import {SellerService} from '../seller.service';
import {ConfirmationService, MessageService} from 'primeng/api';

@Component({
  selector: 'app-seller-list',
  templateUrl: './seller-list.component.html',
  styleUrls: ['./seller-list.component.sass']
})
export class SellerListComponent implements OnInit {

  public sellers!: SellerViewModel[];

  constructor(private sellerService: SellerService,
              private messageService: MessageService,
              private confirmationService: ConfirmationService) { }

  ngOnInit(): void {
    this.loadSellers();
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

  private loadSellers(): void {
    this.sellerService.getAllSellers().subscribe(sellers => {
      this.sellers = sellers;
    });
  }
}
