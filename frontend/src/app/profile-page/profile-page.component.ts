import { Component, OnInit } from '@angular/core';
import { MenuModel } from '../models/MenuModel';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.sass']
})
export class ProfilePageComponent implements OnInit {

  menuItems: Array<MenuModel> = [
    {
      name: 'Perfil',
      icon: 'person'
    },
    {
      name: 'Certificados',
      icon: 'beenhere'
    },
    {
      name: 'Sair',
      icon: 'exit_to_app'
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
