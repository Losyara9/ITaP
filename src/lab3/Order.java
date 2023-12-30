class Order {
    private String orderDate;
    private String products;
    private String status;

    @Override
    public String toString() {
        return "Дата заказа: " + this.orderDate + ", товары: " + this.products + ", статус: " + this.status;
    }
    public Order(String orderDate, String products, String status) {
        this.orderDate = orderDate;
        this.products = products;
        this.status = status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
