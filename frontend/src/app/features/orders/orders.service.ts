import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderApiService } from '../../core/services/order-api.service';
import { Order } from '../../core/models/order.model';

@Injectable()
export class OrdersService {
  constructor(private readonly orderApiService: OrderApiService) {}

  confirm(orderId: string): Observable<Order> {
    return this.orderApiService.confirm(orderId);
  }

  cancel(orderId: string): Observable<Order> {
    return this.orderApiService.cancel(orderId);
  }
}
