// apply-list.component.ts
import { Component, OnInit } from '@angular/core';
import { Discipline } from "../discipline";
import { DisciplineService } from "../discipline.service";
import { Router } from "@angular/router";
import { SharedService } from "../shared.service";
import { StudentService } from "../student.service";
import { EnrollmentService } from "../enrollment.service";
import { Enrollment } from "../enrollment";
import { Student } from "../student";

@Component({
  selector: 'app-apply-list',
  templateUrl: './apply-list.component.html',
  styleUrls: ['./apply-list.component.css']
})
export class ApplyListComponent implements OnInit {
  disciplines: Discipline[] = [];
  students: Student[] = [];
  filteredStudent: Student[]=[];
  enrollmentID: number =0
  enrollmentsVisible: boolean = true;
  studentId: number | undefined;
  student: Student | undefined;
  studentName: string ="";
  enrolledDisciplines: Discipline[] = [];
  enrollments: Enrollment[] = [];  // Store all enrollments
  filteredEnrollments: Enrollment[] = [];  // Store filtered enrollments

  constructor(
    private disciplineService: DisciplineService,
    private router: Router,
    private sharedService: SharedService,
    private enrollmentService: EnrollmentService,
    private studentService: StudentService
  ) {}

  ngOnInit(): void {
    this.fetchDisciplines();
    this.fetchEnrollments();
this.studentLoggedName();
    this.fetchStudent();// Fetch all enrollments on init
    this.studentId = this.getStudentIdFromStorage();
    if (this.studentId !== undefined) {
      this.getDisciplines(this.studentId);
    }
    this.sharedService.enrollmentsVisible$.subscribe(visible => {
      this.enrollmentsVisible = visible;
    });

  }

  fetchStudent(){
    this.studentService.getStudentsList().subscribe(data => {
      this.students = data;

    });
  }
  fetchDisciplines(): void {
    this.disciplineService.getDisciplinesList().subscribe(data => {
      this.disciplines = data;

    });
  }

  private getStudentIdFromStorage(): number | undefined {
    const loggedInStudentId = localStorage.getItem('loggedInStudentId');
    return loggedInStudentId ? Number(loggedInStudentId) : undefined;
  }
  studentLoggedName(){
    this.student= this.studentService.getStudentById(this.studentId);
  }

  private getDisciplines(studentId: number) {
    this.disciplineService.getDisciplinesForStudent(studentId).subscribe(data => {
      this.disciplines = data;
      this.enrollStudent();  // Automatically enroll the student based on the fetched disciplines
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
      this.enrollStudent();  // Enroll student after updating the discipline order
    }
  }

  getPositions(): { id: number | undefined; position: number }[] {
    return this.disciplines.map((discipline, index) => ({
      id: discipline.id,
      position: index
    }));
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

    this.studentService.getStudentById(this.studentId).subscribe(student => {
      const studentYear = student.studyYear;

      let selectedDisciplines: Discipline[] = [];

      if (studentYear === 1) {
        const yearOneDisciplines = this.disciplines.filter(discipline => discipline.studyYear === 1);
        selectedDisciplines = yearOneDisciplines.slice(0, 1);
      } else if (studentYear === 2) {
        const yearTwoDisciplines = this.disciplines.filter(discipline => discipline.studyYear === 2);
        selectedDisciplines = yearTwoDisciplines.slice(0, 2);
      } else if (studentYear === 3) {
        const yearThreeDisciplines = this.disciplines.filter(discipline => discipline.studyYear === 3);
        selectedDisciplines = yearThreeDisciplines.slice(0, 3);
      }

      this.enrolledDisciplines = [];

      selectedDisciplines.forEach(discipline => {
        if (discipline.maxStudents != null && discipline.maxStudents > 0 ) {

          this.enrolledDisciplines.push(discipline);

          const enrollment: Enrollment = {
            id: this.enrollmentID+1,
            priority: 'yes',
            studentName: student.name,
            disciplineName: discipline.name
          };
         if( !this.enrollmentsVisible){
          discipline.maxStudents -= 1;
          this.enrollmentService.createEnrollment(enrollment).subscribe(() => {
            console.log('Enrollment created successfully');
          }, error => {
            console.error('Error creating enrollment:', error);
          });
         }
        }
      });
    }, error => {
      console.error('Error fetching student details:', error);
    });
  }
  studentEnrolled(): void {
    this.enrollStudent();
    const enrolledStudentNames = this.filteredEnrollments.map(enrollment => enrollment.studentName);
    this.filteredStudent = this.students.filter(student => enrolledStudentNames.includes(student.name));
  }
  // Fetch all enrollments
  fetchEnrollments(): void {
    this.enrollmentService.getEnrollmentList().subscribe(data => {
      this.enrollments = data;
    }, error => {
      console.error('Error fetching enrollments:', error);
    });
  }

  // Filter enrollments by discipline name
  filterEnrollmentsByDiscipline(disciplineName: string | undefined): void {
    this.filteredEnrollments = this.enrollments.filter(enrollment => enrollment.disciplineName === disciplineName) ;
  }
}
