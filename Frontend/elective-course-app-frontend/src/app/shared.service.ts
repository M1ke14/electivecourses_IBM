import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  private enrollmentsVisibleSubject = new BehaviorSubject<boolean>(false);
  enrollmentsVisible$ = this.enrollmentsVisibleSubject.asObservable();

  setEnrollmentsVisible(visible: boolean) {
    this.enrollmentsVisibleSubject.next(visible);
  }
  constructor() {
  }
}
