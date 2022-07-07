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
import { CertificatesComponent } from './components/profile/certificates/certificates.component';
import { ContentComponent } from './components/profile/content/content.component';
import { CertificateCardComponent } from './components/profile/certificates/certificate-card/certificate-card.component';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips'; 

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
    TelaLoginComponent,
    ContentComponent,
    CertificatesComponent,
    CertificateCardComponent
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatListModule,
    MatCardModule,
    MatChipsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
