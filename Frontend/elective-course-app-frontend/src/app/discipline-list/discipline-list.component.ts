import { Component, OnInit } from '@angular/core';
import { Discipline } from "../discipline";
import { DisciplineService } from "../discipline.service";
import { Router } from "@angular/router";
import { FilterMetadata } from 'primeng/api';
import {Student} from "../student"; // Import FilterMetadata from PrimeNG


@Component({
  selector: 'app-discipline-list',
  templateUrl: './discipline-list.component.html',
  styleUrls: ['./discipline-list.component.css']
})
export class DisciplineListComponent implements OnInit {
  disciplines: Discipline[] = [];
  selectedStudents: Student[] = [];
  metaKey: boolean = false;
  filters: { [key: string]: FilterMetadata | FilterMetadata[] } = {}; // Ensure filters match the expected type


  constructor(private disciplineService: DisciplineService,
              private router: Router) { }

  ngOnInit(): void {
    this.getDisciplines();
  }

  private getDisciplines() {
    this.disciplineService.getDisciplinesList().subscribe(data => {
      this.disciplines = data;
      this.applyFilters();
    });
  }

    applyFilter(value: string, field: string) {
        if (!this.filters[field]) {
            this.filters[field] = {};
        }
        (this.filters[field] as FilterMetadata).value = value;
        this.applyFilters();
    }

    private applyFilters() {
        this.disciplineService.getDisciplinesList().subscribe(data => {
            this.disciplines = data.filter(discipline => {
                return Object.keys(this.filters).every(key => {
                    // Ensure that this.filters[key] is of type FilterMetadata
                    const filter = this.filters[key] as FilterMetadata;
                    return discipline[key]?.toString().toLowerCase().includes(filter.value.toLowerCase());
                });
            });
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
