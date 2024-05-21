import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-student-layout',
  templateUrl: './student-layout.component.html',
  styleUrl: './student-layout.component.css'
})
export class StudentLayoutComponent implements OnInit{
  title = 'Student Page';

  constructor() { }

  ngOnInit(): void { }
}
