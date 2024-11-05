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
    private pedidoService: PedidoService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  pedido: Pedido = {
    id: 0,
    lanche: '',
    bebida: '',
    cliente:'',
  };


  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.pedidoService.findById(id).subscribe((pedido) => {
        this.pedido = pedido;
      });
    }

  }


  save(){}


  cancel(){
    this.router.navigate(['/pedidos'])
  }

  savePedido(){}



}
