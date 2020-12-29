import {Injectable} from '@angular/core';
import {AbstractControl, AsyncValidator, ValidationErrors} from '@angular/forms';
import {Observable, of} from 'rxjs';
import {SellerService} from '../seller/seller.service';
import {catchError, map} from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class CpfValidatorService implements AsyncValidator {

  public cpfEditing!: string;

  constructor(private sellerService: SellerService) { }

  static validateCpfValue(cpf: string): boolean {

    if ((cpf === '00000000000') || (cpf === '11111111111') ||
      (cpf === '22222222222') || (cpf === '33333333333') ||
      (cpf === '44444444444') || (cpf === '55555555555') ||
      (cpf === '66666666666') || (cpf === '77777777777') ||
      (cpf === '88888888888') || (cpf === '99999999999')) {
      return false;
    }

    const numbers = '0123456789';
    let numberValue = 0;
    let character = '';
    let j = 10;
    let summation = 0;
    let mod = 0;
    let digitOne = 0;
    let digitTwo = 0;
    let cpfAux = cpf.substring(0, 9);
    for (let i = 0; i < 9; i++) {
      character = cpfAux.charAt(i);
      if (numbers.search(character) === -1) {
        return false;
      }
      numberValue = Number(character);
      summation = summation + (numberValue * j);
      j--;
    }
    mod = summation % 11;
    digitOne = 11 - mod;
    if (digitOne > 9) {
      digitOne = 0;
    }
    j = 11;
    summation = 0;
    cpfAux = cpfAux + digitOne;
    for (let i = 0; i < 10; i++) {
      character = cpfAux.charAt(i);
      numberValue = Number(character);
      summation = summation + (numberValue * j);
      j--;
    }
    mod = summation % 11;
    digitTwo = 11 - mod;
    if (digitTwo > 9) {
      digitTwo = 0;
    }
    cpfAux = cpfAux + digitTwo;

    return cpf === cpfAux;
  }

  validate(control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> {
    const cpf = control.value;

    if (this.cpfEditing.length === 11 && this.cpfEditing === cpf) {
      return of(null);
    }

    if (cpf.length < 11) {
      return of(null);
    }

    if (!CpfValidatorService.validateCpfValue(cpf)) {
      return of({cpfInvalid: true});
    }

    return this.sellerService.verifyExistenceOf(cpf).pipe(
      map((result) => (result ? {cpfExist: true} : null)),
      catchError(() => of(null))
    );
  }

}
