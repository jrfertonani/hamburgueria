import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterStateSnapshot } from '@angular/router';
import { Bebida } from './bebida.module';
import { BebidaService } from './bebida.service';

@Component({
  selector: 'app-bebida',
  templateUrl: './bebida.component.html',
  styleUrl: './bebida.component.scss'
})
export class BebidaComponent  implements OnInit  {

  displayedColumns = ['id', 'nome', 'actions'];

  bebida: Bebida [] = [];


  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private bebidaService: BebidaService,
  ) {}

  ngOnInit(): void {
    this.findAll();
  }


  findAll(): void {
    this.bebidaService.findAll().subscribe((bebida) => {
      this.bebida = bebida;
    });
  }


  delete(): void {

    const id = this.route.snapshot.paramMap.get('id');

    this.bebidaService.delete(id as string).subscribe((bebida) => {
      bebida = bebida;
      this.router.navigate(['bebidas']);
    });

    };



    navegarParaBebidaCreate() {
    this.router.navigate(['bebidas/create']);
  }


}
