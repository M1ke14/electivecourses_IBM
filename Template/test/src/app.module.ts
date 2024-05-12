import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app/app.component';
import { StudentComponent } from './app/student/student.component';
import { AppRoutingModule } from './app/app-routing.module'; // Import AppRoutingModule

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule // Use AppRoutingModule for routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
