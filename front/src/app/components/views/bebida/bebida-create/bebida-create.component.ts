import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { FormControl, Validators } from '@angular/forms';
import { BebidaService } from '../bebida.service';
import { Bebida } from '../bebida.module';


@Component({
  selector: 'app-bebida-create',
  templateUrl: './bebida-create.component.html',
  styleUrl: './bebida-create.component.scss'
})
export class BebidaCreateComponent implements OnInit {

  constructor(
    private bebidaService: BebidaService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  bebida: Bebida = {
    id: 0,
    nome: ''
  };


  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.bebidaService.findById(id).subscribe((bebida) => {
        this.bebida = bebida;
      });
    }

  }


  save(): void {
    // Validação dos campos obrigatórios
    if (!this.bebida.nome.trim()) {
      this.bebidaService.mensagem('O nome do lanche não pode estar vazio!');
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
    this.bebidaService.create(this.bebida).subscribe(
      (resposta) => {
        this.bebidaService.mensagem('Bebida criado com sucesso!');
        this.router.navigate(['bebidas']);
      },
      (err) => {
        console.error('Erro ao criar bebida:', err);
        const errorMessage = err.error?.message || 'Erro ao criar lanche!';
        this.bebidaService.mensagem(errorMessage);
      }
    );
  }

  update(): void {
    this.bebidaService.update(this.bebida).subscribe(
      (Response)=> {
        this.bebidaService.mensagem('Bebida changed successfully!');
        this.router.navigate(['bebidas']);

      },
      (err)=> {

      }
    );
  }


  cancel(): void {
    this.router.navigate(['bebidas']);
  }


}
