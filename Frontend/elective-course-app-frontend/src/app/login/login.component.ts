import { Component,ViewChild,ElementRef,OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @ViewChild('hidden', { read: ElementRef }) elementRef: ElementRef | undefined;

  constructor(
    private router: Router
  ) {}

  ngOnInit() {}

  loginAsStudent() {
    this.router.navigate(['/students'])
  }

  loginAsAdmin(){
    this.router.navigate(['/admin'])
}
}
