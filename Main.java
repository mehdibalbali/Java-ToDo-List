package toDoList;



import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import toDoList.data.TodoData;

public class Main  extends Application {

	public static void main(String[] args) {
		launch(args);
		}
		@Override
		public void start(Stage primaryStage) throws Exception {
			Parent root=FXMLLoader.load(getClass().getResource("window.fxml"));
			primaryStage.setTitle("ToDo List");
			primaryStage.setScene(new Scene(root,900,500));
			primaryStage.show();
}
		@Override
		public void stop() throws IOException {
			try {
				TodoData.getInstance().storeItems();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
}