  import { Injectable } from '@angular/core';
  import { HttpClient } from "@angular/common/http";
  import { Observable } from "rxjs";
  import { Student } from "./student";

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
  }
