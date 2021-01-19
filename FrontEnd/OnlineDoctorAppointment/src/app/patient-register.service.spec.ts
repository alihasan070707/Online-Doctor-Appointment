import { TestBed } from '@angular/core/testing';

import { PatientRegisterService } from './patient-register.service';

describe('PatientRegisterService', () => {
  let service: PatientRegisterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PatientRegisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
