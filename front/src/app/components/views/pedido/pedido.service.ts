import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Pedido } from './pedido.module';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  http = inject(HttpClient);

  URL = 'http://localhost:8080/pedidos';


  constructor(private _snack: MatSnackBar) {}

  pedido: [] = [];

  findAll():Observable<Pedido[]>{
    return this.http.get<Pedido[]>(this.URL);
  }

  findById(id: string):Observable<Pedido>{
    const url = `${this.URL}/${id}`;
    return this.http.get<Pedido>(url);
  }




  delete(id: string): Observable<Pedido>{
    const url = `${this.URL}/${id}`;
    return this.http.delete<Pedido>(url)

  }


}
