import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SellerListComponent} from './features/seller/seller-list/seller-list.component';
import {SellerFormComponent} from './features/seller/seller-form/seller-form.component';
import {FolderListComponent} from './features/folder/folder-list/folder-list.component';

const routes: Routes = [
  {
    path: 'sellers',
    component: SellerListComponent
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
    path: 'folders',
    component: FolderListComponent
  },
  {
    path: '',
    redirectTo: '/',
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
