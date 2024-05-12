import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from '../student';
import { StudentService } from '../student.service';
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {
  id: number | undefined;
  student: Student = {
    id: 0,
    name: '',
    grade: 0,
    studyYear: 0,
    facultySection: '',
    userType: 'student',
    enrollment: []
  };

  constructor(
      private studentService: StudentService,
      private router: Router,
      private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];

    this.studentService.getStudentById(this.id).subscribe(data => {
      this.student = data;
    }, error => console.log(error));
  }

  onSubmit() {
    this.studentService.updateStudent(this.id, this.student).subscribe( data =>{
      this.goToStudentList();
    }
    , error => console.log(error));
  }

  goToStudentList() {
    this.router.navigate(['/students']);
  }
}
