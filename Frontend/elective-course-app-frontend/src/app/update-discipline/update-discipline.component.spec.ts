import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDisciplineComponent } from './update-discipline.component';

describe('UpdateDisciplineComponent', () => {
  let component: UpdateDisciplineComponent;
  let fixture: ComponentFixture<UpdateDisciplineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateDisciplineComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateDisciplineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
