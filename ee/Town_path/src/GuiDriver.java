import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

@SuppressWarnings("restriction")
public class GuiDriver extends Application {
	Label townName, roadName, selectTforR, distance, findConnect, to,townTitle,roadTitle,pathTitle;
	ComboBox<String> sourceTownCBRD, destinationTownCBRD, sourceTownCBCN, destinationTownCBCN;
	Button addTown, addRoad, findConnection, readFile, exit;
	TextField townNameTxtF, roadNameTxtF, distanceTxtF;
	TextArea messageTextArea;
	TownGraphManager mgr = new TownGraphManager();

	public VBox addTownPannel() {
		townName = new Label("Town's Name:");
		townTitle = new Label("Add Town");
		townNameTxtF = new TextField();
		addTown = new Button("Add Town");
		HBox temp1 = new HBox(3);
		temp1.getChildren().addAll(townName, townNameTxtF, addTown);
		temp1.setSpacing(10);
		temp1.setAlignment(Pos.CENTER);
		VBox temp = new VBox(2);
		townTitle.setStyle("-fx-font-weight: bold;\n"
				+ "-fx-font: 24 arial;");
		temp.getChildren().addAll(townTitle,temp1);
		temp.setMinHeight(150);
		temp.setSpacing(10);
		temp.setAlignment(Pos.CENTER);
		return temp;

	}

	public VBox addRoadPannel() {
		roadName = new Label("Road's Name:");
		distance = new Label("Distance:");
		roadTitle = new Label("Add Road");
		selectTforR = new Label("Select towns for road");
		roadNameTxtF = new TextField();
		distanceTxtF = new TextField();
		addRoad = new Button("Add Road");
		VBox temp = new VBox(4);
		HBox temp1 = new HBox();
		temp1.getChildren().addAll(roadName, roadNameTxtF);
		temp1.setAlignment(Pos.CENTER);

		HBox temp2 = new HBox();
		temp2.getChildren().addAll(sourceTownCBRD, destinationTownCBRD, distance, distanceTxtF, addRoad);
		temp2.setSpacing(20);
		temp2.setAlignment(Pos.CENTER);
		roadTitle.setStyle("-fx-font-weight: bold;\n"
				+ "-fx-font: 24 arial;");
		temp.getChildren().addAll(roadTitle,temp1, selectTforR, temp2);
		temp.setSpacing(10);
		temp.setAlignment(Pos.CENTER);
		temp.setStyle("-fx-border-color: black;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3 0 3 0;\n" +
                "-fx-border-style: solid;\n");
		temp.setMinHeight(250);
		temp.setMinWidth(500);

		return temp;

	}

	public VBox findConnectionPannel() {
		findConnect = new Label("Find Connection From");
		to = new Label("to");
		pathTitle = new Label("Find Path");
		findConnection = new Button("Find Connection");
		messageTextArea = new TextArea();
		VBox temp = new VBox(2);
		HBox temp1 = new HBox(5);
		temp1.getChildren().addAll(findConnect, sourceTownCBCN, to, destinationTownCBCN, findConnection);
		temp1.setSpacing(20);
		temp1.setAlignment(Pos.CENTER);
		pathTitle.setStyle("-fx-font-weight: bold;\n"
				+ "-fx-font: 24 arial;");
		temp.getChildren().addAll(pathTitle,temp1, messageTextArea);
		temp.setSpacing(10);
		temp.setAlignment(Pos.CENTER);
		return temp;

	}

	public HBox MasterButtonPannel() {
		readFile = new Button("Read File");
		exit = new Button("Exit");
		HBox temp = new HBox();

		temp.getChildren().addAll(readFile, exit);
		temp.setSpacing(10);
		temp.setAlignment(Pos.CENTER);
		return temp;

	}

