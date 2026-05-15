import { Component, Input } from '@angular/core';
import { ProductViewModel } from '../../products.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent {
  @Input({ required: true }) product!: ProductViewModel;
}
