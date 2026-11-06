public class Table {
    int tableNumber;
    int capacity;
    boolean isOccupied = false;

    Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    void showInfo () {
        System.out.println("Table Number: " + this.tableNumber + ", Capacity: " + this.capacity + "," + (isOccupied ? "The table is occupied!" : "The table is available!"));
    }

    void occupyTable () {
        this.isOccupied = true;
    }

    void freeTable () {
        this.isOccupied = false;
    }
}
