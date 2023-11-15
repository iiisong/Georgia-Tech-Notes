import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/** Controls the input for the To-Do List.
 * @author Kaitlyn
 * @version 1.0
 */
public class ToDoListInput extends VBox {
    private static Label tasksCompletedLabel = new Label();
    private static Label currentTasksLabel = new Label();
    private static int tasksCompleted;
    private static int currentTasks;

    /** Class to manage input.
     * @author Kaitlyn
     * @version 1.0
     */
    public ToDoListInput() {
        /* Create a name box. */
        TextField nameBox = new TextField();
        nameBox.setPromptText("TASK NAME");
        nameBox.setStyle("-fx-border-color: black");
        this.setPrefWidth(300);
        this.setSpacing(30);
        this.setStyle("-fx-border-color: black");
        getChildren().add(nameBox);

        /* Setting the hours box. */
        ObservableList<Integer> numHoursOptions = FXCollections.observableArrayList(1, 2, 3, 4, 5);
        ComboBox<Integer> hoursBox = new ComboBox<Integer>(numHoursOptions);
        hoursBox.setMinWidth(150);
        hoursBox.setPromptText("TASK HOURS");


        /* Setting the type box. */
        ObservableList<String> typeOptions = FXCollections.observableArrayList("STUDY", "SHOP",
                "COOK", "SLEEP");
        ComboBox<String> typeBox = new ComboBox<String>(typeOptions);
        typeBox.setMinWidth(150);
        typeBox.setPromptText("TASK TYPE");

        /* Make the hours and type into an HBox. */
        HBox typeAndHours = new HBox();
        typeAndHours.getChildren().add(hoursBox);
        typeAndHours.getChildren().add(typeBox);
        getChildren().add(typeAndHours);


        makeQueueButtons(nameBox, hoursBox, typeBox);
        makeSortButtons();

        /* Make horizontal seperator to break up the text */
        Separator separator3 = new Separator();
        separator3.setMinWidth(300);
        getChildren().add(separator3);

        /* Make the statistics display */
        VBox display = new VBox();

        tasksCompletedLabel.setStyle("-fx-font: 16 Segoe;");
        currentTasksLabel.setStyle("-fx-font: 16 Segoe;");
        updateLabel();

        display.getChildren().add(tasksCompletedLabel);
        display.getChildren().add(currentTasksLabel);

        getChildren().add(display);

    }

    /** Making the sort by date, type and name buttons.
     */
    private void makeSortButtons() {
        /* Make horizontal seperator to break up the text */
        Separator separator2 = new Separator();
        separator2.setMinWidth(300);
        getChildren().add(separator2);

        /* Create and add the sort buttons. */
        Button sortName = new Button("NAME SORT");
        Button sortType = new Button("TYPE SORT");
        Button sortDate = new Button("HOURS SORT");
        VBox sort = new VBox();
        sortName.setMinWidth(300);
        sortType.setMinWidth(300);
        sortDate.setMinWidth(300);
        sort.getChildren().add(sortName);
        sort.getChildren().add(sortType);
        sort.getChildren().add(sortDate);
        sort.setSpacing(10);
        getChildren().add(sort);

        /* Implement sortName. */
        EventHandler<ActionEvent> sortingName = new EventHandler<ActionEvent>() {
            /** Handler for sorting by name.
             * @param e the action event
             */
            public void handle(ActionEvent e) {
                // Anonomous inner class
                Comparator<Item> compare = new Comparator<Item>() {
                    @Override
                    public int compare(Item item1, Item item2) {
                        return item1.getName().compareTo(item2.getName());
                    }
                };
                FXCollections.sort(Item.ITEMS, compare);
            }
        };
        /* Implement sortDate. */
        EventHandler<ActionEvent> sortingDate = new EventHandler<ActionEvent>() {
            /** Yet another handler for sorting date.
             * @param e the action event data
             */
            public void handle(ActionEvent e) {
                Comparator<Item> compare = new Comparator<Item>() {
                    @Override
                    public int compare(Item item1, Item item2) {
                        return (((Integer) item1.getHours()).compareTo(((Integer) item2.getHours())));
                    }
                };
                FXCollections.sort(Item.ITEMS, compare);
            }
        };
        /* Implement sortType. */
        EventHandler<ActionEvent> sortingType = new EventHandler<ActionEvent>() {
            /** Okay there are a lot of these handler methods.
             * @param e the action handler data
             */
            public void handle(ActionEvent e) {
                Comparator<Item> compare = new Comparator<Item>() {
                    @Override
                    public int compare(Item item1, Item item2) {
                        return item1.getType().compareTo(item2.getType());
                    }
                };
                FXCollections.sort(Item.ITEMS, compare);
            }
        };
        sortName.setOnAction(sortingName);
        sortDate.setOnAction(sortingDate);
        sortType.setOnAction(sortingType);
    }

