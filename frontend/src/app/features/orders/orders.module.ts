import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { OrdersPageComponent } from './orders.page';

const routes: Routes = [{ path: '', component: OrdersPageComponent }];

@NgModule({ declarations: [OrdersPageComponent], imports: [CommonModule, RouterModule.forChild(routes)] })
export class OrdersModule {}
