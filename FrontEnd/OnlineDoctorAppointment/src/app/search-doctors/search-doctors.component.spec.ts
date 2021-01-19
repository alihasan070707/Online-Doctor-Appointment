import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDoctorsComponent } from './search-doctors.component';

describe('SearchDoctorsComponent', () => {
  let component: SearchDoctorsComponent;
  let fixture: ComponentFixture<SearchDoctorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchDoctorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchDoctorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
