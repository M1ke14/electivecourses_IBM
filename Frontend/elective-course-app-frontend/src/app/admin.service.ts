import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, map, Observable, tap, throwError} from "rxjs";
import { Admin } from "./admin";

@Injectable({
  providedIn: 'root'
})
export class AdminService {


  private baseURL = "http://localhost:8080/api/admin";
  private loginURL = `${this.baseURL}/loginAdmin`;


  constructor(private httpClient: HttpClient) {
  }

  loginAdmin(admin: Admin): Observable<boolean> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.post<void>(this.loginURL, admin, { headers, observe: 'response' }).pipe(
      tap(response => {
        if (response.status !== 200) {
          throw new Error('Invalid response from server');
        }
      }),
      map(response => true),
      catchError(error => {
        console.error('Error logging in:', error);
        return throwError('Error logging in');
      })
    );
  }

}
