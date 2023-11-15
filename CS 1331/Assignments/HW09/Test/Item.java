import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

/**
 * Class to define the task items.
 * @author Kaitlyn
 * @version 1.0
 */
public class Item {
    /* Instance variables for the Item. */
    private String name;
    private Instant date;
    private int hours;
    private Type type;
    private Color color;
    private int index;

    /* A list of all of the Items. */
    public static final ObservableList<Item> ITEMS = FXCollections.observableArrayList();

    /**
     * Constructor for making a new Item.
     * @param name the name of the task
     * @param hours the number of hours the task will take
     * @param type the type of the task
     */
    public Item(String name, int hours, String type) {
        this.name = name;
        setHours(hours);
        setType(type);
        index = ITEMS.size() + 1;
    }

    /**
     * Finds if the name is already in the ITEMS list.
     * @param taskName the input name
     * @return an item if there's one with the same name, else return null
     */
    public static Item findItem(String taskName) {
        for (Item item : ITEMS) {
            if (item.getName().equals(taskName)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Set the number of hours and the date for the task.
     * @param hours the inputted number of hours
     */
    public void setHours(int hours) {
        Instant now = Instant.now();
        date = now.plus(hours, ChronoUnit.HOURS);
        this.hours = hours;

    }

    /**
     * Creates an enum type based on the taskType provided.
     * @param taskType the inputted type of the task
     */
    public void setType(String taskType) {
        type = Type.valueOf(taskType.trim().toUpperCase());

        switch (type) {
        case STUDY:
            color = Color.BLUE;
            break;
        case SHOP:
            color = Color.RED;
            break;
        case COOK:
            color = Color.AQUA;
            break;
        case SLEEP:
            color = Color.PINK;
            break;
        default:
            throw new IllegalArgumentException("Bad Type!");
        }
    }

    /**
     * ToString method for item.
     * @return String the String version of the task
     */
    public String toString() {
        Date asDate = Date.from(date);
        String formattedDate = String.format("%tc", asDate);

        return "\nTaskName: " + name + "\nTaskType: " + type.toString() + "\nTaskDate: "
                + formattedDate + "\nTaskHours: " + hours;
    }

    /**
     * Getter method for name.
     * @return String the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for date.
     * @return Instant the date
     */
    public Instant getDate() {
        return date;
    }

    /**
     * Setter method for date.
     * @param date the new date
     */
    public void setDate(Instant date) {
        this.date = date;
    }

    /**
     * Getter method for hours.
     * @return int the number of hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * Getter method for type.
     * @return Type the type of the task
     */
    public Type getType() {
        return type;
    }

    /**
     * Getter method for color.
     * @return Color the color of the task
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setter method for color.
     * @param color the new color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Getter method for index.
     * @return int index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Setter method for index.
     * @param index the new index
     */
    public void setIndex(int index) {
        this.index = index;
    }
}

