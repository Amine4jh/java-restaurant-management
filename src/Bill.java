public class Bill {
    protected int billId;
    protected Order order;
    protected double totalBeforeTax;
    protected double vat;
    protected double serviceFee;
    protected double total;

    Bill (int billId, Order order, double totalBeforeTax, double vat, double serviceFee, double total) {
        this.billId = billId;
        this.order = order;
        this.totalBeforeTax = totalBeforeTax;
        this.vat = vat;
        this.serviceFee = serviceFee;
        this.total = total;
    }

    // --- SETTERS ---

    void setBillId(int billId) {
        this.billId = billId;
    }

    void setOrder(Order order) {
        this.order = order;
    }

    void setTotalBeforeTax(double totalBeforeTax) {
        this.totalBeforeTax = totalBeforeTax;
    }

    void setVat(double vat) {
        this.vat = vat;
    }

    void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    void setTotal(double total) {
        this.total = total;
    }

    // --- GETTERS ---

    int getBillId() {
        return this.billId;
    }

    Order getOrder() {
        return this.order;
    }

    double getTotalBeforeTax () {
        return this.totalBeforeTax;
    }

    double getVat() {
        return this.vat;
    }

    double getServiceFee() {
        return this.serviceFee;
    }

    double getTotal() {
        return this.total;
    }

    // Other class methods

    void showInfo () {
        System.out.println("Bill ID: " + this.billId + ", Order ID: " + this.order.orderId + ", Total Before Tax: " + this.totalBeforeTax + ", VAT: " + this.vat + ", Service Fee: " + this.serviceFee + ", Total: " + this.total);
    }

    double calculateTotal () {
        this.total = this.total + (this.total * (this.vat / 100)) + (this.total * (this.serviceFee / 100));
        return this.total;
    }
}