	@Override
	public void start(Stage stage) throws Exception {
		sourceTownCBRD = new ComboBox<>();
		destinationTownCBRD = new ComboBox<>();
		sourceTownCBCN = new ComboBox<>();
		destinationTownCBCN = new ComboBox<>();

		sourceTownCBRD.setPrefWidth(250);
		sourceTownCBRD.setPrefHeight(20);
		sourceTownCBCN.setPrefWidth(250);
		sourceTownCBCN.setPrefHeight(20);
		destinationTownCBRD.setPrefWidth(250);
		destinationTownCBRD.setPrefHeight(20);
		destinationTownCBCN.setPrefWidth(250);
		destinationTownCBCN.setPrefHeight(20);

		VBox TownPannel = addTownPannel();
		VBox RoadPannel = addRoadPannel();
		VBox ConnectionPannel = findConnectionPannel();
		HBox ButtonPannel = MasterButtonPannel();

		BorderPane displayPane = new BorderPane();
		VBox contentPane = new VBox();
		contentPane.getChildren().addAll(TownPannel, RoadPannel, ConnectionPannel, ButtonPannel);
		contentPane.setSpacing(30);
		displayPane.setCenter(contentPane);

		exit.setOnAction(e -> {
			System.exit(0);
		});
		addTown.setOnAction(e -> {
			if (townNameTxtF.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Please enter a town name");
			else {
				mgr.addTown(townNameTxtF.getText());
				updateCombBox();
				clearFields();
			}
		});
		addRoad.setOnAction(e -> {
			try {
				if (sourceTownCBRD.getValue().equals(destinationTownCBRD.getValue()))
					throw new Exception();
				if (sourceTownCBRD.getValue().equals(null))
					throw new Exception();
				if (destinationTownCBRD.getValue().equals(null))
					throw new Exception();
				int tempWeight = Integer.parseInt(distanceTxtF.getText());
					if(tempWeight<0)
						throw new Exception();
				mgr.addRoad(sourceTownCBRD.getValue(), destinationTownCBRD.getValue(),
						tempWeight, roadNameTxtF.getText());
				clearFields();
			} catch (Exception exp) {
				JOptionPane.showMessageDialog(null, "Invaild Input");
			}

		});
		findConnection.setOnAction(e -> {
			try {
				if (sourceTownCBCN.getValue().equals(destinationTownCBCN.getValue()))
					throw new Exception();
				if (sourceTownCBCN.getValue().equals(null))
					throw new Exception();
				if (destinationTownCBCN.getValue().equals(null))
					throw new Exception();
				StringBuilder sb = new StringBuilder();
				for (Object obj : mgr.getPath(sourceTownCBCN.getValue(), destinationTownCBCN.getValue())) {
					sb.append(obj.toString());
					sb.append("\n");
					messageTextArea.setText(sb.toString());
				}

			} catch (Exception err) {
				JOptionPane.showMessageDialog(null, "Invaild Input");
			}
		});
		readFile.setOnAction(e -> {
			ArrayList<String> fileData = new ArrayList<String>();
			String[] content,roadInfo; 

			JFileChooser fileChooser = new JFileChooser();
			int status = fileChooser.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();

				try {
					Scanner inputFile = new Scanner(selectedFile);

					while (inputFile.hasNext()) {
						fileData.add(inputFile.nextLine());
					}

					inputFile.close();

					for (int i = 0; i < fileData.size(); i++) {

						content = fileData.get(i).split(";");
					
						roadInfo = content[0].split(",");
						int distance = Integer.parseInt(roadInfo[1]);

						String road = roadInfo[0];
						String townS = content[1];
						String townD = content[2];

						mgr.addTown(townS);
						mgr.addTown(townD);
						mgr.addRoad(townS, townD, distance, road);
					}

					updateCombBox();
					clearFields();
					JOptionPane.showMessageDialog(null, "Done");
				}

				catch (FileNotFoundException err) {
					err.printStackTrace();
				}
			}

		});
		Scene scene = new Scene(displayPane, 900, 800);
		stage.setTitle("Town Man");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}

	private void clearFields() {
		townNameTxtF.clear();
		roadNameTxtF.clear();
		distanceTxtF.clear();

	}

	private void updateCombBox() {
		sourceTownCBCN.setValue(null);
		sourceTownCBRD.setValue(null);
		destinationTownCBCN.setValue(null);
		destinationTownCBRD.setValue(null);
		sourceTownCBCN.setItems(FXCollections.observableArrayList(mgr.allTowns()));
		sourceTownCBRD.setItems(FXCollections.observableArrayList(mgr.allTowns()));
		destinationTownCBCN.setItems(FXCollections.observableArrayList(mgr.allTowns()));
		destinationTownCBRD.setItems(FXCollections.observableArrayList(mgr.allTowns()));

	}

	public static void main(String[] args) {
		launch(args);
	}

}
