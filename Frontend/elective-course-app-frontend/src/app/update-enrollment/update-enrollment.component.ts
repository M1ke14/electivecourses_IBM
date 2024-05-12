import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Enrollment } from '../enrollment';
import { EnrollmentService } from '../enrollment.service';

@Component({
  selector: 'app-update-enrollment',
  templateUrl: './update-enrollment.component.html',
  styleUrls: ['./update-enrollment.component.css']
})
export class UpdateEnrollmentComponent implements OnInit {
  id: number | undefined;
  enrollment: Enrollment = {
    id: 0,
    priority: '',
    student: '',
    discipline: ''
  };

  constructor(
    private enrollmentService: EnrollmentService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];

    this.enrollmentService.getEnrollmentById(this.id).subscribe(
      data => {
        this.enrollment = data;
      },
      error => {
        console.error('Error fetching enrollment:', error);
        // Handle error, e.g., display error message to the user
      }
    );
  }

  onSubmit() {
    this.enrollmentService.updateEnrollment(this.id, this.enrollment).subscribe(
      () => {
        this.goToEnrollmentList();
      },
      error => {
        console.error('Error updating enrollment:', error);
        // Handle error, e.g., display error message to the user
      }
    );
  }

  goToEnrollmentList() {
    this.router.navigate(['/enrollments']);
  }
}
