  import { Injectable } from '@angular/core';
  import {HttpClient, HttpHeaders} from "@angular/common/http";
  import {catchError, map, Observable, tap, throwError} from "rxjs";
  import { Student } from "./student";
  import {Admin} from "./admin";

  @Injectable({
    providedIn: 'root'
  })
  export class StudentService {

    private baseURL = "http://localhost:8080/api/student";
    private getURL = `${this.baseURL}/getAllStudents`;
    private getByIdURL = `${this.baseURL}/getStudentById`
    private createURL = `${this.baseURL}/addStudent`;
    private updateURL = `${this.baseURL}/updateStudent`;
    private deleteURL= `${this.baseURL}/deleteStudentById`;
    private loginURL = `${this.baseURL}/loginStudent`

    constructor(private httpClient: HttpClient) { }

    getStudentsList(): Observable<Student[]> {
      return this.httpClient.get<Student[]>(this.getURL);
    }

    createStudent(student: Student): Observable<Student> {
      student.userType = 'student';
      student.enrollment = [];
      return this.httpClient.post<Student>(this.createURL, student);
    }

    getStudentById(id: number | undefined): Observable<Student> {
      return this.httpClient.get<Student>(`${this.getByIdURL}/${id}`);
    }

    updateStudent(id: number | undefined, student: Student): Observable<Student> {
      return this.httpClient.put<Student>(`${this.updateURL}/${student.id}`, student);
    }

    deleteStudent(id: number | undefined): Observable<Student> {
      return this.httpClient.delete<Student>(`${this.deleteURL}/${id}`);
    }

    loginStudent(student: Student): Observable<Student | null> {
      const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
      return this.httpClient.post<Student>(this.loginURL, student, { headers }).pipe(
          catchError(error => {
            console.error('Error logging in:', error);
            return throwError('Error logging in');
          })
      );
    }

  }
