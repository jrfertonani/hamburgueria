import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Bebida } from './bebida.module';

@Injectable({
  providedIn: 'root'
})
export class BebidaService {

   // baseUrl: string = environment.baseUrl;

   http = inject(HttpClient);

   URL = 'http://localhost:8080/bebidas';


   constructor(private _snack: MatSnackBar) {}

   bebida: [] = [];

   findAll(): Observable<Bebida[]> {
    return this.http.get<Bebida[]>(this.URL);
  }


  findById(id: string): Observable<Bebida> {
    const url = `${this.URL}/${id}`;
    return this.http.get<Bebida>(url);
  }

  create(lanche: Bebida): Observable<Bebida> {
    return this.http.post<Bebida>(this.URL, lanche);
  }

  update(lanche: Bebida): Observable<Bebida> {
    const url = `${this.URL}/${lanche.id}`;
    return this.http.put<Bebida>(url, lanche);
  }


  delete(id: string): Observable<Bebida>{
    const url = `${this.URL}/${id}`;
    return this.http.delete<Bebida>(url)

  }



  mensagem(str: String): void {
    this._snack.open(`${str}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 3000,
    });
  }
}
