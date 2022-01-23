export class Order {
    id: number;
    symbol: string;
    side: string;
    stopPrice: number;
    price: number;
    quantity: number;
    createDate: Date;
    updateDate: Date;
    dueDate: Date;
    status: string;
  }