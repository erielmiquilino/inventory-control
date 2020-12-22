import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {Seller} from './model/seller';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  constructor(private http: HttpClient) { }

  public saveSeller(seller: Seller): Observable<any> {
    return this.http.post(`${environment.application}/seller`, seller);
  }

  public getAllSellers(): Observable<Seller[]> {
    return this.http.get<Seller[]>(`${environment.application}/seller`);
  }
}
