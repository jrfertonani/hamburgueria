import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/views/home/home.component';

import { LancheComponent } from './components/views/lanche/lanche.component';
import { LancheCreateComponent } from './components/views/lanche/lanche-create/lanche-create.component';

import { BebidaComponent } from './components/views/bebida/bebida.component';
import { BebidaCreateComponent } from './components/views/bebida/bebida-create/bebida-create.component';
import { ClienteComponent } from './components/views/cliente/cliente.component';
import { ClienteCreateComponent } from './components/views/cliente/cliente-create/cliente-create.component';

const routes: Routes = [

  {path: '', component: HomeComponent},
  {path:'lanches', component:LancheComponent },
  {path: 'lanches/create', component: LancheCreateComponent},
  {path: 'lanches/update/:id', component: LancheCreateComponent},
  {path: 'lanches/delete/:id' , component: LancheComponent},

  {path: 'bebidas', component: BebidaComponent},
  {path: 'bebidas/create', component: BebidaCreateComponent},
  {path: 'bebidas/update/:id', component: BebidaCreateComponent},
  {path: 'bebidas/delete/:id', component: BebidaComponent},

  {path: 'clientes', component: ClienteComponent},
  {path: 'clientes/create', component: ClienteCreateComponent},
  {path: 'clientes/update/:id', component: ClienteCreateComponent},
  {path: 'clientes/delete/:id', component: ClienteComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
