import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterStateSnapshot } from '@angular/router';
import { LancheModule } from './lanche.module';

@Component({
  selector: 'app-lanche',
  templateUrl: './lanche.component.html',
  styleUrl: './lanche.component.scss'
})
export class LancheComponent implements OnInit  {

  displayedColumns = ['id', 'nome'];

  lanche: LancheModule [] = [];

  constructor(
    private router: Router,
    private route: ActivatedRoute,

  ) {}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }




  delete(): void {



  }


  navegarParaLancheCreate() {
    this.router.navigate(['lanches/create']);
  }

}
