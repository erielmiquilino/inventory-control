import { Component, OnInit } from '@angular/core';
import {Seller} from '../model/seller';

@Component({
  selector: 'app-seller-list',
  templateUrl: './seller-list.component.html',
  styleUrls: ['./seller-list.component.sass']
})
export class SellerListComponent implements OnInit {

  public sellers!: Seller[];

  constructor() { }

  ngOnInit(): void {
  }

}
