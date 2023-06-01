import java.util.Date;

import javafx.application.Platform;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/** Generates each list cell.
 * @author Kaitlyn
 * @version 1.0
 */
public class ToDoListCustomCellFactory implements Callback<ListView<Item>, ListCell<Item>> {
    private ListView<Item> myList;

    /** Constructor for the cell.
     * @param myView the listView
     */
    public ToDoListCustomCellFactory(ListView<Item> myView) {
        this.myList = myView;
    }

    /** Initializes things.
     * @param param the listview
     * @return ListCell the list cell
     */
    public ListCell<Item> call(ListView<Item> param) {

        return new ListCell<Item>() {
            @Override
            public void updateItem(Item item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else if (item != null) {
                    setText(null);
                    GridPane pane = createGrid();
                    pane.setBorder(new Border(new BorderStroke(item.getColor(),
                            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    Label typeLabel = new Label(item.getType().name());
                    Label dateLabel = new Label(String.format("%tc", Date.from(item.getDate())));

                    pane.addRow(0, createTextBox(item), typeLabel, dateLabel);

                    setGraphic(pane);
                }
            }

            /** Creates checkBox for the cell.
             * @param item the item
             * @return CheckBox the check box
             */
            private CheckBox createTextBox(Item item) {
                CheckBox box = new CheckBox(item.getName());

                // Lambda expression
                box.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                    Platform.runLater(() -> {
                        myList.getItems().remove(item);
                        ToDoListInput.finishTask();
                    });

                });
                return box;
            }

            /** Create the grid.
             * @return GridPane the grid pane
             */
            private GridPane createGrid() {
                GridPane pane = new GridPane();

                // Add %width of each column here.
                ColumnConstraints col1 = new ColumnConstraints();
                col1.setPercentWidth(40);

                ColumnConstraints col2 = new ColumnConstraints();
                col2.setPercentWidth(20);

                ColumnConstraints col3 = new ColumnConstraints();
                col2.setPercentWidth(20);
                pane.getColumnConstraints().addAll(col1, col2, col3);
                return pane;
            }
        };
    }
}
