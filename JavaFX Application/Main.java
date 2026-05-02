import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.Connection;

public class Main extends Application {

    static Connection connection;

    @Override
    public void start(Stage stage) {

        try {
            connection = DBHelper.connect();
            DBHelper.createTables(connection);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Database Error\n" + e.getMessage()).showAndWait();
            return;
        }

        showHome(stage);
    }

    public static void showHome(Stage stage) {

        Label title = new Label("Food Database Management System");
        title.setStyle("-fx-font-size:18px; -fx-font-weight:bold;");

        Button restBtn = new Button("Manage Restaurants");
        Button menuBtn = new Button("Manage Menu Items");
        Button exitBtn = new Button("Exit");

        restBtn.setPrefWidth(200);
        menuBtn.setPrefWidth(200);
        exitBtn.setPrefWidth(200);

        restBtn.setOnAction(e -> new RestaurantPanel(stage).show());
        menuBtn.setOnAction(e -> new MenuPanel(stage).show());

        exitBtn.setOnAction(e -> {
            try { if (connection != null) connection.close(); } catch (Exception ex) {}
            stage.close();
        });

        VBox box = new VBox(20, title, restBtn, menuBtn, exitBtn);
        box.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(box, 400, 300));
        stage.setTitle("Main Menu");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}