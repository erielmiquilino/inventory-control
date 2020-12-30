import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'cellphone'
})
export class CellphonePipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {
    if (value.length === 11) {
      return value.replace(/(\d{2})(\d{5})/g, '(\$1) \$2-');
    }
    return 'error';
  }

}
