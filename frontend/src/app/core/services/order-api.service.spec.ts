import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { OrderApiService } from './order-api.service';

describe('OrderApiService', () => {
  let service: OrderApiService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({ imports: [HttpClientTestingModule] });
    service = TestBed.inject(OrderApiService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should call addToCart endpoint', () => {
    service.addToCart('C1', 'P1', 2).subscribe();
    const request = httpMock.expectOne('/api/orders/cart/add');
    expect(request.request.method).toBe('POST');
    request.flush({ id: '1', customerId: 'C1', lines: { P1: 2 }, status: 'CART' });
  });
});
