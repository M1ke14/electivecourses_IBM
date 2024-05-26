import { Component, OnInit } from '@angular/core';
import { Discipline } from "../discipline";
import { DisciplineService } from "../discipline.service";
import { Router } from "@angular/router";
import { SharedService } from "../shared.service";
import { StudentService } from "../student.service";
import { DragDropModule } from 'primeng/dragdrop';

@Component({
  selector: 'app-apply-list',
  templateUrl: './apply-list.component.html',
  styleUrls: ['./apply-list.component.css']
})
export class ApplyListComponent implements OnInit {
  disciplines: Discipline[] = [];
  enrollmentsVisible: boolean = false;
  studentId: number | undefined;

  constructor(

      private disciplineService: DisciplineService,
      private router: Router,
      private sharedService: SharedService,
      private studentService: StudentService
  ) { }



  ngOnInit(): void {
    this.fetchDisciplines();
    this.studentId = this.getStudentIdFromStorage();
    if (this.studentId !== undefined) {
      this.getDisciplines(this.studentId);
    }
    this.sharedService.enrollmentsVisible$.subscribe(visible => {
      this.enrollmentsVisible = visible;
    });
  }
  fetchDisciplines(): void {

     this.disciplineService.getDisciplinesList().subscribe(data => this.disciplines = data);


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
  draggedDiscipline: Discipline | null = null;
  dragStart(discipline: Discipline): void {
    this.draggedDiscipline = discipline;
  }
  drop(event: Event, index: number): void {
    if (this.draggedDiscipline) {
      const draggedDisciplineIndex = this.disciplines.indexOf(this.draggedDiscipline);
      this.disciplines = this.disciplines.filter((_, i) => i !== draggedDisciplineIndex);
      this.disciplines.splice(index, 0, this.draggedDiscipline);
      this.draggedDiscipline = null;



    }
  }

  getPositions(): { id: number | undefined; position: number }[] {
    return this.disciplines.map((discipline, index) => ({
      id: discipline.id,
      position: index
    }));
  }
  getGrade(){

  }

  dragOver(event: Event): void {
    event.preventDefault();
  }
  applyToDiscipline(id: number | undefined) {
    console.log(`Applying to discipline with ID ${id}`);
  }

  viewDiscipline(id: number | undefined) {
    this.router.navigate(['discipline-details', id]);
  }
}
