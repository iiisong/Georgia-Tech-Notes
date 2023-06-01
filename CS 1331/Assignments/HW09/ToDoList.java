
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ToDoList extends Application {

    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        stage.setTitle("Todo List App");

        // main box everything is in 
        VBox mainBox = new VBox();

        // top title bar
        HBox titleBox = new HBox();
        Label title = new Label("Todo List");
        title.setStyle("-fx-font: 20 \"Comic Sans MS\";");
        titleBox.setStyle("-fx-border-width: 0 0 3 0; -fx-border-color: black;");
        titleBox.getChildren().add(title);
        titleBox.setAlignment(Pos.CENTER);

        // main interaction panels, list and input
        HBox sideBox = new HBox();
        
        // list of items
        ListView<Item> listView = new ListView<>(Item.ITEMS);
        listView.setStyle("-fx-border-color: black");
        HBox.setHgrow(listView, Priority.ALWAYS);

        // add content to sideBox
        sideBox.getChildren().addAll(inputView(), listView);

        // add sideBox back to mainbox
        mainBox.getChildren().addAll(titleBox, sideBox);
        VBox.setVgrow(mainBox, Priority.ALWAYS);

        // staging
        Scene scene = new Scene(mainBox, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Create vertical input panel.
     *
     * @return vbox object
     */
    public VBox inputView() {
        // resultant input box
        VBox inputBox = new VBox();

        // type and duration
        HBox taskInfoBox = new HBox();
        // type
        ObservableList<Integer> typesList = FXCollections.observableArrayList(1, 2, 3, 4, 5);
        ComboBox<Integer> typesDropdown = new ComboBox<Integer>(typesList);
        typesDropdown.setPromptText("Task Type");
        // duration
        ObservableList<Integer> durationsList = FXCollections.observableArrayList(1, 2, 3, 4, 5);
        ComboBox<Integer> durationDropdown = new ComboBox<Integer>(durationsList);
        durationDropdown.setPromptText("Task Length");
        taskInfoBox.getChildren().addAll(typesDropdown, durationDropdown);


        // text field and enqueue button
        HBox taskMainBox = new HBox();
        TextField nameBox = new TextField();
        nameBox.setPromptText("Insert Task Name");
        Button enqueueButton = new Button("ENQUEUE");
        taskMainBox.getChildren().addAll(nameBox, enqueueButton);

        EventHandler<ActionEvent> enqueue = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                nameBox.clear();
            }
        };

        enqueueButton.setOnAction(enqueue);

        // dequeue button
        HBox dequeueBox = new HBox();
        Button dequeueButton = new Button("DEQUEUE");
        dequeueBox.getChildren().addAll(dequeueButton);
        dequeueBox.setPadding(new Insets(10));
        dequeueBox.setAlignment(Pos.TOP_CENTER);

        HBox toggleBox = new HBox();
        Button toggleButton = new Button("Toggle");
        toggleBox.getChildren().addAll(toggleButton);
        toggleBox.setPadding(new Insets(10));
        toggleBox.setAlignment(Pos.TOP_CENTER);

        // sort buttons
        VBox sortBox = new VBox();
        HBox nameSort = sortView("Sort Name");
        HBox typeSort = sortView("Sort Type");
        HBox durationSort = sortView("Sort Duration");
        HBox timeSort = sortView("Sort Time");
        sortBox.getChildren().addAll(nameSort, typeSort, durationSort, timeSort);
        sortBox.setAlignment(Pos.TOP_CENTER);

        inputBox.getChildren().addAll(taskInfoBox, taskMainBox, dequeueBox, toggleBox, sortBox);
        inputBox.setPadding(new Insets(10));
        inputBox.setAlignment(Pos.TOP_CENTER);

        return inputBox;
    }

    public HBox sortView(String text) {
        HBox sortBox = new HBox();
        Button sortButton = new Button(text);
        sortBox.getChildren().addAll(sortButton);
        sortBox.setAlignment(Pos.TOP_CENTER);
        return sortBox;
    }

    public static void main(String[] args) {
        launch();
    }
}