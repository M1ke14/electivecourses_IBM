import { Component, OnInit } from '@angular/core';
import { Enrollment } from "../enrollment";
import { EnrollmentService } from "../enrollment.service";
import { Router } from "@angular/router";
import { FilterMetadata } from 'primeng/api'; // Import FilterMetadata from PrimeNG

@Component({
  selector: 'app-enrollment-list',
  templateUrl: './enrollment-list.component.html',
  styleUrls: ['./enrollment-list.component.css']
})
export class EnrollmentListComponent implements OnInit {
  enrollments: Enrollment[] = [];
  filters: { [key: string]: FilterMetadata | FilterMetadata[] } = {};

  constructor(private enrollmentService: EnrollmentService,
              private router: Router) { }

  ngOnInit(): void {
    this.getEnrollments();
  }

  private getEnrollments() {
    this.enrollmentService.getEnrollmentList().subscribe(data => {
      this.enrollments = data;
      this.applyFilters();
    });
  }

  applyFilter(value: string, field: string) {
    if (!this.filters[field]) {
      this.filters[field] = {};
    }
    (this.filters[field] as FilterMetadata).value = value;
    this.applyFilters();
  }

  private applyFilters() {
    this.enrollmentService.getEnrollmentList().subscribe(data => {
      this.enrollments = data.filter(enrollment => {
        return Object.keys(this.filters).every(key => {
          const filter = this.filters[key] as FilterMetadata;
          return (enrollment as any)[key]?.toString().toLowerCase().includes(filter.value.toLowerCase());
        });
      });
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
