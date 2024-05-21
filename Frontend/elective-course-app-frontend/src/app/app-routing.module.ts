import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentListComponent } from "./student-list/student-list.component";
import { CreateStudentComponent } from "./create-student/create-student.component";
import { UpdateStudentComponent } from "./update-student/update-student.component";
import { StudentDetailsComponent } from "./student-details/student-details.component";
import { EnrollmentListComponent } from "./enrollment-list/enrollment-list.component";
import { CreateEnrollmentComponent } from "./create-enrollment/create-enrollment.component";
import { UpdateEnrollmentComponent } from "./update-enrollment/update-enrollment.component";
import { EnrollmentDetailsComponent } from "./enrollment-details/enrollment-details.component";
import { DisciplineListComponent } from "./discipline-list/discipline-list.component"; // Import the discipline components
import { CreateDisciplineComponent } from "./create-discipline/create-discipline.component";
import { UpdateDisciplineComponent } from "./update-discipline/update-discipline.component";
import { DisciplineDetailsComponent } from "./discipline-details/discipline-details.component";
import {LoginComponent} from "./login/login.component";
import {AdminComponent} from "./admin/admin.component";
import {LoginlayoutComponent} from "./loginlayout/loginlayout.component";
import {StudentLayoutComponent} from "./student-layout/student-layout.component";
import {AdminLayoutComponent} from "./admin-layout/admin-layout.component";
import {ApplyListComponent} from "./apply-list/apply-list.component";
import {Student} from "./student";

const routes: Routes = [

  {
    path: 'create-student',
    component: AdminLayoutComponent,
    children: [
      { path: '', component: CreateStudentComponent }
    ]
  },
  {
    path: 'students-details',
    component: AdminLayoutComponent,
    children: [
      { path: '', component: StudentListComponent }
    ]
  },
  {
    path: 'update-student/:id',
    component: AdminLayoutComponent,
    children: [
      { path: '', component: UpdateStudentComponent }
    ]
  },
  { path: 'student-details/:id', component: StudentDetailsComponent },
  {
    path: 'enrollments',
    component: AdminLayoutComponent,
    children: [
      { path: '', component: EnrollmentListComponent }
    ]
  },
  {
    path: 'create-enrollment',
    component: AdminLayoutComponent,
    children: [
      { path: '', component: CreateEnrollmentComponent }
    ]
  },
  { path: 'update-enrollment/:id', component: UpdateEnrollmentComponent },
  { path: 'enrollment-details/:id', component: EnrollmentDetailsComponent },
  {
    path: 'disciplines',
    component: AdminLayoutComponent,
    children: [
      { path: '', component: DisciplineListComponent }
    ]
  },
  {
    path: 'create-discipline',
    component: AdminLayoutComponent,
    children: [
      { path: '', component: CreateDisciplineComponent }
    ]
  },
  {
    path: 'update-discipline/:id',
    component: AdminLayoutComponent,
    children: [
      { path: '', component: UpdateDisciplineComponent }
    ]
  },
  {
    path: 'discipline-details/:id',
    component: AdminLayoutComponent,
    children: [
      { path: '', component: DisciplineDetailsComponent }
    ]
  },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {
    path: 'login',
    component: LoginlayoutComponent,
    children: [
      { path: '', component: LoginComponent }
    ]
  },
  {
    path: 'students',
    component: StudentLayoutComponent,

  },
  {
    path: 'admin',
    component: AdminLayoutComponent,
    children: [
      { path: '', component: AdminComponent }
    ]
  },
  {
    path: 'apply-list',
    component: StudentLayoutComponent,
    children: [
      { path: '', component: ApplyListComponent }
    ]
  },
  {
    path: 'students',
    component: StudentLayoutComponent,
    children: [
      { path: 'apply-list', component: ApplyListComponent } // Define route for apply-list under students
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
