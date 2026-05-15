import { Component } from '@angular/core';
import { OrdersService } from './orders.service';
import { Order } from '../../core/models/order.model';

@Component({
  selector: 'app-orders-page',
  template: `
    <section>
      <h2>Orders</h2>
      <button (click)="cancelSampleOrder()">Cancel sample order</button>
      <pre *ngIf="lastOrderState">{{ lastOrderState | json }}</pre>
    </section>
  `
})
export class OrdersPageComponent {
  lastOrderState?: Order;

  constructor(private readonly ordersService: OrdersService) {}

  cancelSampleOrder(): void {
    this.ordersService.cancel('sample-order-id').subscribe(order => {
      this.lastOrderState = order;
    });
  }
}
