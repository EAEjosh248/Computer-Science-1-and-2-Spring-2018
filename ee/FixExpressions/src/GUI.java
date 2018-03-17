import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new Group(), 1000, 500);
		VBox grid = new VBox(3);

		// notation conv group tiles
		HBox nCGrid = new HBox(3);
		VBox nCGridc1 = new VBox(3);
		VBox nCGridc2 = new VBox(3);
		VBox nCGridc3 = new VBox(3);

		HBox nEGrid = new HBox(3);
		VBox nEGridc1 = new VBox(3);
		VBox nEGridc2 = new VBox(1);
		VBox nEGridc3 = new VBox(3);
		// nCGridc1
		RadioButton in2post = new RadioButton("Infix to Postfix");
		RadioButton post2in = new RadioButton("Postfix to Infix");
		Button convert = new Button("_Convert");
		convert.setMnemonicParsing(true);
		// nCGridc1 toggle group
		ToggleGroup fixGroup = new ToggleGroup();
		in2post.setToggleGroup(fixGroup);
		post2in.setToggleGroup(fixGroup);
		nCGridc1.getChildren().addAll(in2post, post2in, convert);
		// nCGridc2
		Label infixL = new Label("	Infix Expression:");
		TextField infixTF = new TextField();
		nCGridc2.getChildren().addAll(infixL, infixTF);

		// nCGridc3
		Label postfixL = new Label("	Postfix Expression:");
		TextField postfixTF = new TextField();
		nCGridc3.getChildren().addAll(postfixL, postfixTF);
		// notation convention group
		nCGrid.getChildren().addAll(nCGridc1, nCGridc2, nCGridc3);

		// nEval1
		Label evalL = new Label("Postfix Expression:");
		TextField evalTF = new TextField();
		nEGridc1.getChildren().addAll(evalL, evalTF);
		// nEval2
		Button eval = new Button("_Evaluate");
		nEGridc2.getChildren().addAll(eval);
		eval.setMnemonicParsing(true);
		// nEval3
		Label answer = new Label("	Answer");
		Label evalAnwser = new Label("	------");
		nEGridc3.getChildren().addAll(answer, evalAnwser);
		nEGrid.getChildren().addAll(nEGridc1, nEGridc2, nEGridc3);

		TitledPane Nconv = new TitledPane("Notation Conversion", nCGrid);
		TitledPane Neval = new TitledPane("Notation Evalution", nEGrid);
		Nconv.setCollapsible(false);
		Neval.setCollapsible(false);
		Button exit = new Button("_Exit");
		exit.setMnemonicParsing(true);

		grid.getChildren().addAll(Nconv, Neval,exit);
		in2post.setOnAction(e -> {

			infixL.setVisible(true);
			infixTF.setVisible(true);
			postfixL.setVisible(false);
			postfixTF.setVisible(false);
		});
		exit.setOnAction(e->{
			System.exit(0);
			
		});
		convert.setOnAction(e -> {
			infixL.setVisible(true);
			infixTF.setVisible(true);
			postfixL.setVisible(true);
			postfixTF.setVisible(true);
			try {
			if (in2post.selectedProperty().getValue()) {
				postfixTF.setText(Notation.convertInfixToPostfix(infixTF.getText()));
				
			} else if(post2in.selectedProperty().getValue()) {
				infixTF.setText(Notation.convertPostfixToInfix(postfixTF.getText()));
			}else {
				throw new Exception("No Setting selected");
				}}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			
			
		});
		post2in.setOnAction(e -> {

			infixL.setVisible(false);
			infixTF.setVisible(false);
			postfixL.setVisible(true);
			postfixTF.setVisible(true);
		});

		eval.setOnAction(e ->{
			try {
				if(!evalTF.getText().equals("")) {
				evalAnwser.setText("		"+Notation.evaluatePostfixExpression(evalTF.getText()));
				}else{
				throw new InvalidNotationFormatException();
				}}catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		});
		Group root = (Group) scene.getRoot();
		root.getChildren().add(grid);
		stage.setScene(scene);
		stage.show();
	}

}
