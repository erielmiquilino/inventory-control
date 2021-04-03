import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {SellerViewModel} from './model/sellerViewModel';
import {SellerModel} from './model/SellerModel';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  private readonly sellerRootUrl: string;

  constructor(private http: HttpClient) {
    this.sellerRootUrl = `${environment.application}/seller`;
  }

  public saveSeller(seller: any): Observable<any> {
    return this.http.post(`${this.sellerRootUrl}/save`, seller);
  }

  public getPaginatedSellers(pageNumber: number, pageSize: number, key: string | null): Observable<any> {
    let filter = '';
    if (key) {
      filter = `?key=${key}`;
    }
    return this.http.get(`${this.sellerRootUrl}/getPaginated/${pageNumber}/${pageSize}${filter}`);
  }

  public verifyExistenceOf(cpf: string): Observable<any> {
    return this.http.get(`${this.sellerRootUrl}/verifyExistenceOf/${cpf}`);
  }

  public getSellerById(sellerId: string): Observable<SellerModel> {
    return this.http.get<SellerModel>(`${this.sellerRootUrl}/getById/${sellerId}`);
  }

  public putSeller(seller: any): Observable<any> {
    return this.http.put(`${this.sellerRootUrl}/update`, seller);
  }

  public deleteSeller(sellerId: string): Observable<any> {
    return this.http.delete(`${this.sellerRootUrl}/delete/${sellerId}`);
  }

  public uploadDocument(image: any, imageType: string): Observable<any> {
    return this.http.post(`${this.sellerRootUrl}/uploadDocument/${imageType}`, image);
  }
}
