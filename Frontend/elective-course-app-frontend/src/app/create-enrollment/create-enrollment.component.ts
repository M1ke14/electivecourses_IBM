import { Component, OnInit } from '@angular/core';
import { Enrollment } from "../enrollment";
import { EnrollmentService } from "../enrollment.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-create-enrollment',
  templateUrl: './create-enrollment.component.html',
  styleUrls: ['./create-enrollment.component.css']
})
export class CreateEnrollmentComponent implements OnInit {
  enrollment: Enrollment = {
    id: undefined,
    priority: '',
    studentName: '',
    disciplineName: ''
  };

  constructor(private enrollmentService: EnrollmentService,
              private router: Router) {}

  ngOnInit() {
  }

  saveEnrollment() {
    this.enrollmentService.createEnrollment(this.enrollment).subscribe(
      (data) => {
        console.log(data);
        this.goToEnrollmentList();
      },
      (error) => {
        console.error(error);
      }
    );
  }

  goToEnrollmentList() {
    this.router.navigate(['/enrollments']);
  }

  onSubmit() {
    console.log(this.enrollment);
    this.saveEnrollment();
  }
}
