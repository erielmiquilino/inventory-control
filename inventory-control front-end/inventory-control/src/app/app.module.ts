import { BrowserModule } from '@angular/platform-browser';
import {LOCALE_ID, NgModule} from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SellerFormComponent } from './features/seller/seller-form/seller-form.component';
import { InputTextModule } from 'primeng/inputtext';
import {ReactiveFormsModule} from '@angular/forms';
import {CalendarModule} from 'primeng/calendar';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {registerLocaleData} from '@angular/common';
import ptBr from '@angular/common/locales/pt';

registerLocaleData(ptBr);

@NgModule({
  declarations: [
    AppComponent,
    SellerFormComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        InputTextModule,
        CalendarModule,
        ReactiveFormsModule,
        BrowserAnimationsModule,
    ],
  providers: [{provide: LOCALE_ID, useValue: 'pt'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
