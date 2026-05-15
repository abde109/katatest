import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ProductsPageComponent } from './products.page';
import { ProductsService } from './products.service';

const routes: Routes = [{ path: '', component: ProductsPageComponent }];

@NgModule({
  declarations: [ProductsPageComponent],
  imports: [CommonModule, RouterModule.forChild(routes)],
  providers: [ProductsService]
})
export class ProductsModule {}
