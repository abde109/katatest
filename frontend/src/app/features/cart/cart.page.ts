import { Component } from '@angular/core';
import { CartService } from './cart.service';
import { Order } from '../../core/models/order.model';

@Component({
  selector: 'app-cart-page',
  template: `
    <section>
      <h2>Cart</h2>
      <button (click)="addSampleProduct()">Add P1</button>
      <pre *ngIf="lastCartState">{{ lastCartState | json }}</pre>
    </section>
  `
})
export class CartPageComponent {
  lastCartState?: Order;

  constructor(private readonly cartService: CartService) {}

  addSampleProduct(): void {
    this.cartService.addProduct('C1', 'P1', 1).subscribe(order => {
      this.lastCartState = order;
    });
  }
}
