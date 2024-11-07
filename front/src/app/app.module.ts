import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AsyncPipe, CommonModule } from '@angular/common';


import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatInput, MatInputModule} from '@angular/material/input';
import {MatFormField, MatFormFieldModule} from '@angular/material/form-field';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';

import { HeaderComponent } from './components/template/header/header.component';
import { FooterComponent } from './components/template/footer/footer.component';
import { NavComponent } from './components/template/nav/nav.component';

import { HomeComponent } from './components/views/home/home.component';

import { LancheComponent } from './components/views/lanche/lanche.component';
import { LancheCreateComponent } from './components/views/lanche/lanche-create/lanche-create.component';

import { BebidaComponent } from './components/views/bebida/bebida.component';
import { BebidaCreateComponent } from './components/views/bebida/bebida-create/bebida-create.component';

import { ClienteComponent } from './components/views/cliente/cliente.component';
import { ClienteCreateComponent } from './components/views/cliente/cliente-create/cliente-create.component';
import { PedidoComponent } from './components/views/pedido/pedido.component';
import { PedidoCreateComponent } from './components/views/pedido/pedido-create/pedido-create.component';
import { MatAutocompleteModule } from '@angular/material/autocomplete';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,

    NavComponent,

    HomeComponent,

    LancheComponent,
    LancheCreateComponent,

    BebidaComponent,
    BebidaCreateComponent,

    ClienteComponent,
    ClienteCreateComponent,
    PedidoComponent,
    PedidoCreateComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    MatCardModule,
    MatTableModule,
    HttpClientModule,
    MatButtonModule,
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatSnackBarModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSelectModule,
    MatRadioModule,
    CommonModule,
    FormsModule,
    BrowserModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    AsyncPipe,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,

  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
