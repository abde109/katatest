import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CartPageComponent } from './cart.page';
import { CartService } from './cart.service';

const routes: Routes = [{ path: '', component: CartPageComponent }];

@NgModule({
  declarations: [CartPageComponent],
  imports: [CommonModule, RouterModule.forChild(routes)],
  providers: [CartService]
})
export class CartModule {}
