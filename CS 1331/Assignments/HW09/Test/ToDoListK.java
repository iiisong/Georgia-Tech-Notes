import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Actual class to run the ToDoList.
 * @author Kaitlyn
 * @version 1.0
 */
public class ToDoListK extends Application {
    /**
     * Main method.
     * @param args the args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox primaryRoot = new VBox();
        HBox root = new HBox();
        ListView<?> listView = createCustomListView();
        // root.getChildren().addAll(new ToDoListInput());
        root.getChildren().addAll(listView, new ToDoListInput());
        root.setFillHeight(true);
        primaryStage.setTitle("To-Do List");
        Label title = new Label("Kaitlyn's To-Do List");
        primaryRoot.setAlignment(Pos.TOP_LEFT);
        title.setStyle("-fx-font: 20 Segoe;");

        primaryRoot.getChildren().add(title);
        primaryRoot.getChildren().add(root);
        // Magic line to make list view take up the horizontal space.
        HBox.setHgrow(listView, Priority.ALWAYS);

        primaryStage.setScene(new Scene(primaryRoot, 1000, 600));
        primaryStage.show();

    }

    /**
     * Create the List.
     * @return ListView the list
     */
    private ListView<?> createCustomListView() {
        ListView<Item> myView = new ListView<>(Item.ITEMS);
        myView.setStyle("-fx-border-color: black");
        myView.setCellFactory(new ToDoListCustomCellFactory(myView));
        return myView;
    }
}