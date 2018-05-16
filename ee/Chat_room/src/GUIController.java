
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

/**
 * This program will implement a GUI application to simulate a Chat Room.
 * 
 */
@SuppressWarnings("restriction")
public class GUIController extends Application {

	Label instructionTitleLabel;
	Label step1InstructionLabel;
	Label step2InstructionLabel;
	Label step3InstructionLabel;
	Label step4InstructionLabel;
	Label step5InstructionLabel;

	Button startServerButton;
	Button startClientButton;
	Button exitButton;
	int counter = 0;

	/**
	 * Sets the layout of the GUI, with all the labels, textfields, and buttons that
	 * the chat room application will need to perform all its functions.
	 */
	@Override
	public void start(Stage stage) {

		instructionTitleLabel = new Label("Chat Room Controller");
		instructionTitleLabel.setFont(new Font(18));

		step1InstructionLabel = new Label("1. Start the server." + "\n" + "2. Start a client." + "\n"
				+ "3. Enter a screen name in the clients's GUI " + "\n" + "4. Start more clients." + "\n"
				+ "5. Enter a message in a client's GUI.");

		startServerButton = new Button("Start the _Server");
		startServerButton.setMnemonicParsing(true);
		startServerButton.setTooltip(new Tooltip("Click here to start the server."));

		startClientButton = new Button("Start each _Client");
		startClientButton.setMnemonicParsing(true);
		startClientButton.setTooltip(new Tooltip("Click here to start a client."));

		exitButton = new Button("_Exit");
		exitButton.setMnemonicParsing(true);
		exitButton.setTooltip(new Tooltip("Click here to exit."));
		exitButton.setPadding(new Insets(5, 18, 5, 18));

		startServerButton.setOnAction(e -> {
			if (counter < 1) {
				ChatServerExec server = new ChatServerExec();

				server.startServer(9001);

				JOptionPane.showMessageDialog(null, "The server has been started.");

				counter++;
			} else {
				JOptionPane.showMessageDialog(null, "Cannot Start more than one server.");
			}
		});
		startClientButton.setOnAction(e -> {
			if (counter >= 1) {
				ChatClientExec client = new ChatClientExec();

				try {
					client.startClient();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Must start server first.");
			}
		}

		);
		exitButton.setOnAction(e -> {
			System.exit(0);
		});

		VBox instructionTitlePane = new VBox();
		instructionTitlePane.setAlignment(Pos.CENTER_LEFT);
		instructionTitlePane.getChildren().addAll(instructionTitleLabel);
		VBox instructionPane = new VBox(2);
		instructionPane.setAlignment(Pos.CENTER_LEFT);
		instructionPane.setPadding(new Insets(10, 180, 15, 70));
		instructionPane.setStyle("-fx-border-color: black;");
		instructionPane.getChildren().addAll(instructionTitlePane, step1InstructionLabel);

		HBox buttonPane = new HBox(15);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding(new Insets(15, 0, 15, 0));
		buttonPane.getChildren().addAll(startServerButton, startClientButton, exitButton);

		VBox contentPane = new VBox();
		contentPane.setAlignment(Pos.CENTER);
		contentPane.getChildren().addAll(instructionPane, buttonPane);

		BorderPane displayPane = new BorderPane();
		displayPane.setCenter(contentPane);

		Scene scene = new Scene(displayPane);
		stage.setTitle("Chat Room");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Will launch the GUI for the Actor Graph application.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
