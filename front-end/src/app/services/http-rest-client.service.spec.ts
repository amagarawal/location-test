import { TestBed } from '@angular/core/testing';

import { HttpRestClientService } from './http-rest-client.service';

describe('HttpRestClientService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HttpRestClientService = TestBed.get(HttpRestClientService);
    expect(service).toBeTruthy();
  });
});
