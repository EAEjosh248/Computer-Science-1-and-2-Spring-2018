import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
public class GUI extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage stage) {
	  
	String reqq ="1.Between 6 and 10 characters is a weak (but acceptable) password \n2. At least 1 numeric character\n3. At least 1 uppercase alphabetic character	\n4. At least 1 lowercase alphabetic character	\n5. No more than 2 of the same character in a sequence\n";
    Scene scene = new Scene(new Group(), 600, 250);

    TextField Password_F = new TextField ();
    TextField Password_R = new TextField ();
    
    Password_R.clear();    
    Password_F.clear();

    Button check_pass = new Button();
    Button check_pass_file = new Button();
    Button quit = new Button();

    check_pass_file.setText("Check Passwords In a _File ");
    check_pass.setText("Check _Password");
    quit.setText("_Quit");
    
    check_pass_file.setMnemonicParsing(true);
    check_pass.setMnemonicParsing(true);
    quit.setMnemonicParsing(true);

    check_pass_file.setTooltip(new Tooltip("Press to Check a File of Passwords."));
    check_pass.setTooltip(new Tooltip("Press to Check the Passwords."));
    quit.setTooltip(new Tooltip("Press to Quit."));
    
    quit.setOnAction(e ->{
    	Platform.exit();
    	System.exit(0);
    });
    check_pass_file.setOnAction(e ->{
    	File file;
    	int returnVal;
    	String currentLine;
      BufferedReader br;
      String display ="";
      JFileChooser fileChooser = new JFileChooser();
      ArrayList<String> passwords = new ArrayList<String>();
      //file handling
                    returnVal = fileChooser.showOpenDialog(null);
                    if(returnVal == JFileChooser.APPROVE_OPTION) {
                        file = fileChooser.getSelectedFile();
                        try {
                            br = new BufferedReader(new FileReader(file));
                            while((currentLine = br.readLine()) !=null)
                            {
                                passwords.add(currentLine);
                            }}
                            catch(Exception error)
                            {
                                error.printStackTrace();
                            }
                        //passing passwords and outputting them
      for(String s:PasswordCheckerUtility.validPasswords(passwords)){
        display+= "\n"+s;
        System.out.print(s);
      }
      JOptionPane.showMessageDialog(null, display);
      }

    });
    check_pass.setOnAction(e ->{
    	try {
    		//Individual password handling
    		if(Password_F.getText().equals(Password_R.getText())) {
    			if(PasswordCheckerUtility.isValidPassword(Password_F.getText())) {
    				if(PasswordCheckerUtility.isWeakPassword(Password_F.getText())){
    					throw new WeakPasswordException(Password_F.getText());
    				}else {
    		    		JOptionPane.showMessageDialog(null,Password_F.getText() + " is a strong password." );

    				}
    			}
    		}else {
    			throw new UnmatchedException(Password_F.getText(), Password_R.getText());
    		}
    			
    	
    	}catch(UnmatchedException e1) {
    		JOptionPane.showMessageDialog(null, e1.getMessage());
    	}
    	catch(WeakPasswordException e1) {
    		JOptionPane.showMessageDialog(null, e1.getMessage());
    	}
    	catch(LengthException e1) {
    		JOptionPane.showMessageDialog(null, e1.getMessage());
    	}catch(InvalidSequenceException e1) {
    		JOptionPane.showMessageDialog(null, e1.getMessage());
    	}catch(NoLowerAlphaException e1) {
    		JOptionPane.showMessageDialog(null, e1.getMessage());
    	}catch(NoUpperAlphaException e1) {
    		JOptionPane.showMessageDialog(null, e1.getMessage());
    	}catch(NoDigitException e1) {
    		JOptionPane.showMessageDialog(null, e1.getMessage());
    	}
    });
    VBox grid = new VBox(4);
    HBox r1 = new HBox(2);
    HBox r2 = new HBox(2);
    HBox r3 = new HBox(2);
    HBox r4 = new HBox(3);
   


    r1.getChildren().add(new Label(reqq));    
    r2.getChildren().add(new Label("Password:"));
    r2.getChildren().add(Password_F);// y,x
    r3.getChildren().add(new Label("Re type Password:"));
    r3.getChildren().add(Password_R);
    r4.getChildren().add(check_pass);   
    r4.getChildren().add(check_pass_file);
    r4.getChildren().add(quit);
    grid.getChildren().addAll(r1,r2,r3,r4);
   
    Group root = (Group) scene.getRoot();
    root.getChildren().add(grid);
    stage.setScene(scene);
    stage.show();
  }
}