    /** makeQueueButtons making the queue and dequeue buttons.
     * @param nameBox the namebox
     * @param hoursBox the hoursbox
     * @param typeBox the typebox
     */
    private void makeQueueButtons(TextField nameBox, ComboBox<Integer> hoursBox,
            ComboBox<String> typeBox) {
        /* Make horizontal seperator to break up the text */
        Separator separator1 = new Separator();
        separator1.setMinWidth(300);
        getChildren().add(separator1);
        /* Creating enqueue and dequeue buttons on a HBox. */
        Button enqueue = new Button("ENQUEUE");
        Button dequeue = new Button("DEQUEUE");
        HBox queuing = new HBox();
        enqueue.setMinWidth(150);
        enqueue.setMinHeight(150);
        dequeue.setMinWidth(150);
        dequeue.setMinHeight(150);

        queuing.getChildren().add(enqueue);
        queuing.getChildren().add(dequeue);
        getChildren().add(queuing);

        EventHandler<ActionEvent> queuingEvent = new EventHandler<ActionEvent>() {
            /** Handler for queuing event.
             * @param e what happened in the action
             */
            public void handle(ActionEvent e) {
                String name = nameBox.getText().trim();
                if (name == null || name.length() == 0) {
                    showWarning("Must input name for the task!");
                    return;
                }
                Integer hours = hoursBox.getValue();
                if (hours == null) {
                    showWarning("Must input hours for the task!");
                    return;
                }
                String type = typeBox.getValue();
                if (type == null) {
                    showWarning("Must input task for the task!");
                    return;
                }
                nameBox.clear();
                typeBox.setValue(null);
                hoursBox.setValue(null);
                Item findItem = Item.findItem(name);
                if (findItem == null) {
                    createTask(name, hours, type);
                    return;
                }

                if (findItem.getType() == Type.valueOf(type) && findItem.getHours() != hours) {
                    findItem.setHours(hours);
                    // Triggering refresh
                    Item.ITEMS.add(null);
                    Item.ITEMS.remove(null);
                    showWarning("Updated task!");
                    return;
                }
                showWarning("Duplicate task!");

            }

        };

        EventHandler<ActionEvent> dequeuingEvent = new EventHandler<ActionEvent>() {
            /** Handler for dequeuing event.
             * @param e the stored action event */
            public void handle(ActionEvent e) {
                if (Item.ITEMS.size() == 0) {
                    showWarning("No tasks to dequeue!");
                    return;
                }
                Item lowestIndexItem = Item.ITEMS.get(0);
                for (Item item : Item.ITEMS) {
                    if (item.getIndex() < lowestIndexItem.getIndex()) {
                        lowestIndexItem = item;
                    }
                }
                Item.ITEMS.remove(lowestIndexItem);
                finishTask();
            }
        };

        /* Add the equeue and queue buttons. */
        enqueue.setOnAction(queuingEvent);
        dequeue.setOnAction(dequeuingEvent);
    }

    /** Creates the warning popup with the given message.
     * @param warning the string to be displayed
     * @return Alert the alert
     */
    public static Alert showWarning(String warning) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(warning);
        alert.showAndWait();
        return alert;
    }

    /** Update Tasks Completed and Current Tasks when queuing or dequeuing is done.
     */
    public static void updateLabel() {
        tasksCompletedLabel.setText("     Tasks Completed: " + tasksCompleted);
        currentTasksLabel.setText("     Current Tasks: " + currentTasks);
    }

    /** Increments based on dequeuing a task.
     */
    public static void finishTask() {
        tasksCompleted++;
        currentTasks--;
        updateLabel();
    }

    /** A method to create a task (item) based on the values for the item.
     * @param name the name of the task
     * @param hours the number of hours (1-5) of the task
     * @param type the type (of four) of the task, passed in as a string.
     */
    public void createTask(String name, int hours, String type) {
        Item newItem = new Item(name, hours, type);
        Item.ITEMS.add(newItem);
        currentTasks++;
        updateLabel();
    }
}
