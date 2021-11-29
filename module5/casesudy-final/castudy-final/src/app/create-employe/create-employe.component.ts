import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-employe',
  templateUrl: './create-employe.component.html',
  styleUrls: ['./create-employe.component.css']
})
export class CreateEmployeComponent implements OnInit {
  createEmployee: FormGroup;
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.createEmployee = this.fb.group({
      idEmployee : [''],
      name : [''],
      viTri : [''],
      trinhDo : [''],
      boPhan : [''],
      birthDay : [''],
      cmnd : [''],
      luong : [''],
      std : [''],
      email : [''],
      address : [''],
    });

    // update form state
    this.createEmployee.patchValue({
      email: 'info@example.com'
    });
  }
  onSubmit() {
    console.log(this.createEmployee);
    
  }
}
