import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cep} from './model/cep';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CepService {

  constructor(private http: HttpClient) { }

  public getAddressByCep(cep: string): Observable<Cep> {
    return this.http.get<Cep>(`${environment.apiViaCep}/${cep}/json`);
  }
}
