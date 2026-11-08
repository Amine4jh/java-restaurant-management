import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantData {

    public static Map<String, List<User>> users = new HashMap<>() {{
        put("admins", new ArrayList<>());
        put("waiters", new ArrayList<>());
        put("chefs", new ArrayList<>());
    }};

    public static List<Menu> menu = new ArrayList<>();
    public static List<Reservation> reservations = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<Bill> bills = new ArrayList<>();
    public static List<Table> tables = new ArrayList<>();
}
