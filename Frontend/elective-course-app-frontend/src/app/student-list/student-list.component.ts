import {Component, OnInit} from '@angular/core';
import {Student} from "../student";
import {StudentService} from "../student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export class StudentListComponent implements OnInit{
  students: Student[] | undefined;

  constructor(private studentService: StudentService,
              private router: Router){}

  ngOnInit(): void {
    this.getStudents();
  }

  private getStudents() {
    this.studentService.getStudentsList().subscribe(data =>{
      this.students = data;
    })
  }

  studentDetails(id: number | undefined) {
    this.router.navigate(['student-details', id])
  }

  updateStudent(id: number | undefined) {
    this.router.navigate(['update-student', id])
  }

  deleteStudent(id: number | undefined) {
    this.studentService.deleteStudent(id).subscribe(data =>{
      console.log(data);
      this.getStudents();
    })
  }
}
