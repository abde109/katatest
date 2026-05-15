import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CartPageComponent } from './cart.page';

const routes: Routes = [{ path: '', component: CartPageComponent }];

@NgModule({ declarations: [CartPageComponent], imports: [CommonModule, RouterModule.forChild(routes)] })
export class CartModule {}
