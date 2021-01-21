import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TemplateComponent } from './template.component';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [TemplateComponent],
  exports: [
    TemplateComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class TemplateModule { }
