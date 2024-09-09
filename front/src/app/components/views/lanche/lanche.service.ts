import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LancheService {

   // baseUrl: string = environment.baseUrl;

   http = inject(HttpClient);

   URL = 'http://localhost:8080/hamburgueria';


   constructor(private _snack: MatSnackBar) {}

   lanche: [] = [];





   mensagem(str: String): void {
    this._snack.open(`${str}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 3000,
    });
  }

}
