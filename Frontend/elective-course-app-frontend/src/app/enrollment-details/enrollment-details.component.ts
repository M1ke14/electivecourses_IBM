import { Component, OnInit } from '@angular/core';
import { Enrollment } from "../enrollment";
import { ActivatedRoute } from "@angular/router";
import { EnrollmentService } from "../enrollment.service";

@Component({
  selector: 'app-enrollment-details',
  templateUrl: './enrollment-details.component.html',
  styleUrls: ['./enrollment-details.component.css']
})
export class EnrollmentDetailsComponent implements OnInit {
  id: number | undefined;
  enrollment: Enrollment | undefined;

  constructor(private route: ActivatedRoute, private enrollmentService: EnrollmentService) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.enrollmentService.getEnrollmentById(this.id).subscribe(data => {
      this.enrollment = data;
    });
  }
}
