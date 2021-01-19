import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorRegisterationComponent } from './doctor-registeration.component';

describe('DoctorRegisterationComponent', () => {
  let component: DoctorRegisterationComponent;
  let fixture: ComponentFixture<DoctorRegisterationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorRegisterationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorRegisterationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
