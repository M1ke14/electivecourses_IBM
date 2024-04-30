import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app/app.component';
import { HomeComponent } from './app/home/home.component';
import { AboutComponent } from './app/about/about.component';
import { AdminComponent } from './app/admin/admin.component';
import { StudentComponent } from './app/student/student.component';
import { CoursesComponent } from './app/courses/courses.component';
import { ApplicationsComponent } from './app/applications/applications.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, data: { title: 'Home' } },
  { path: 'about', component: AboutComponent, data: { title: 'About' } },
  { path: 'admin', component: AdminComponent, data: { title: 'Admin Page' } },
  { path: 'student', component: StudentComponent, data: { title: 'Student Page' } },
  { path: 'courses', component: CoursesComponent, data: { title: 'Courses Page' } },
  { path: 'applications', component: ApplicationsComponent, data: { title: 'Applications Page' } }
];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    StudentComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
