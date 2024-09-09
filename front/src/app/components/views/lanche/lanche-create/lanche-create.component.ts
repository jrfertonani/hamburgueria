import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { FormControl, Validators } from '@angular/forms';
import { LancheModule } from '../lanche.module';

@Component({
  selector: 'app-lanche-create',
  templateUrl: './lanche-create.component.html',
  styleUrl: './lanche-create.component.scss'
})
export class LancheCreateComponent implements OnInit {

  constructor(
    private router: Router,
    private route: ActivatedRoute
  ) {}

  lanche: LancheModule = {
    nome: ''
  };


  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }


  save(): void {

  }


  cancel(): void {
    this.router.navigate(['lanches']);
  }


}
