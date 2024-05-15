import { Component, OnInit } from '@angular/core';
import { Discipline } from "../discipline";
import { DisciplineService } from "../discipline.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-discipline-list',
  templateUrl: './discipline-list.component.html',
  styleUrls: ['./discipline-list.component.css']
})
export class DisciplineListComponent implements OnInit {
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

  disciplineDetails(id: number | undefined) {
    this.router.navigate(['discipline-details', id]);
  }

  updateDiscipline(id: number | undefined) {
    this.router.navigate(['update-discipline', id]);
  }

  deleteDiscipline(id: number | undefined) {
    this.disciplineService.deleteDiscipline(id).subscribe(data=> {
      console.log(data);
      this.getDisciplines();
    })
  }
}
