import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/order.model';

@Injectable({ providedIn: 'root' })
export class OrderApiService {
  constructor(private readonly http: HttpClient) {}
  addToCart(customerId: string, productId: string, quantity: number): Observable<Order> { return this.http.post<Order>('/api/orders/cart/add', { customerId, productId, quantity }); }
  removeFromCart(customerId: string, productId: string, quantity: number): Observable<Order> { return this.http.post<Order>('/api/orders/cart/remove', { customerId, productId, quantity }); }
  confirm(orderId: string): Observable<Order> { return this.http.post<Order>(`/api/orders/${orderId}/confirm`, {}); }
  cancel(orderId: string): Observable<Order> { return this.http.post<Order>(`/api/orders/${orderId}/cancel`, {}); }
}
