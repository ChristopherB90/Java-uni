/*
 * Author: Christopher Bond
 * 
*/
import javafx.application.Application; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.control.TextArea; 
import javafx.scene.control.TextField; 
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color; 
import javafx.scene.text.Font; 
import javafx.stage.Stage;
import javafx.stage.Modality;

public class SystemTestGUI extends Application{
	
	public static boolean integerTest(String entry) { // Returns boolean, checks if input String can be converted to INT, or it returns false. 
		try
			{
			Integer.parseInt(entry);
			 return true;
			}
		catch(Exception error)
			{
			return false;
			}
	}
	
	public static boolean doubleTest(String entry) { // Returns boolean, checks if input String can be converted to Double, or it returns false.
		try
			{
			Double.parseDouble(entry);
			 return true;
			}
		catch(Exception error)
			{
			return false;
			}
	}
		// showDisplay method, used to re-display the display by re-sizing it to normal size and un-hiding it, and then setting the input fields/labels/buttons to invisible.
		public void showDisplay(TextArea field, Label mem1, TextField mem2, Button mem3, Label HD1,TextField HD2,Button HD3, Label purch1, TextField purch2, Button purch3 ) {
			field.setMinSize(210,110);         
			field.setMaxSize(600,210); 
			field.setVisible(true);
			
			mem1.setVisible(false);
			mem2.setVisible(false);
			mem3.setVisible(false);
			
			HD1.setVisible(false);
			HD2.setVisible(false);
			HD3.setVisible(false);
			
			purch1.setVisible(false);
			purch2.setVisible(false);
			purch3.setVisible(false);	
		}
	
