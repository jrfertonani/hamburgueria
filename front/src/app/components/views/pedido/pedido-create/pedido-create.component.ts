import { Component, OnInit } from '@angular/core';
import { PedidoService } from '../pedido.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Pedido } from '../pedido.module';

@Component({
  selector: 'app-pedido-create',
  templateUrl: './pedido-create.component.html',
  styleUrl: './pedido-create.component.scss'
})
export class PedidoCreateComponent implements OnInit {

  constructor(
    private pedidosService: PedidoService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  pedido: Pedido[] =[];


  ngOnInit(): void {

  }


  save(){}


  cancel(){
    this.router.navigate(['/pedidos'])
  }



}
