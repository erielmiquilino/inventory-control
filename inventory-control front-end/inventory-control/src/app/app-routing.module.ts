import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SellerListComponent} from './features/seller/seller-list/seller-list.component';
import {SellerFormComponent} from './features/seller/seller-form/seller-form.component';

const routes: Routes = [
  {
    path: 'sellers',
    component: SellerListComponent,
  },
  {
    path: 'sellers/new',
    component: SellerFormComponent
  },
  {
    path: 'sellers/edit/:id',
    component: SellerFormComponent
  },
  {
    path: '',
    redirectTo: '/sellers',
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
