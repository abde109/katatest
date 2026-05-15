import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface ProductViewModel {
  id: string;
  name: string;
  availableQuantity: number;
}

@Injectable()
export class ProductsService {
  constructor(private readonly httpClient: HttpClient) {}

  loadProducts(): Observable<ProductViewModel[]> {
    return this.httpClient.get<ProductViewModel[]>('/api/products');
  }
}
