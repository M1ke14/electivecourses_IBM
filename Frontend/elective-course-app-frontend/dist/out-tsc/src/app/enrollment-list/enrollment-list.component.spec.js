import { TestBed } from '@angular/core/testing';
import { EnrollmentListComponent } from './enrollment-list.component';
describe('EnrollmentListComponent', () => {
    let component;
    let fixture;
    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [EnrollmentListComponent]
        })
            .compileComponents();
        fixture = TestBed.createComponent(EnrollmentListComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=enrollment-list.component.spec.js.map