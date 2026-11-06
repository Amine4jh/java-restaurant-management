public class Reservation {
    int reservationId;
    String clientName;
    int numberOfPeople;
    String date;
    String time;
    Table table;

    Reservation(int reservationId, String clientName, int numberOfPeople, String date, String time, Table table) {
        this.reservationId = reservationId;
        this.clientName = clientName;
        this.numberOfPeople = numberOfPeople;
        this.date = date;
        this.time = time;
        this.table = table;
    }

    void showInfo () {
        System.out.println("ID: " + this.reservationId + ", Client Name: " + this.clientName + ", Number of People: " + this.numberOfPeople + ", Date: " + this.date + ", Time: " + this.time + ", Table ID: " + this.table.tableNumber);

    }
}
