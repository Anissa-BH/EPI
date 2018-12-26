import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentManagement extends JFrame {
	
	
	Student student;
	DatabaseManagement dataBaseManagement=new DatabaseManagement();
	
	JButton previousButton=new JButton("Previous");
	JButton homeStudentManagementButton=new JButton(new ImageIcon("C://Users//DELL//Desktop//JavaIcon//smalhome.png"));
	JLabel labelPanelNorthTitle=new JLabel("Student Management -- EPI School");
	
	String header[]= {"Id","First Name","Last Name","Sex","Phone Number","Mail Adress","Nationality","Training"};
	DefaultTableModel model=new DefaultTableModel(header,0);
	JTable studentsList=new JTable(model);
	JScrollPane scrollStudentsList=new JScrollPane(studentsList);
	
	JLabel labelId=new JLabel("ID");
	JTextField textFieldId=new JTextField();
	
	JLabel labelFirstName=new JLabel("First Name");
	JTextField textFieldFirstName=new JTextField();
	
	JLabel labelLastName=new JLabel("Last Name");
	JTextField textFieldLastName=new JTextField();
	
	JLabel labelPhoneNumber=new JLabel("Phone Number");
	JTextField textFieldPhoneNumber=new JTextField();
	
	JLabel labelMailAdress=new JLabel("E-mail Adress");
	JTextField textFieldMailAdress=new JTextField();
	
	JLabel labelNationality=new JLabel("Nationality");
	String[] nationalityItem = new String[] {"Tunisia","Maroc","Algeria","Mauritania","Senegal","Cameroon","Niger","France"};
	JComboBox<String> comboNationality=new JComboBox<>(nationalityItem);
	
	JLabel labelTraining=new JLabel("Training");
	String[] trainingItem = new String[] {"Preparatory","Computer Engineering","Electrical Engineering","Civil Engineering","Industrial Engineering","Mechanical Engineering","Electromechanical Engineering","Architecture","Bachelor of Accounting","Bachelor of Marketing","Bachelor of Marketing","Bachelor of Prodaction and Logistics","Bachelor of Finance","Bachelor of Business Administration","Master in Accounting","Master in Marketing","Master in Logistics","Master in Management","Master in Financial Engineering"};
	JComboBox<String> comboTraining=new JComboBox<>(trainingItem);
	
	JPanel panelSexButton=new JPanel();
	
	JLabel labelSex=new JLabel("Sex");
	ButtonGroup buttonGroup=new ButtonGroup();
	JRadioButton radioButtonMale=new JRadioButton("Male",true);
	JRadioButton radioButtonFemale=new JRadioButton("Female");
	
	JButton updateButton=new JButton("Update Student");
	JButton deleteButton=new JButton("Delete Student");
	JButton viewAllStudentButton=new JButton("View All student");
	
	
	JPanel panelNorth=new JPanel();
	JPanel panelWest=new JPanel();
	JPanel panelEast=new JPanel();
	JPanel panelSouth=new JPanel();

	public StudentManagement() {
		
		this.setTitle("Student Management"); 
		this.setSize(1370, 720);
		
		panelNorth.setBackground(Color.BLUE);
		panelNorth.setPreferredSize(new Dimension(200,100));
		
		panelNorth.add(homeStudentManagementButton);
		panelNorth.add("Center",labelPanelNorthTitle);
		
		homeStudentManagementButton.setPreferredSize(new Dimension(64,64));
		homeStudentManagementButton.setBackground(Color.white);
		
		//Label Title decoration
		labelPanelNorthTitle.setFont(new Font("Arial",Font.BOLD,30));
		labelPanelNorthTitle.setForeground(Color.white);
		scrollStudentsList.setPreferredSize(new Dimension(800, 500));
		
		panelEast.add(scrollStudentsList);
		
		panelWest.setLayout(new GridLayout(8,2,10,20));
		panelWest.setPreferredSize(new Dimension(500,400));
		
		panelWest.add(labelId);
		panelWest.add(textFieldId);

		panelWest.add(labelFirstName);
		panelWest.add(textFieldFirstName);
		
		//LastName
		panelWest.add(labelLastName);
		panelWest.add(textFieldLastName);
		
		//Telephone
		panelWest.add(labelPhoneNumber);
		panelWest.add(textFieldPhoneNumber);
		
		//Mail Address
		panelWest.add(labelMailAdress);
		panelWest.add(textFieldMailAdress);
		
		//Nationality
		panelWest.add(labelNationality);
		panelWest.add(comboNationality);
		
		//Sex radio Button
		buttonGroup.add(radioButtonFemale);
		buttonGroup.add(radioButtonMale);
		panelSexButton.add(radioButtonFemale);
		panelSexButton.add(radioButtonMale);
		panelWest.add(labelSex);
		panelWest.add(panelSexButton);
		
		//Training
		panelWest.add(labelTraining);
		panelWest.add(comboTraining);
		
		panelSouth.add(previousButton);
		panelSouth.add(viewAllStudentButton);
		panelSouth.add(updateButton);
		panelSouth.add(deleteButton);
		
		
		Container container=getContentPane();
		container.add("North",panelNorth);
		container.add("West",panelWest);
		container.add("East",panelEast);
		container.add("South",panelSouth);
		
		PEvent pEvent=new PEvent(this);
		viewAllStudentButton.addActionListener(pEvent);
		homeStudentManagementButton.addActionListener(pEvent);
		previousButton.addActionListener(pEvent);
		studentsList.addMouseListener(pEvent);
		updateButton.addActionListener(pEvent);
		deleteButton.addActionListener(pEvent);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new StudentManagement();
		

	}
	
}
