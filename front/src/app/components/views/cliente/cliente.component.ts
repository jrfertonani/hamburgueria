import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterStateSnapshot } from '@angular/router';
import { Cliente } from './cliente.module';
import { ClienteService } from './cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrl: './cliente.component.scss'
})
export class ClienteComponent implements OnInit  {

  displayedColumns = ['id', 'nome', 'actions'];

  cliente: Cliente [] = [];



  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private clienteService: ClienteService,
  ) {}

  ngOnInit(): void {
    this.findAll();
  }


  findAll(): void {
    this.clienteService.findAll().subscribe((cliente) => {
      this.cliente = cliente;
    });
  }


  delete(): void {

    const id = this.route.snapshot.paramMap.get('id');

    this.clienteService.delete(id as string).subscribe((cliente) => {
      cliente = cliente;
      this.router.navigate(['clientes']);
    });


  }


  navegarParaClienteCreate() {
    this.router.navigate(['clientes/create']);
  }

}

