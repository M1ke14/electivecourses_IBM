import {Component, OnInit} from '@angular/core';
import {Student} from "../student";
import {StudentService} from "../student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrl: './create-student.component.css'
})
export class CreateStudentComponent implements OnInit{
  student: Student = {
    name: '',
    grade: 0,
    studyYear: 0,
    facultySection: '',
    userType: 'student',
    enrollment: []
  };

  constructor(private studentService: StudentService,
              private router: Router) {}

  ngOnInit() {
  }

  saveStudent() {
    this.studentService.createStudent(this.student).subscribe(
        (data) => {
          console.log(data);
          this.goToStudentList();
        },
        (error) => {
          console.error(error);
        }
    );
  }

  goToStudentList() {
    this.router.navigate(['/students']);
  }

  onSubmit() {
    console.log(this.student);
    this.saveStudent();
  }

}
