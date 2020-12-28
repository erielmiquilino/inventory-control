import {Injectable} from '@angular/core';
import {AbstractControl, AsyncValidator, ValidationErrors} from '@angular/forms';
import {Observable, of} from 'rxjs';
import {SellerService} from '../seller/seller.service';
import {catchError, map} from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class CpfValidatorService implements AsyncValidator {

  constructor(private sellerService: SellerService) { }

  validate(control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> {
    const cpf = control.value;

    if (cpf.length < 11) {
      return of(null);
    }

    return this.sellerService.verifyExistenceOf(cpf).pipe(
      map((result) => (result ? {cpfExist: true} : null)),
      catchError(() => of(null))
    );
  }
}
