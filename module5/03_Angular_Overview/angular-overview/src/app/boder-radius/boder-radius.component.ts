import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-boder-radius',
  templateUrl: './boder-radius.component.html',
  styleUrls: ['./boder-radius.component.scss']
})
export class BoderRadiusComponent implements OnInit {

  borderRadius = 0;
  constructor() { }
  onChange(value) {
    console.log(value);
    
    this.borderRadius = value;
  }
  ngOnInit() {
  }

}
