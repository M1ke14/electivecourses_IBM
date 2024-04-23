import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app/app.component';
import { HomeComponent } from './app/home/home.component';
import { AboutComponent } from './app/about/about.component';
import { AdminComponent } from './app/admin/admin.component';
import { StudentComponent } from './app/student/student.component';

const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' }, // Redirect to /home by default
    { path: 'home', component: HomeComponent, data: { title: 'Home' } },
    { path: 'about', component: AboutComponent, data: { title: 'About' } },
    { path: 'admin', component: AdminComponent, data: { title: 'Admin Page' } },
    { path: 'student', component: StudentComponent, data: { title: 'Student Page' } }
  ];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
