import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { authGuard } from '../core/guards/auth.guard';

const routes: Routes = [
  { path: 'products', canActivate: [authGuard], loadChildren: () => import('../features/products/products.module').then(m => m.ProductsModule) },
  { path: 'cart', canActivate: [authGuard], loadChildren: () => import('../features/cart/cart.module').then(m => m.CartModule) },
  { path: 'orders', canActivate: [authGuard], loadChildren: () => import('../features/orders/orders.module').then(m => m.OrdersModule) },
  { path: '', pathMatch: 'full', redirectTo: 'products' }
];

@NgModule({ imports: [RouterModule.forRoot(routes)], exports: [RouterModule] })
export class AppRoutingModule {}
