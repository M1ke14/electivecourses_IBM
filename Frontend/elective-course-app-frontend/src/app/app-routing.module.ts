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

const routes: Routes = [
  { path: 'admin', component: AdminComponent },
  { path: 'login', component: LoginComponent },
  { path: 'students', component: StudentListComponent },
  { path: 'students', component: StudentListComponent },
  { path: 'create-student', component: CreateStudentComponent },
  { path: 'update-student/:id', component: UpdateStudentComponent },
  { path: 'student-details/:id', component: StudentDetailsComponent },
  { path: 'enrollments', component: EnrollmentListComponent },
  { path: 'create-enrollment', component: CreateEnrollmentComponent },
  { path: 'update-enrollment/:id', component: UpdateEnrollmentComponent },
  { path: 'enrollment-details/:id', component: EnrollmentDetailsComponent },
  { path: 'disciplines', component: DisciplineListComponent },
  { path: 'create-discipline', component: CreateDisciplineComponent },
  { path: 'update-discipline/:id', component: UpdateDisciplineComponent },
  { path: 'discipline-details/:id', component: DisciplineDetailsComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
