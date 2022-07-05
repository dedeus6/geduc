import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-modal-subscribe',
  templateUrl: './modal-subscribe.component.html',
  styleUrls: ['./modal-subscribe.component.sass']
})
export class ModalSubscribeComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  close() {
    this.dialog.closeAll();
  }

}
