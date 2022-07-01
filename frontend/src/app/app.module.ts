import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TelaLoginComponent } from './tela-login/tela-login.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';

@NgModule({
  declarations: [
    AppComponent,
    TelaLoginComponent
  ],
  imports: [
    BrowserModule,
    NoopAnimationsModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
