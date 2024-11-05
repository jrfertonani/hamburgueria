import { Component, OnInit } from '@angular/core';
import { Pedido } from './pedido.module';
import { PedidoService } from './pedido.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Lanche } from '../lanche/lanche.module';
import { P } from '@angular/cdk/keycodes';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
  styleUrl: './pedido.component.scss'
})
export class PedidoComponent implements OnInit  {

  displayedColumns = ['id', 'lanche', 'bebida', 'cliente', 'actions'];


  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private pedidoService: PedidoService,
  ) {}

 pedido: Pedido[] = [];

 ngOnInit():void {
  this.findALL();
 }



 navegarParaPedidoCreate(){
  this.router.navigate(['/pedidos/create'])
 }

 findALL(){
  this.pedidoService.findAll().subscribe(pedido => {
    this.pedido = pedido;
  })
 }


 delete(): void {

  const id = this.route.snapshot.paramMap.get('id');

  this.pedidoService.delete(id as string).subscribe((pedido) => {
    pedido = pedido;
    this.router.navigate(['pedidos']);
  });

}

}
