import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { FormControl, Validators } from '@angular/forms';
import { ClienteService } from '../cliente.service';
import { Cliente } from '../cliente.module';

@Component({
  selector: 'app-cliente-create',
  templateUrl: './cliente-create.component.html',
  styleUrl: './cliente-create.component.scss'
})
export class ClienteCreateComponent implements OnInit {

  constructor(
    private clienteService: ClienteService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  cliente: Cliente = {
    id: 0,
    nome: ''
  };


  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.clienteService.findById(id).subscribe((cliente) => {
        this.cliente = cliente;
      });
    }

  }


  save(): void {
    // Validação dos campos obrigatórios
    if (!this.cliente.nome.trim()) {
      this.clienteService.mensagem('O nome do cliente não pode estar vazio!');
      return;
    }
/*
    if (!this.lanche.nome || isNaN(this.lanche.nome)) {
      this.lancheService.mensagem('O ano do carro deve ser um número válido!');
      return;
    }

    if (!this.carro.marca) {
      this.carroService.mensagem('A marca do carro deve ser selecionada!');
      return;
    }

    if (!this.carro.proprietario) {
      this.carroService.mensagem('O proprietario do carro deve ser selecionado!');
      return;
    }
*/
    // Enviar o carro para o serviço
    this.clienteService.create(this.cliente).subscribe(
      (resposta) => {
        this.clienteService.mensagem('Cliente criado com sucesso!');
        this.router.navigate(['clientes']);
      },
      (err) => {
        console.error('Erro ao criar cliente:', err);
        const errorMessage = err.error?.message || 'Erro ao criar cliente!';
        this.clienteService.mensagem(errorMessage);
      }
    );
  }

  update(): void {
    this.clienteService.update(this.cliente).subscribe(
      (Response)=> {
        this.clienteService.mensagem('Cliente changed successfully!');
        this.router.navigate(['clientes']);

      },
      (err)=> {

      }
    );
  }




  cancel(): void {
    this.router.navigate(['clientes']);
  }


}
