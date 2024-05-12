import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Discipline } from '../discipline';
import { DisciplineService } from '../discipline.service';

@Component({
  selector: 'app-create-discipline',
  templateUrl: './create-discipline.component.html',
  styleUrls: ['./create-discipline.component.css']
})
export class CreateDisciplineComponent implements OnInit {
  discipline: Discipline = {
    id: 0,
    name: '',
    maxStudents: 0,
    studyYear: 0,
    category: '',
    teacher: '',
    enrollments: []
  };

  constructor(
    private disciplineService: DisciplineService,
    private router: Router
  ) {}

  ngOnInit() {}

  onSubmit() {
    this.disciplineService.createDiscipline(this.discipline).subscribe(
      data => {
        console.log('Discipline created successfully:', data);
        this.goToDisciplineList();
      },
      error => {
        console.error('Error creating discipline:', error);
        // Handle error, e.g., display error message to the user
      }
    );
  }

  goToDisciplineList() {
    this.router.navigate(['/disciplines']);
  }
}
