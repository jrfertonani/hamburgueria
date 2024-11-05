import { Component, OnInit } from '@angular/core';
import { Pedido } from './pedido.module';
import { PedidoService } from './pedido.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
  styleUrl: './pedido.component.scss'
})
export class PedidoComponent implements OnInit  {


  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private pedidoService: PedidoService,
  ) {}

 pedido: Pedido[] = [];

 ngOnInit() {

 }

}
