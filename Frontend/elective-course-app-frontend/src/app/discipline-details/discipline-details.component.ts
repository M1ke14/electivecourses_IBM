// discipline-details.component.ts

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Discipline } from "../discipline";
import { DisciplineService } from "../discipline.service";

@Component({
  selector: 'app-discipline-details',
  templateUrl: './discipline-details.component.html',
  styleUrls: ['./discipline-details.component.css']
})
export class DisciplineDetailsComponent implements OnInit {
  id: number | undefined;
  discipline: Discipline | undefined;

  constructor(private route: ActivatedRoute, private disciplineService: DisciplineService) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.disciplineService.getDisciplineById(this.id).subscribe(data => {
      this.discipline = data;
    });
  }
}
