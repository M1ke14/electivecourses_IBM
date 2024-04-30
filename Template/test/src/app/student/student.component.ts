import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['src/styles.css']
})
export class StudentComponent {

  constructor(private router: Router) { }

  navigateToCourses() {
    this.router.navigate(['/courses']);
  }

  navigateToApplications() {
    this.router.navigate(['/applications']);
  }

}
