import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderApiService } from '../../core/services/order-api.service';
import { Order } from '../../core/models/order.model';

@Injectable()
export class CartService {
  constructor(private readonly orderApiService: OrderApiService) {}

  addProduct(customerId: string, productId: string, quantity: number): Observable<Order> {
    return this.orderApiService.addToCart(customerId, productId, quantity);
  }

  removeProduct(customerId: string, productId: string, quantity: number): Observable<Order> {
    return this.orderApiService.removeFromCart(customerId, productId, quantity);
  }
}
