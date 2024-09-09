import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/views/home/home.component';

import { LancheComponent } from './components/views/lanche/lanche.component';
import { LancheCreateComponent } from './components/views/lanche/lanche-create/lanche-create.component';

const routes: Routes = [

  {path: '', component: HomeComponent},
  {path:'lanches', component:LancheComponent },
  {path: 'lanches/create', component: LancheCreateComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
