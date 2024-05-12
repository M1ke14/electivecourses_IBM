import { Component, OnInit } from '@angular/core';
import { Enrollment } from "../enrollment";
import { EnrollmentService } from "../enrollment.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-enrollment-list',
  templateUrl: './enrollment-list.component.html',
  styleUrls: ['./enrollment-list.component.css'] // Corrected styleUrl to styleUrls
})
export class EnrollmentListComponent implements OnInit {
  enrollments: Enrollment[] | undefined;

  constructor(private enrollmentService: EnrollmentService,
              private router: Router) { }

  ngOnInit(): void {
    this.getEnrollments();
  }

  private getEnrollments() {
    this.enrollmentService.getEnrollmentList().subscribe(data => {
      this.enrollments = data;
    });
  }

  enrollmentDetails(id: number | undefined) {
    this.router.navigate(['enrollment-details', id]);
  }

  updateEnrollment(id: number | undefined) {
    this.router.navigate(['update-enrollment', id]);
  }

  deleteEnrollment(id: number | undefined) {
    this.enrollmentService.deleteEnrollment(id).subscribe(() => {
      console.log("Enrollment deleted successfully.");
      this.getEnrollments();
    }, error => {
      console.error("Error deleting enrollment:", error);
    });
  }
}
