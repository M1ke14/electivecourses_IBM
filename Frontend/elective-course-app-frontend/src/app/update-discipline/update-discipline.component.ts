import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Discipline } from '../discipline';
import { DisciplineService } from '../discipline.service';

@Component({
  selector: 'app-update-discipline',
  templateUrl: './update-discipline.component.html',
  styleUrls: ['./update-discipline.component.css']
})
export class UpdateDisciplineComponent implements OnInit {
  id: number | undefined;
  discipline: Discipline = {
    id: 0,
    name: '',
    maxStudents: 0,
    studyYear: 0,
    category: '',
    teacher: ''
  };

  constructor(
    private disciplineService: DisciplineService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];

    this.disciplineService.getDisciplineById(this.id).subscribe(
      data => {
        this.discipline = data;
      },
      error => {
        console.error('Error fetching discipline:', error);
        // Handle error, e.g., display error message to the user
      }
    );
  }

  onSubmit() {
    this.disciplineService.updateDiscipline(this.id, this.discipline).subscribe(
      () => {
        this.goToDisciplineList();
      },
      error => {
        console.error('Error updating discipline:', error);
        // Handle error, e.g., display error message to the user
      }
    );
  }

  goToDisciplineList() {
    this.router.navigate(['/disciplines']);
  }
}
