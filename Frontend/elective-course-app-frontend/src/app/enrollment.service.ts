import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Enrollment } from "./enrollment";

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {

  private baseURL = "http://localhost:8080/api/enrollment";
  private getURL = `${this.baseURL}/getAllEnrollments`;
  private getByIdURL = `${this.baseURL}/getEnrollmentById`;
  private createURL = `${this.baseURL}/addEnrollment`;
  private updateURL = `${this.baseURL}/updateEnrollment`;
  private deleteURL= `${this.baseURL}/deleteEnrollmentById`;

  constructor(private httpClient: HttpClient) { }

  getEnrollmentList(): Observable<Enrollment[]> {
    return this.httpClient.get<Enrollment[]>(this.getURL);
  }

  createEnrollment(enrollment: Enrollment): Observable<Enrollment> {
    return this.httpClient.post<Enrollment>(this.createURL, enrollment);
  }
  

  getEnrollmentById(id: number | undefined): Observable<Enrollment> {
    return this.httpClient.get<Enrollment>(`${this.getByIdURL}/${id}`);
  }

  updateEnrollment(id: number | undefined, enrollment: Enrollment): Observable<Enrollment> {
    return this.httpClient.put<Enrollment>(`${this.updateURL}/${id}`, enrollment);
  }

  deleteEnrollment(id: number | undefined): Observable<void> {
    return this.httpClient.delete<void>(`${this.deleteURL}/${id}`);
  }
}
