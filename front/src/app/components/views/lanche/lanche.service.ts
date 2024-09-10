import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Lanche } from './lanche.module';

@Injectable({
  providedIn: 'root'
})
export class LancheService {

   // baseUrl: string = environment.baseUrl;

   http = inject(HttpClient);

   URL = 'http://localhost:8080/lanches';


   constructor(private _snack: MatSnackBar) {}

   lanche: [] = [];



   findAll(): Observable<Lanche[]> {
    return this.http.get<Lanche[]>(this.URL);
  }

  findById(id: string): Observable<Lanche> {
    const url = `${this.URL}/${id}`;
    return this.http.get<Lanche>(url);
  }

  create(lanche: Lanche): Observable<Lanche> {
    return this.http.post<Lanche>(this.URL, lanche);
  }

  update(lanche: Lanche): Observable<Lanche> {
    const url = `${this.URL}/${lanche.id}`;
    return this.http.put<Lanche>(url, lanche);
  }


  delete(id: string): Observable<Lanche>{
    const url = `${this.URL}/${id}`;
    return this.http.delete<Lanche>(url)

  }


   mensagem(str: String): void {
    this._snack.open(`${str}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 3000,
    });
  }

}
