import { Component } from '@angular/core';

@Component({
  selector: 'app-tela-login',
  templateUrl: './tela-login.component.html',
  styleUrls: ['./tela-login.component.sass']
})
export class TelaLoginComponent {
    telaLogin: boolean = true;
    telaCadastro: boolean;
  
    abrirTelaCadastro(){
        this.telaCadastro = true;
        this.telaLogin = false;
    }
}
