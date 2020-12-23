import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {SellerViewModel} from './model/sellerViewModel';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  constructor(private http: HttpClient) { }

  public saveSeller(seller: any): Observable<any> {
    return this.http.post(`${environment.application}/seller`, seller);
  }

  public getAllSellers(): Observable<SellerViewModel[]> {
    return this.http.get<SellerViewModel[]>(`${environment.application}/seller`);
  }

  public verifyExistenceOf(cpf: string): Observable<any> {
    return this.http.get(`${environment.application}/seller/verifyExistenceOf/${cpf}`, {responseType: 'text'});
  }
}
