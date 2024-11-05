import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { FormControl, Validators } from '@angular/forms';
import { Lanche } from '../lanche.module';
import { LancheService } from '../lanche.service';

@Component({
  selector: 'app-lanche-create',
  templateUrl: './lanche-create.component.html',
  styleUrl: './lanche-create.component.scss'
})
export class LancheCreateComponent implements OnInit {

  constructor(
    private lancheService: LancheService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  lanche: Lanche = {
    id: 0,
    nome: ''
  };


  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.lancheService.findById(id).subscribe((lanche) => {
        this.lanche = lanche;
      });
    }

  }


  save(): void {
    // Validação dos campos obrigatórios
    if (!this.lanche.nome.trim()) {
      this.lancheService.mensagem('O nome do lanche não pode estar vazio!');
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
    this.lancheService.create(this.lanche).subscribe(
      (resposta) => {
        this.lancheService.mensagem('Lanche criado com sucesso!');
        this.router.navigate(['lanches']);
      },
      (err) => {
        console.error('Erro ao criar lanche:', err);
        const errorMessage = err.error?.message || 'Erro ao criar lanche!';
        this.lancheService.mensagem(errorMessage);
      }
    );
  }

  update(): void {
    this.lancheService.update(this.lanche).subscribe(
      (Response)=> {
        this.lancheService.mensagem('Lanches changed successfully!');
        this.router.navigate(['lanches']);

      },
      (err)=> {

      }
    );
  }




  cancel(): void {
    this.router.navigate(['lanches']);
  }


}
