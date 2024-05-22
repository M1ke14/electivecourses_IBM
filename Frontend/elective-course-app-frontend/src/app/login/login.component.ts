import { Component, ViewChild, ElementRef, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';
import {catchError, tap, throwError} from "rxjs";

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  @ViewChild('hidden', { read: ElementRef }) elementRef: ElementRef | undefined;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private adminService: AdminService
  ) {

    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      id: ['', Validators.required]
    });

  }

  ngOnInit() { }

  loginAsStudent() {
    this.router.navigate(['/students'])
  }

  loginAsAdmin() {
    const admin: Admin = {
      name: this.loginForm.get('username')?.value,
      id: Number(this.loginForm.get('id')?.value) // Convert ID to a number
    };

    this.adminService.loginAdmin(admin).pipe(
      tap(isAuthenticated => {
        if (isAuthenticated) {
          this.router.navigate(['/admin']);
        } else {
          alert('Invalid admin credentials');
        }
      }),
      catchError(error => {
        alert('Error logging in');
        return throwError(error);
      })
    ).subscribe();
  }
  }
