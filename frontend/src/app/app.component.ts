import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <nav>
      <a routerLink="/products">Products</a> |
      <a routerLink="/cart">Cart</a> |
      <a routerLink="/orders">Orders</a>
    </nav>
    <router-outlet></router-outlet>
  `
})
export class AppComponent {}