		public void start(Stage stage) {
			System newpc = new System("Intel","speedypc",120); // initialise the System object
					
			TextArea display = new TextArea();
			display.setEditable(false);         
			display.setMinSize(210,110);         
			display.setMaxSize(600,120); 
			
			Label Select = new Label("Select option: ");
			Select.setTextFill(Color.BLACK);
			Select.setFont(Font.font("Arial", 10));
			
			Stage errorStage = new Stage(); // creates new stage for popout error message
			VBox errorBox = new VBox(10); // initates VBox to place error message properly
			errorBox.setAlignment(Pos.CENTER); // centres text above
			Scene errorWindow = new Scene(errorBox,500,100); // defines new Scene for popout error message
			errorStage.initModality(Modality.APPLICATION_MODAL); // Sets modality such that the program cant be interacted with until the popout error message has been closed.
			errorStage.setScene(errorWindow);
			errorStage.setTitle("INVALID INPUT");
			
			// Initialise button closing the error popout window		
			Button errorCloser = new Button(); 
			errorCloser.setText("Ok");
			errorCloser.setPrefWidth(50);
			errorCloser.setOnAction(e->errorStage.close()); // On click, will close the error window.
			
			// Initialises the text block for the error window, initially no text, will be set later.
			Label inputError = new Label();
			inputError.setFont(Font.font("Arial", 20)); // font for popout error message
			errorBox.getChildren().addAll(inputError,errorCloser); // collates objects (text field InputError and button errorCloser) into the VBox.
			errorStage.setScene(errorWindow); //initialises scene,
			errorStage.setTitle("INVALID INPUT"); // title for error popout window.
						
			// RAM entry objects
			Label memoryLabel = new Label("Enter new RAM value (MB):    ");
			memoryLabel.setTextFill(Color.BLACK); // sets text colour to black
			memoryLabel.setFont(Font.font("Arial", 10)); // sets font and text size
			memoryLabel.setVisible(false); // initially the label is invisible, on becomes visible when option 4 (Set Details) is clicked.
			
			TextField memoryInput = new TextField(); // text field for RAM input    
			memoryInput.setPrefWidth(50);
			memoryInput.setVisible(false);	// initially invisible until option 4 (set details) is clicked.
		
			Button memoryButton = new Button(); // button to attempt to parse whatever is in the memoryInput text field
			memoryButton.setText("Save");
			memoryButton.setPrefWidth(50);
			memoryButton.setVisible(false); // initially invisible until; option 4 is clicked.
			memoryButton.setOnAction(e->
				{
					if (integerTest(memoryInput.getText())==false||Integer.parseInt(memoryInput.getText())<=0) // if can't be parsed into INT value or is lower than 0, opens errorStage window and requests new input.
					{
						inputError.setText("Invalid Input, please enter RAM value in MB: ");
						errorStage.show();	// opens the actual error window itself.
					}
					else 
					{
						newpc.setMemory(Integer.parseInt(memoryInput.getText())); // if CAN parse, applies setMemory to the input.
					}
				});

			// Harddisk entry objects	
			Label HDLabel = new Label("Enter new HardDIsk size (GB):"); // Label for hard disk input
			HDLabel.setTextFill(Color.BLACK); // sets colour for label
			HDLabel.setFont(Font.font("Arial", 10)); // sets font 
			HDLabel.setVisible(false); // initially will be invisible
			
			TextField HDInput = new TextField(); // textfield for hard disk input   
			HDInput.setPrefWidth(50);
			HDInput.setVisible(false);
			
			Button HDButton = new Button(); // button for hard disk input
			HDButton.setText("Save");
			HDButton.setPrefWidth(50);
			HDButton.setVisible(false);
			HDButton.setOnAction(e->{ // on click, tries to parse what is in HDInput text field. 
				if (doubleTest(HDInput.getText())==false||Double.parseDouble(HDInput.getText())<=0) // if entry isn't parse-able or is lower than 0, pops out new window informing of error.
				{
					inputError.setText("Invalid Input, please enter HardDisk size value in GB: "); // Sets text for popout error message, appropriate for this field.					
					errorStage.show(); // opens up the popout error message defined earlier.
				}
			
				else 
				{
					newpc.setHardDisk(Double.parseDouble(HDInput.getText())); // if the input text HDInput CAN be parsed to INT, accepts input and sets Hard Disk Size to input.
				}
				
			});
			
			// Purchase Cost objects, same methods as Hard Disk entries above.
			Label purchaseLabel = new Label("Enter purchasing cost (£): ");
			purchaseLabel.setTextFill(Color.BLACK);
			purchaseLabel.setFont(Font.font("Arial", 10));
			purchaseLabel.setVisible(false);
			
			TextField purchaseInput = new TextField();         
			purchaseInput.setPrefWidth(50);
			purchaseInput.setVisible(false);
			
			Button purchaseButton = new Button();
			purchaseButton.setText("Save");
			purchaseButton.setPrefWidth(50);
			purchaseButton.setVisible(false);
			purchaseButton.setOnAction(e->{	
				if ((doubleTest(purchaseInput.getText())==false)||Double.parseDouble(purchaseInput.getText())<=0)
				{
					inputError.setText("Invalid input, please enter purchasing cost (£): ");
					errorStage.show();		
				}
				else
				{
					newpc.setPurchaseCost(Double.parseDouble(purchaseInput.getText()));
				}	
			});
			
			// Define main choice buttons
			Button choice1 = new Button(); 
			choice1.setText("Print System Details");
			choice1.setPrefWidth(200);
			// On click, shows the main display text area with appropriate info, and showDisplay() hides the potentially visible input boxes as no input required for this choice. 
			choice1.setOnAction( e-> {display.setText(newpc.displayDetails());
			showDisplay(display,memoryLabel,memoryInput,memoryButton,HDLabel,HDInput,HDButton,purchaseLabel,purchaseInput,purchaseButton);
			});
				
			Button choice2 = new Button();
			choice2.setText("Display System Properties");
			choice2.setPrefWidth(200);
			// On click, shows the main display text area with appropriate info, and showDisplay() hides the potentially visible input boxes as no input required for this choice. 
			choice2.setOnAction( e-> {display.setText(newpc.displaySystemProperties());	
			showDisplay(display,memoryLabel,memoryInput,memoryButton,HDLabel,HDInput,HDButton,purchaseLabel,purchaseInput,purchaseButton);
			});
	
			Button choice3 = new Button();
			choice3.setText("Diagnose System");
			choice3.setPrefWidth(200);
			// On click, shows the main display text area with appropriate info, and showDisplay() hides the potentially visible input boxes as no input required for this choice. 
			choice3.setOnAction(e->{display.setText(newpc.diagnoseSystem());
			showDisplay(display,memoryLabel,memoryInput,memoryButton,HDLabel,HDInput,HDButton,purchaseLabel,purchaseInput,purchaseButton);
			});
			
			Button choice4 = new Button();
			choice4.setText("Set Details");
			choice4.setPrefWidth(200);
			// On click, sets main display window to (0,0)/(0.0), and hides the instance from view. Then makes visible the existing input text areas, input boxes, and input-accepting buttons.
			choice4.setOnAction(e-> {
				display.setText("Please enter new RAM value: ");
				// Hides the main bottom display and un-Hide the input objects:
				display.setMinSize(0,0);         
				display.setMaxSize(0,0); 
				display.setVisible(false);
				
				memoryLabel.setVisible(true);
				memoryInput.setVisible(true);
				memoryButton.setVisible(true);
				
				HDLabel.setVisible(true);
				HDInput.setVisible(true);
				HDButton.setVisible(true);
				
				purchaseLabel.setVisible(true);
				purchaseInput.setVisible(true);
				purchaseButton.setVisible(true);
				
			});
			
			Button choice5 = new Button();
			choice5.setText("Quit the program");
			choice5.setPrefWidth(200);
			//on click, closes the who GUI.
			choice5.setOnAction(e->stage.close());
			
			// defines the display VBoxs and HBox
			// Full draw
			VBox top = new VBox(10);//top half of the window, displays the control buttons.
			top.setAlignment(Pos.CENTER);
			top.getChildren().addAll(Select, choice1, choice2,choice3,choice4,choice5) ; // VBox top contains the top half of the GUI, always accessible. Had title Select, and the choice buttons.
			
			HBox middle = new HBox(10);
			middle.setAlignment(Pos.CENTER);
			middle.getChildren().addAll(display);
			
			VBox Labelbox = new VBox(23);
			Labelbox.setAlignment(Pos.CENTER);
			Labelbox.getChildren().addAll(memoryLabel,HDLabel,purchaseLabel);
			
			VBox InputBox = new VBox(10);
			InputBox.setAlignment(Pos.CENTER);
			InputBox.getChildren().addAll(memoryInput,HDInput,purchaseInput);
			
			VBox ButtonBox = new VBox(10);
			ButtonBox.setAlignment(Pos.CENTER);
			ButtonBox.getChildren().addAll(memoryButton,HDButton,purchaseButton);
			
			HBox SETBoxes = new HBox(10);
			SETBoxes.setAlignment(Pos.CENTER);
			SETBoxes.getChildren().addAll(Labelbox,InputBox,ButtonBox);
			
			VBox middleBox = new VBox(5);
			middleBox.setAlignment(Pos.CENTER);
			middleBox.getChildren().addAll(middle,SETBoxes);
			
			VBox full = new VBox(40); // Final VBox, holding all elements
			full.setAlignment(Pos.TOP_CENTER);
			full.getChildren().addAll(top,middleBox);
			
			Scene showAll = new Scene(full,600,400); // accepts 'full' VBox (containing all other boxes) and creates scene of size 600,400.
			stage.setScene(showAll); // sets the scene within the stage.
			stage.setTitle("System Information");	//sets the title of the GUI.
			stage.show(); // Builds the GUI.

		}
		
	public static void main(String[] args) {
		launch(args); // Launches the GUI.
	
	}
}