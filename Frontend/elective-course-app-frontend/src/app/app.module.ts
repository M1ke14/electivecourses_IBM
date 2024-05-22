import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { HttpClientModule, HttpClient, HttpClientXsrfModule } from '@angular/common/http';
import { CreateStudentComponent } from './create-student/create-student.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { UpdateStudentComponent } from './update-student/update-student.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { LandingComponent } from './landing/landing.component';
import { EnrollmentListComponent } from './enrollment-list/enrollment-list.component';
import { CreateEnrollmentComponent } from './create-enrollment/create-enrollment.component';
import { EnrollmentDetailsComponent } from './enrollment-details/enrollment-details.component';
import { UpdateEnrollmentComponent } from './update-enrollment/update-enrollment.component';
import { CreateDisciplineComponent } from './create-discipline/create-discipline.component';
import { DisciplineDetailsComponent } from './discipline-details/discipline-details.component';
import { DisciplineListComponent } from './discipline-list/discipline-list.component';
import { UpdateDisciplineComponent } from './update-discipline/update-discipline.component';
import {LoginComponent} from "./login/login.component";
import {AdminComponent} from "./admin/admin.component";
import { LoginlayoutComponent } from './loginlayout/loginlayout.component';
import { StudentLayoutComponent } from './student-layout/student-layout.component';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import {ApplyListComponent} from "./apply-list/apply-list.component";

@NgModule({
  declarations: [
    AdminComponent,
    AppComponent,
    StudentListComponent,
    CreateStudentComponent,
    UpdateStudentComponent,
    StudentDetailsComponent,
    LandingComponent,
    EnrollmentListComponent,
    CreateEnrollmentComponent,
    EnrollmentDetailsComponent,
    UpdateEnrollmentComponent,
    CreateDisciplineComponent,
    DisciplineDetailsComponent,
    DisciplineListComponent,
    LoginComponent,
    UpdateDisciplineComponent,
    LoginlayoutComponent,
    StudentLayoutComponent,
    AdminLayoutComponent,
    ApplyListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'XSRF-TOKEN',
      headerName: 'X-XSRF-TOKEN',
    }),
    FormsModule,
  ],
  providers: [
    { provide: HttpClient, useClass: HttpClient },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
