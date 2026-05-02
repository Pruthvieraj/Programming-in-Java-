import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;

public class MenuPanel {

    private Stage stage;
    private TableView<String[]> table = new TableView<>();
    private ObservableList<String[]> data = FXCollections.observableArrayList();

    private TextField idInput = new TextField();
    private TextField nameInput = new TextField();
    private TextField priceInput = new TextField();
    private TextField resIdInput = new TextField();

    public MenuPanel(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        Button back = new Button("← Back");
        back.setOnAction(e -> Main.showHome(stage));

        table.setItems(data);

        TableColumn<String[], String> c1 = new TableColumn<>("ID");
        c1.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue()[0]));

        TableColumn<String[], String> c2 = new TableColumn<>("Name");
        c2.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue()[1]));

        TableColumn<String[], String> c3 = new TableColumn<>("Price");
        c3.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue()[2]));

        TableColumn<String[], String> c4 = new TableColumn<>("ResId");
        c4.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue()[3]));

        table.getColumns().addAll(c1, c2, c3, c4);

        Button insert = new Button("INSERT");
        Button select = new Button("SELECT ALL");
        Button update = new Button("UPDATE");
        Button delete = new Button("DELETE");

        insert.setOnAction(e -> {
            try {
                DBHelper.insertMenu(Main.connection,
                        Integer.parseInt(idInput.getText()),
                        nameInput.getText(),
                        Double.parseDouble(priceInput.getText()),
                        Integer.parseInt(resIdInput.getText()));
                load();
            } catch (Exception ex) {}
        });

        select.setOnAction(e -> load());

        update.setOnAction(e -> {
            try {
                DBHelper.updateMenu(Main.connection,
                        Integer.parseInt(idInput.getText()),
                        nameInput.getText(),
                        Double.parseDouble(priceInput.getText()),
                        Integer.parseInt(resIdInput.getText()));
                load();
            } catch (Exception ex) {}
        });

        delete.setOnAction(e -> {
            try {
                DBHelper.deleteMenu(Main.connection,
                        Integer.parseInt(idInput.getText()));
                load();
            } catch (Exception ex) {}
        });

        VBox right = new VBox(10,
                new Label("ID"), idInput,
                new Label("Name"), nameInput,
                new Label("Price"), priceInput,
                new Label("ResId"), resIdInput,
                insert, select, update, delete
        );

        BorderPane root = new BorderPane();
        root.setTop(back);
        root.setCenter(table);
        root.setRight(right);

        stage.setScene(new Scene(root, 750, 400));
        stage.setTitle("Menu Items - Database Operations");
        stage.show();

        load();
    }

    private void load() {
        try {
            data.clear();
            data.addAll(DBHelper.getMenu(Main.connection));
        } catch (Exception e) {}
    }
}