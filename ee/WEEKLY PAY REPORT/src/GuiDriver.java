import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;

import javax.management.openmbean.InvalidKeyException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

@SuppressWarnings("restriction")
public class GuiDriver extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// elements of the gui
		Button addEmployee,removeEmployee, clearFields, printCompanyEmployees, printWeeklyPayReports, readFile, exit;
		RadioButton design, sales, manufacturing, manager;
		final ToggleGroup employeeGroup = new ToggleGroup();
		Label companyNameLBL, PresidentLBL, empIDLBL, fNLBL, lNLBL, weekSalesLBL, payRateLBL, hoursLBL, salaryLBL,
				pRateLBL, numbPLBL;
		TextField empIDTxtF, fNTxtF, lNTxtF, arg1TxtF, arg2TxtF;
		Company wackyWidgets = new Company("Wacky Widgets");
		// layout parents of the gui
		VBox root = new VBox(7);
		HBox compTitle = new HBox(2);
		HBox prezTitle = new HBox(1);
		VBox employeeData = new VBox(3);
		HBox employeeRadioBtn = new HBox(4);
		GridPane grid = new GridPane();
		HBox employeeDataBtns = new HBox(2);
		HBox empMangBnts = new HBox(4);
		// compTitle layout
		companyNameLBL = new Label(wackyWidgets.getCompanyName());
		compTitle.getChildren().addAll(companyNameLBL);
		compTitle.setAlignment(Pos.CENTER);
		// prezTitle
		PresidentLBL = new Label("Rajashow Parajuli");
		prezTitle.getChildren().add(PresidentLBL);
		prezTitle.setAlignment(Pos.CENTER);
		// EmployeeData
		// Radio buttons
		design = new RadioButton("Design");
		sales = new RadioButton("Sales");
		manufacturing = new RadioButton("Manufactoring");
		manager = new RadioButton("Manager");
		// setting the toggle group
		design.setToggleGroup(employeeGroup);
		sales.setToggleGroup(employeeGroup);
		manager.setToggleGroup(employeeGroup);
		manufacturing.setToggleGroup(employeeGroup);
		employeeRadioBtn.getChildren().addAll(design, sales, manufacturing, manager);
		employeeRadioBtn.setSpacing(20);
		employeeRadioBtn.setAlignment(Pos.CENTER);
		employeeRadioBtn.setStyle("-fx-padding: 25;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 10;" + "-fx-border-color: cornflowerblue;");
		// employee data fields grid
		empIDLBL = new Label("Employee ID:");
		fNLBL = new Label("First Name:");
		lNLBL = new Label("Last Name:");
		weekSalesLBL = new Label("Weekly Sales:");
		payRateLBL = new Label("Pay Rate:");
		hoursLBL = new Label("Hours:");
		salaryLBL = new Label("Salary");
		pRateLBL = new Label("Piece Rate:");
		numbPLBL = new Label("Number of Pieces:");
		// txt lbl
		grid.add(empIDLBL, 1, 1);
		grid.add(fNLBL, 1, 2);
		grid.add(lNLBL, 1, 3);
		grid.add(weekSalesLBL, 1, 4);
		grid.add(payRateLBL, 1, 4);
		grid.add(hoursLBL, 1, 5);
		grid.add(salaryLBL, 1, 4);
		grid.add(pRateLBL, 1, 4);
		grid.add(numbPLBL, 1, 5);
		// txt fld
		empIDTxtF = new TextField();
		fNTxtF = new TextField();
		lNTxtF = new TextField();
		arg1TxtF = new TextField();
		arg2TxtF = new TextField();

		grid.add(empIDTxtF, 2, 1);
		grid.add(fNTxtF, 2, 2);
		grid.add(lNTxtF, 2, 3);
		grid.add(arg1TxtF, 2, 4);
		grid.add(arg2TxtF, 2, 5);
		grid.setAlignment(Pos.CENTER);
		grid.setStyle("-fx-padding: 25;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 10;" + "-fx-border-color: cadetblue;");
		// employee btns
		addEmployee = new Button("Add Employee");
		removeEmployee = new Button("Remove Employee");
		clearFields = new Button("Clear");
		employeeDataBtns.getChildren().addAll(addEmployee, removeEmployee,clearFields);
		employeeDataBtns.setAlignment(Pos.CENTER);
		// Employee data last style changes
		employeeData.setAlignment(Pos.CENTER);
		employeeData.getChildren().addAll(employeeRadioBtn, grid, employeeDataBtns);
		employeeData.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: firebrick;");

		// empMangBnts
		printCompanyEmployees = new Button("Print Compnay Employees");
		printWeeklyPayReports = new Button("Print Weekly Pay Report");
		readFile = new Button("Read File");
		exit = new Button("Exit");
		empMangBnts.getChildren().addAll(printCompanyEmployees, printWeeklyPayReports, readFile, exit);
		empMangBnts.setAlignment(Pos.CENTER);
		empMangBnts.setSpacing(10);

		// Root layout
		root.setSpacing(20);
		root.getChildren().addAll(compTitle, prezTitle, employeeData, empMangBnts);

		// Event handlers
		removeEmployee.setOnAction(e->{
			if(fNTxtF.getText().equals("")||lNTxtF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the employee info");

			}
			else	
		if(!wackyWidgets.removeEmployee(fNTxtF.getText(),lNTxtF.getText())) {
			JOptionPane.showMessageDialog(null, "No such emplyoee found");
		}else {
			JOptionPane.showMessageDialog(null,fNTxtF.getText()+" "+lNTxtF.getText()+"was removed");

		}
		});
		clearFields.setOnAction(e -> {
			empIDTxtF.setText("");
			fNTxtF.setText("");
			lNTxtF.setText("");
			arg1TxtF.setText("");
			arg2TxtF.setText("");
		});
		design.setOnAction(e -> {
			weekSalesLBL.setVisible(false);
			payRateLBL.setVisible(true);
			hoursLBL.setVisible(true);
			salaryLBL.setVisible(false);
			pRateLBL.setVisible(false);
			numbPLBL.setVisible(false);
			arg1TxtF.setVisible(true);
			arg2TxtF.setVisible(true);
			clearFields.fire();

		});
		sales.setOnAction(e -> {
			weekSalesLBL.setVisible(true);
			payRateLBL.setVisible(false);
			hoursLBL.setVisible(false);
			salaryLBL.setVisible(false);
			pRateLBL.setVisible(false);
			numbPLBL.setVisible(false);
			arg1TxtF.setVisible(true);
			arg2TxtF.setVisible(false);
			clearFields.fire();

		});
		manager.setOnAction(e -> {
			weekSalesLBL.setVisible(false);
			payRateLBL.setVisible(false);
			hoursLBL.setVisible(false);
			salaryLBL.setVisible(true);
			pRateLBL.setVisible(false);
			numbPLBL.setVisible(false);
			arg1TxtF.setVisible(true);
			arg2TxtF.setVisible(false);
			clearFields.fire();

		});
		manufacturing.setOnAction(e -> {
			weekSalesLBL.setVisible(false);
			payRateLBL.setVisible(false);
			hoursLBL.setVisible(false);
			salaryLBL.setVisible(false);
			pRateLBL.setVisible(true);
			numbPLBL.setVisible(true);
			arg1TxtF.setVisible(true);
			arg2TxtF.setVisible(true);
			clearFields.fire();

		});
		readFile.setOnAction(e -> {
			JFileChooser choose = new JFileChooser();
			int row = 0;

			String[][] employees = new String[30][7];
			if (choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File x = choose.getSelectedFile();
				try (BufferedReader br = new BufferedReader(new FileReader(x.getPath()))) {
					String line = br.readLine();
					while (line != null) {
						String[] temp = line.split(":");
						for (int i = 0; i < temp.length; i++) {
							employees[row][i] = temp[i];
						}
						line = br.readLine();
						row++;

					}

					for (String[] a : employees) {
						int sinceNull = 0;
						String fName = "";
						String lName = "";
						String position = "";
						int empNum = -1;
						double param1 = -1;
						int param2 = -1;
						for (String b : a) {
							if (b == null) {
								continue;
							}

							else if (sinceNull == 0) {
								fName = b;
								sinceNull++;
							} else if (sinceNull == 1) {
								lName = b;
								sinceNull++;
							} else if (sinceNull == 2) {
								position = b;
								sinceNull++;
							} else {
								if (position.equals("Design")) {
									if (sinceNull == 3) {
										param1 = Double.parseDouble(b);
										sinceNull++;
									} else if (sinceNull == 4) {
										param2 = Integer.parseInt(b);
										sinceNull++;
									} else if (sinceNull == 5) {
										empNum = Integer.parseInt(b);
										wackyWidgets.addEmployee(fName, lName, position, param1, param2, empNum);
										sinceNull = 0;
									}

								} else if (position.equals("Sales")) {
									if (sinceNull == 3) {
										param1 = Double.parseDouble(b);
										sinceNull++;
									} else if (sinceNull == 4) {
										empNum = Integer.parseInt(b);
										wackyWidgets.addEmployee(fName, lName, position, param1, 0, empNum);
										sinceNull = 0;
									}

								} else if (position.equals("Manufacturing")) {
									if (sinceNull == 3) {
										param1 = Double.parseDouble(b);
										sinceNull++;
									} else if (sinceNull == 4) {
										param2 = Integer.parseInt(b);
										sinceNull++;
									} else if (sinceNull == 5) {
										empNum = Integer.parseInt(b);
										wackyWidgets.addEmployee(fName, lName, position, param1, param2, empNum);
										sinceNull = 0;
									}

								} else if (position.equals("Manager")) {
									if (sinceNull == 3) {
										param1 = Double.parseDouble(b);
										sinceNull++;
									} else if (sinceNull == 4) {
										empNum = Integer.parseInt(b);
										wackyWidgets.addEmployee(fName, lName, position, param1, param2, empNum);
										sinceNull = 0;
									}

								}

							}
						}

					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			} else
				JOptionPane.showMessageDialog(null, "File not uploaded");

		});
		exit.setOnAction(e -> {
			System.exit(0);
		});
		printCompanyEmployees.setOnAction(e -> {
			JOptionPane.showMessageDialog(null, wackyWidgets.getCompanyName() + "\n" + wackyWidgets.listOfEmp());
		});
		printWeeklyPayReports.setOnAction(e -> {
			JOptionPane.showMessageDialog(null, wackyWidgets.generateWeeklyReport());
		});
		addEmployee.setOnAction(e->{
			String errorMessage = null;
			try {
				if((fNTxtF.getText().equals("")|| lNTxtF.getText().equals(""))){
					throw new InvalidKeyException();
				}
				if( Double.parseDouble(arg1TxtF.getText())<0 ||Double.parseDouble(arg2TxtF.getText())<0) {
					throw new InputMismatchException();
				}
			if(design.isSelected()) {
				errorMessage = wackyWidgets.addEmployee(fNTxtF.getText(), lNTxtF.getText(), "Design", Double.parseDouble(arg1TxtF.getText()), Integer.parseInt(arg2TxtF.getText()), Integer.parseInt(empIDTxtF.getText()));
				clearFields.fire();

			}else if(sales.isSelected()) {
				errorMessage = wackyWidgets.addEmployee(fNTxtF.getText(), lNTxtF.getText(), "Sales", Double.parseDouble(arg1TxtF.getText()), 0, Integer.parseInt(empIDTxtF.getText()));
				clearFields.fire();

			}else if(manufacturing.isSelected()) {
				errorMessage = wackyWidgets.addEmployee(fNTxtF.getText(), lNTxtF.getText(), "Manufacturing", Double.parseDouble(arg1TxtF.getText()), Integer.parseInt(arg2TxtF.getText()), Integer.parseInt(empIDTxtF.getText()));
				clearFields.fire();

			}else if(manager.isSelected()){
				errorMessage = wackyWidgets.addEmployee(fNTxtF.getText(), lNTxtF.getText(), "Manager", Double.parseDouble(arg1TxtF.getText()), 0, Integer.parseInt(empIDTxtF.getText()));
				clearFields.fire();

			}
			else{
				errorMessage = "No position was selected";
			}
			if(errorMessage != null)
				JOptionPane.showMessageDialog(null, errorMessage);}
			catch(NullPointerException e1){
					JOptionPane.showMessageDialog(null, "pay information is empty");
					
				}catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "You must enter the pay infomation is number format");
					
				}
			catch(InvalidKeyException e1){
				JOptionPane.showMessageDialog(null, "The employee info field is empty");
				
			}catch(InputMismatchException e1) {
				JOptionPane.showMessageDialog(null, "The employee pay info cannot be negative ");

			}
			
		});
		
		//default condi 
		weekSalesLBL.setVisible(false);
		payRateLBL.setVisible(true);
		hoursLBL.setVisible(true);
		salaryLBL.setVisible(false);
		pRateLBL.setVisible(false);
		numbPLBL.setVisible(false);
		arg1TxtF.setVisible(true);
		arg2TxtF.setVisible(true);
		design.setSelected(true);

		//root
		Scene scene = new Scene(root, 500, 600);
		stage.setScene(scene);

		// Set stage title and show the stage.
		stage.setTitle("Employee Management ");
		stage.show();
	}
}