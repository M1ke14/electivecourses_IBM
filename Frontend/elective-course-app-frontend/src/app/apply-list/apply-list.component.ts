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
  enrolledDisciplines: Discipline[] = [];
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
    this.disciplineService.getDisciplinesList().subscribe(data => {
      this.disciplines = data;
      this.enrollStudent(); // Automatically enroll the student based on the fetched disciplines
    });
  }

  private getStudentIdFromStorage(): number | undefined {
    const loggedInStudentId = localStorage.getItem('loggedInStudentId');
    return loggedInStudentId ? Number(loggedInStudentId) : undefined;
  }

  private getDisciplines(studentId: number) {
    this.disciplineService.getDisciplinesForStudent(studentId).subscribe(data => {
      this.disciplines = data;
      this.enrollStudent(); // Automatically enroll the student based on the fetched disciplines
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
      this.enrollStudent(); // Enroll student after updating the discipline order
    }
  }

  getPositions(): { id: number | undefined; position: number }[] {
    return this.disciplines.map((discipline, index) => ({
      id: discipline.id,
      position: index
    }));
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

  enrollStudent(): void {
    if (!this.studentId) {
      console.error('No student is logged in');
      return;
    }


    // Separate disciplines by year
    const yearOneDisciplines = this.disciplines.filter(discipline => discipline.studyYear === 1);
    const yearTwoDisciplines = this.disciplines.filter(discipline => discipline.studyYear === 2);
    const yearThreeDisciplines = this.disciplines.filter(discipline => discipline.studyYear === 3);

    // Select top disciplines based on the priority
    const selectedDisciplines = [
      ...yearOneDisciplines.slice(0, 1), // One subject from year one
      ...yearTwoDisciplines.slice(0, 2), // Two subjects from year two
      ...yearThreeDisciplines.slice(0, 3) // Three subjects from year three
    ];

    // Clear the current enrolledDisciplines
    this.enrolledDisciplines = [];

    // Enroll the student in selected disciplines
    selectedDisciplines.forEach(discipline => {
      if (discipline.maxStudents != null && discipline.maxStudents > 0 && !this.enrollmentsVisible) {
        discipline.maxStudents -= 1;
        this.enrolledDisciplines.push(discipline); // Add to enrolled list
      }
    });
  }
}
