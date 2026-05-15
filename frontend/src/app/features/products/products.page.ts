import { Component, OnInit } from '@angular/core';
import { ProductsService, ProductViewModel } from './products.service';

@Component({
  selector: 'app-products-page',
  template: `
    <section>
      <h2>Products</h2>
      <app-product *ngFor="let product of products" [product]="product"></app-product>
    </section>
  `
})
export class ProductsPageComponent implements OnInit {
  products: ProductViewModel[] = [];

  constructor(private readonly productsService: ProductsService) {}

  ngOnInit(): void {
    this.productsService.loadProducts().subscribe(products => {
      this.products = products;
    });
  }
}
