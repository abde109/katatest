import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { OrdersPageComponent } from './orders.page';
import { OrdersService } from './orders.service';

const routes: Routes = [{ path: '', component: OrdersPageComponent }];

@NgModule({
  declarations: [OrdersPageComponent],
  imports: [CommonModule, RouterModule.forChild(routes)],
  providers: [OrdersService]
})
export class OrdersModule {}
