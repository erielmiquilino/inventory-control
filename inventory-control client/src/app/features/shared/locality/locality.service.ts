import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../../environments/environment';
import {Observable} from 'rxjs';
import {State} from './model/State';
import {City} from './model/city';

@Injectable({
  providedIn: 'root'
})
export class LocalityService {

  constructor(private http: HttpClient) { }

  public getAllStates(): Observable<State[]> {
    return this.http.get<State[]>(`${environment.locality}/estados`);
  }

  public getAllCitiesByStateId(stateId: number): Observable<City[]> {
    return this.http.get<City[]>(`${environment.locality}/estados/${stateId}/municipios`);
  }

}
