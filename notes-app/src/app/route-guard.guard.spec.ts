import { TestBed } from '@angular/core/testing';

import { RouteGaurdGuard } from './route-guard.guard';

describe('RouteGuardGuard', () => {
  let guard: RouteGaurdGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(RouteGaurdGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
