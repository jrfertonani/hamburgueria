import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterStateSnapshot } from '@angular/router';
import { Lanche } from './lanche.module';
import { LancheService } from './lanche.service';

@Component({
  selector: 'app-lanche',
  templateUrl: './lanche.component.html',
  styleUrl: './lanche.component.scss'
})
export class LancheComponent implements OnInit  {

  displayedColumns = ['id', 'nome', 'actions'];

  lanche: Lanche [] = [];



  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private lancheService: LancheService,
  ) {}

  ngOnInit(): void {
    this.findAll();
  }


  findAll(): void {
    this.lancheService.findAll().subscribe((lanche) => {
      this.lanche = lanche;
    });
  }


  delete(): void {

    const id = this.route.snapshot.paramMap.get('id');

    this.lancheService.delete(id as string).subscribe((lanche) => {
      lanche = lanche;
      this.router.navigate(['lanches']);
    });


  }


  navegarParaLancheCreate() {
    this.router.navigate(['lanches/create']);
  }

}
