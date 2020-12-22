import { Component, OnInit } from '@angular/core';
import {Seller} from '../model/seller';
import {SellerService} from '../seller.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-seller-list',
  templateUrl: './seller-list.component.html',
  styleUrls: ['./seller-list.component.sass']
})
export class SellerListComponent implements OnInit {

  public sellers!: Seller[];

  constructor(private sellerService: SellerService) { }

  ngOnInit(): void {
    this.loadSellers();
  }

  private loadSellers(): void {
    this.sellerService.getAllSellers().subscribe(sellers => {
      this.sellers = sellers;
    });
  }
}
