import { Component,ViewChild,ElementRef,OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  @ViewChild('hidden', { read: ElementRef }) elementRef: ElementRef | undefined;

  constructor(
    private router: Router
  ) {}

  ngOnInit() {}


}
