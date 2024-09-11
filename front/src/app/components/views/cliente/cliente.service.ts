import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Cliente } from './cliente.module';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

 // baseUrl: string = environment.baseUrl;

 http = inject(HttpClient);

 URL = 'http://localhost:8080/clientes';


 constructor(private _snack: MatSnackBar) {}

 cliente: [] = [];



 findAll(): Observable<Cliente[]> {
  return this.http.get<Cliente[]>(this.URL);
}

findById(id: string): Observable<Cliente> {
  const url = `${this.URL}/${id}`;
  return this.http.get<Cliente>(url);
}

create(cliente: Cliente): Observable<Cliente> {
  return this.http.post<Cliente>(this.URL, cliente);
}

update(cliente: Cliente): Observable<Cliente> {
  const url = `${this.URL}/${cliente.id}`;
  return this.http.put<Cliente>(url, cliente);
}


delete(id: string): Observable<Cliente>{
  const url = `${this.URL}/${id}`;
  return this.http.delete<Cliente>(url)

}


 mensagem(str: String): void {
  this._snack.open(`${str}`, 'OK', {
    horizontalPosition: 'end',
    verticalPosition: 'top',
    duration: 3000,
  });
}

}
