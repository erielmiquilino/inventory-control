import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {SellerViewModel} from './model/sellerViewModel';
import {SellerModel} from './model/SellerModel';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  constructor(private http: HttpClient) { }

  public saveSeller(seller: any): Observable<any> {
    return this.http.post(`${environment.application}/seller/save`, seller);
  }

  public getAllSellers(): Observable<SellerViewModel[]> {
    return this.http.get<SellerViewModel[]>(`${environment.application}/seller`);
  }

  public verifyExistenceOf(cpf: string): Observable<any> {
    return this.http.get(`${environment.application}/seller/verifyExistenceOf/${cpf}`);
  }

  public getSellerById(sellerId: string): Observable<SellerModel> {
    return this.http.get<SellerModel>(`${environment.application}/seller/getById/${sellerId}`);
  }

  public putSeller(seller: any): Observable<any> {
    return this.http.put(`${environment.application}/seller/update`, seller);
  }

  public deleteSeller(sellerId: string): Observable<any> {
    return this.http.delete(`${environment.application}/seller/delete/${sellerId}`);
  }
}
