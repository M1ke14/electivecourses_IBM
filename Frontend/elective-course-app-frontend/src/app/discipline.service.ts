import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {catchError, Observable, tap, throwError} from "rxjs";
import { Discipline } from "./discipline";

@Injectable({
  providedIn: 'root'
})
export class DisciplineService {

  private baseURL = "http://localhost:8080/api/discipline";
  private getURL = `${this.baseURL}/getAllDisciplines`;
  private getByIdURL = `${this.baseURL}/getDisciplineById`;
  private createURL = `${this.baseURL}/addDiscipline`;
  private updateURL = `${this.baseURL}/updateDiscipline`;
  private deleteURL= `${this.baseURL}/deleteDisciplineById`;
  private disciplinesForStudentURL=`${this.baseURL}/student-disciplines`;

  constructor(private httpClient: HttpClient) { }

  getDisciplinesList(): Observable<Discipline[]> {
    return this.httpClient.get<Discipline[]>(this.getURL);
  }

  createDiscipline(discipline: Discipline): Observable<Discipline> {
    return this.httpClient.post<Discipline>(this.createURL, discipline);
  }

  getDisciplineById(id: number | undefined): Observable<Discipline> {
    return this.httpClient.get<Discipline>(`${this.getByIdURL}/${id}`);
  }

  updateDiscipline(id: number | undefined, discipline: Discipline): Observable<Discipline> {
    return this.httpClient.put<Discipline>(`${this.updateURL}/${discipline.id}`, discipline);
  }

  deleteDiscipline(id: number | undefined): Observable<Discipline> {
    return this.httpClient.delete<Discipline>(`${this.deleteURL}/${id}`);
  }

  getDisciplinesForStudent(studentId: number): Observable<Discipline[]> {
    console.log(`Fetching disciplines for studentId: ${studentId}`);
    return this.httpClient.get<Discipline[]>(`${this.disciplinesForStudentURL}/${studentId}`).pipe(
        tap(data => console.log('Received disciplines:', data)), // Add this console log
        catchError(error => {
          console.error('Error fetching disciplines:', error);
          return throwError(error);
        })
    );
  }
}
