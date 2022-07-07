import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tela-cadastro',
  templateUrl: './tela-cadastro.component.html',
  styleUrls: ['./tela-cadastro.component.sass']
})
export class TelaCadastroComponent implements OnInit {
  telaCadastro: boolean = true;
  telaLogin: boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

  abrirTelaLogin(){
    this.telaLogin = true;
    this.telaCadastro = false;
  }
}
