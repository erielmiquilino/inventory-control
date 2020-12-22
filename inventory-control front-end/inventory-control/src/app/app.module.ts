import {BrowserModule} from '@angular/platform-browser';
import {LOCALE_ID, NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SellerFormComponent} from './features/seller/seller-form/seller-form.component';
import {InputTextModule} from 'primeng/inputtext';
import {ReactiveFormsModule} from '@angular/forms';
import {CalendarModule} from 'primeng/calendar';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {registerLocaleData} from '@angular/common';
import ptBr from '@angular/common/locales/pt';
import {DropdownModule} from 'primeng/dropdown';
import {InputMaskModule} from 'primeng/inputmask';
import {LocalityService} from './features/shared/locality/locality.service';
import {HttpClientModule} from '@angular/common/http';
import {AutoCompleteModule} from 'primeng/autocomplete';
import {CepService} from './features/shared/cep/cep.service';
import {ButtonModule} from 'primeng/button';
import {RippleModule} from 'primeng/ripple';
import {CardModule} from 'primeng/card';
import {SellerService} from './features/seller/seller.service';
import { SellerListComponent } from './features/seller/seller-list/seller-list.component';
import {ToastModule} from 'primeng/toast';
import {MessageService} from 'primeng/api';
import {TableModule} from 'primeng/table';

registerLocaleData(ptBr);

@NgModule({
  declarations: [
    AppComponent,
    SellerFormComponent,
    SellerListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    InputTextModule,
    CalendarModule,
    ReactiveFormsModule,
    DropdownModule,
    InputMaskModule,
    BrowserAnimationsModule,
    AutoCompleteModule,
    ButtonModule,
    HttpClientModule,
    RippleModule,
    ToastModule,
    CardModule,
    TableModule
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'pt'},
    LocalityService,
    CepService,
    SellerService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
