import { Component, OnInit } from '@angular/core';
import { Student } from "../student";
import { StudentService } from "../student.service";
import { Router } from "@angular/router";
import { FilterMetadata } from 'primeng/api';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students: Student[] = [];
  selectedStudents: Student[] = [];
  metaKey: boolean = false;
  filters: { [key: string]: FilterMetadata | FilterMetadata[] } = {};

  constructor(private studentService: StudentService,
              private router: Router) { }

  ngOnInit(): void {
    this.getStudents();
  }

  private getStudents() {
    this.studentService.getStudentsList().subscribe(data => {
      this.students = data;
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
    this.studentService.getStudentsList().subscribe(data => {
      this.students = data.filter(student => {
        return Object.keys(this.filters).every(key => {
          const filter = this.filters[key] as FilterMetadata;
          return student[key]?.toString().toLowerCase().includes(filter.value.toLowerCase());
        });
      });
    });
  }

  studentDetails(id: number | undefined) {
    this.router.navigate(['student-details', id]);
  }

  updateStudent(id: number | undefined) {
    this.router.navigate(['update-student', id]);
  }

  deleteStudent(id: number | undefined) {
    this.studentService.deleteStudent(id).subscribe(data => {
      console.log(data);
      this.getStudents();
    });
  }
}
