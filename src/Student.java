
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import  java.awt.*;
import java.awt.event.*;

public class Student extends JFrame{
	
	//Adding panel north
	JPanel panelNorth=new JPanel();
	JLabel labelPanelNorthTitle=new JLabel("Add Student -- EPI School");
	JButton homeStudentButton=new JButton(new ImageIcon("C://Users//DELL//Desktop//JavaIcon//smalhome.png"));
	
	//Components of center Panel
	JLabel labelFirstName=new JLabel("First Name");
	JTextField textFieldFirstName=new JTextField();
	
	JLabel labelLastName=new JLabel("Last Name");
	JTextField textFieldLastName=new JTextField();
	
	JPanel panelSexButton=new JPanel();
	
	JLabel labelSex=new JLabel("Sex");
	ButtonGroup buttonGroup=new ButtonGroup();
	JRadioButton radioButtonMale=new JRadioButton("Male",true);
	JRadioButton radioButtonFemale=new JRadioButton("Female");
	
	JLabel labelPhoneNumber=new JLabel("Phone Number");
	JTextField textFieldPhoneNumber=new JTextField();
	
	JLabel labelMailAdress=new JLabel("E-mail Adress");
	JTextField textFieldMailAdress=new JTextField();
	
	JLabel labelNationality=new JLabel("Nationality");
	JComboBox<String> comboNationality=new JComboBox<>();
	
	JLabel labelTraining=new JLabel("Training");
	JComboBox<String> comboTraining=new JComboBox<>();
	
	JPanel panelCenter=new JPanel();
	
	//Components of south Panel
	JButton addStudentButton=new JButton("Add Student");
	JButton studentManagementButton=new JButton("Student Management");
	
	JPanel panelSouth=new JPanel();
	
	public Student() {
		
		this.setTitle("Student");
		this.setSize(1370, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Title decoration
		labelPanelNorthTitle.setFont(new Font("Arial",Font.BOLD,30));
		labelPanelNorthTitle.setForeground(Color.white);
		
		//Adding label to the north panel
		homeStudentButton.setPreferredSize(new Dimension(64,64));
		homeStudentButton.setBackground(Color.white);
		
		panelNorth.add(homeStudentButton);
		panelNorth.add(labelPanelNorthTitle);
		
		//Adding components to the center panel 
		
		//FirstName
		panelCenter.add(labelFirstName);
		panelCenter.add(textFieldFirstName);
		
		//LastName
		panelCenter.add(labelLastName);
		panelCenter.add(textFieldLastName);
		
		//Telephone
		panelCenter.add(labelPhoneNumber);
		panelCenter.add(textFieldPhoneNumber);
		
		//MailAdress
		panelCenter.add(labelMailAdress);
		panelCenter.add(textFieldMailAdress);
		
		//Adding items to comboNationality
		comboNationality.addItem("Tunisia");
		comboNationality.addItem("Maroc");
		comboNationality.addItem("Algeria");
		comboNationality.addItem("Mauritania");
		comboNationality.addItem("Senegal");
		comboNationality.addItem("Cameroon");
		comboNationality.addItem("Niger");
		comboNationality.addItem("France");
		
		//Nationality 
		panelCenter.add(labelNationality);
		panelCenter.add(comboNationality);
		
		//Grouping radio Buttons
		
		buttonGroup.add(radioButtonFemale);
		buttonGroup.add(radioButtonMale);
		panelSexButton.add(radioButtonFemale);
		panelSexButton.add(radioButtonMale);
			
		//Sex
		panelCenter.add(labelSex);
		panelCenter.add(panelSexButton);
		
		//Adding Item to Combo Training
		comboTraining.addItem("Preparatory");
		comboTraining.addItem("Computer Engineering");
		comboTraining.addItem("Electrical Engineering");
		comboTraining.addItem("Civil Engineering");
		comboTraining.addItem("Industrial Engineering");
		comboTraining.addItem("Mechanical Engineering");
		comboTraining.addItem("Electromechanical Engineering");
		comboTraining.addItem("Architecture");
		comboTraining.addItem("Bachelor of Accounting");
		comboTraining.addItem("Bachelor of Marketing");
		comboTraining.addItem("Bachelor of Prodaction and Logistics");
		comboTraining.addItem("Bachelor of Finance");
		comboTraining.addItem("Bachelor of Business Administration");
		comboTraining.addItem("Master in Accounting");
		comboTraining.addItem("Master in Marketing");
		comboTraining.addItem("Master in Logistics");
		comboTraining.addItem("Master in Management");
		comboTraining.addItem("Master in Financial Engineering");
		
		panelCenter.add(labelTraining);
		panelCenter.add(comboTraining);
		
		//Add panel manager to the center panel
		panelCenter.setLayout(new GridLayout(8,4,20,20));
		
		//Set a background to the north panel
		panelNorth.setBackground(Color.BLUE);
		panelNorth.setPreferredSize(new Dimension(200,100));
		
		//Adding components to the west panel
		panelSouth.add(addStudentButton);
		panelSouth.add(studentManagementButton);
		
		//Container creation
		Container container=getContentPane();
		
		//Adding components contained in panels to the container
		container.add("North",panelNorth);
		container.add("Center",panelCenter);
		container.add("South",panelSouth);
		
		//Event processing ** back to the main page after the click of the Home button
		PEvent pEvent=new PEvent(this);
		
		homeStudentButton.addActionListener(pEvent);
		addStudentButton.addActionListener(pEvent);
		studentManagementButton.addActionListener(pEvent);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Student();
	}
}
