import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { TelaInicioComponent } from './tela-inicio/tela-inicio.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';
import { HeaderComponent } from './components/header/header.component';
import { MatIconModule } from '@angular/material/icon';
import { HomePageComponent } from './home-page/home-page.component';
import { MatButtonModule } from '@angular/material/button';
import { CardEventComponent } from './components/card-event/card-event.component';
import { MatDialogModule } from '@angular/material/dialog';
import { ModalSubscribeComponent } from './components/modal-subscribe/modal-subscribe.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { MatListModule } from '@angular/material/list';
import { TelaCadastroComponent } from './components/tela-cadastro/tela-cadastro.component';
import { TelaLoginComponent } from './components/tela-login/tela-login.component';

@NgModule({
  declarations: [
    AppComponent,
    TelaInicioComponent,
    HeaderComponent,
    HomePageComponent,
    CardEventComponent,
    ModalSubscribeComponent,
    ProfilePageComponent,
    TelaCadastroComponent,
    TelaLoginComponent
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
