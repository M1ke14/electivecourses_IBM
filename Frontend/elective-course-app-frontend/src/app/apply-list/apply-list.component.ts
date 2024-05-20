import { Component, OnInit } from '@angular/core';
import { Discipline } from "../discipline";
import { DisciplineService } from "../discipline.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-apply-list',
  templateUrl: './apply-list.component.html',
  styleUrls: ['./apply-list.component.css']
})
export class ApplyListComponent implements OnInit {
  disciplines: Discipline[] | undefined;

  constructor(private disciplineService: DisciplineService,
              private router: Router) { }

  ngOnInit(): void {
    this.getDisciplines();
  }

  private getDisciplines() {
    this.disciplineService.getDisciplinesList().subscribe(data => {
      this.disciplines = data;
    });
  }

  applyToDiscipline(id: number | undefined) {
    console.log(`Applying to discipline with ID ${id}`);
  }

  viewDiscipline(id: number | undefined) {
    this.router.navigate(['discipline-details', id]);
  }
}
