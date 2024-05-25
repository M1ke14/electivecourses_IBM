import {Component, OnInit} from '@angular/core';
import {SharedService} from "../shared.service";

@Component({
  selector: 'app-admin-layout',
  templateUrl: './admin-layout.component.html',
  styleUrl: './admin-layout.component.css'
})
export class AdminLayoutComponent implements OnInit {
  title = 'Admin Page';
  constructor(private sharedService: SharedService) {}

  showEnrollments() {
    this.sharedService.setEnrollmentsVisible(true);
  }

  hideEnrollments() {
    this.sharedService.setEnrollmentsVisible(false);
  }

  ngOnInit(): void { }
}
