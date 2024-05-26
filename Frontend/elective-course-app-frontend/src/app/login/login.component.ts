import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';
import { catchError, tap, throwError } from 'rxjs';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(
      private fb: FormBuilder,
      private router: Router,
      private studentService: StudentService,
      private adminService: AdminService
  ) {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      id: ['', Validators.required]
    });
  }

  ngOnInit() { }

  loginAsStudent() {
    const student: Student = {
      name: this.loginForm.get('username')?.value,
      id: Number(this.loginForm.get('id')?.value) // Convert ID to a number
    };

    this.studentService.loginStudent(student).subscribe(loggedInStudent => {
      if (loggedInStudent) {
        localStorage.setItem('loggedInStudentId', String(loggedInStudent.id));
        this.router.navigate(['/students']);
      } else {
        alert('Invalid student credentials');
      }
    }, error => {
      alert('Error logging in');
      console.error('Error logging in:', error);
    });
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
