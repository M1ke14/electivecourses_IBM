import { Component, OnInit } from '@angular/core';
import { Discipline } from "../discipline";
import { DisciplineService } from "../discipline.service";
import { Router } from "@angular/router";
import { SharedService } from "../shared.service";
import { StudentService } from "../student.service";

@Component({
  selector: 'app-apply-list',
  templateUrl: './apply-list.component.html',
  styleUrls: ['./apply-list.component.css']
})
export class ApplyListComponent implements OnInit {
  disciplines: Discipline[] | undefined;
  enrollmentsVisible: boolean = false;
  studentId: number | undefined;

  constructor(
      private disciplineService: DisciplineService,
      private router: Router,
      private sharedService: SharedService,
      private studentService: StudentService
  ) { }

  ngOnInit(): void {
    this.studentId = this.getStudentIdFromStorage();
    if (this.studentId !== undefined) {
      this.getDisciplines(this.studentId);
    }
    this.sharedService.enrollmentsVisible$.subscribe(visible => {
      this.enrollmentsVisible = visible;
    });
  }

  private getStudentIdFromStorage(): number | undefined {
    const loggedInStudentId = localStorage.getItem('loggedInStudentId');
    return loggedInStudentId ? Number(loggedInStudentId) : undefined;
  }

  private getDisciplines(studentId: number) {
    this.disciplineService.getDisciplinesForStudent(studentId).subscribe(data => {
      this.disciplines = data;
    }, error => {
      console.error('Error loading disciplines:', error);
    });
  }

  applyToDiscipline(id: number | undefined) {
    console.log(`Applying to discipline with ID ${id}`);
  }

  viewDiscipline(id: number | undefined) {
    this.router.navigate(['discipline-details', id]);
  }
}
