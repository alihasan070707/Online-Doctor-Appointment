import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SetScheduleComponent } from './set-schedule.component';

describe('SetScheduleComponent', () => {
  let component: SetScheduleComponent;
  let fixture: ComponentFixture<SetScheduleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SetScheduleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SetScheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
