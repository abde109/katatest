export interface OrderLine { productId: string; quantity: number; }
export interface Order { id: string; customerId: string; lines: Record<string, number>; status: 'CART' | 'CONFIRMED' | 'CANCELED'; }
