public class Bill {
    int billId;
    Order order;
    double totalBeforeTax;
    double vat;
    double serviceFee;
    double total;

    Bill (int billId, Order order, double totalBeforeTax, double vat, double serviceFee, double total) {
        this.billId = billId;
        this.order = order;
        this.totalBeforeTax = totalBeforeTax;
        this.vat = vat;
        this.serviceFee = serviceFee;
        this.total = total;
    }

    void showInfo () {
        System.out.println("Bill ID: " + this.billId + ", Order ID: " + this.order.orderId + ", Total Before Tax: " + this.totalBeforeTax + ", VAT: " + this.vat + ", Service Fee: " + this.serviceFee + ", Total: " + this.total);
    }

    double calculateTotal () {
        this.total = this.total + (this.total * (this.vat / 100)) + (this.total * (this.serviceFee / 100));
        return this.total;
    }
}
