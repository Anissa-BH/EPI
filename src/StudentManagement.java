import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentManagement extends JFrame {
	
	
	Student student;
	DatabaseManagement dataBaseManagement=new DatabaseManagement();
	
	JButton previousButton=new JButton("Previous");
	JButton homeStudentManagementButton=new JButton(new ImageIcon("C://Users//DELL//Desktop//JavaIcon//home.png"));
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
	
	JButton updateButton=new JButton("Update Student");
	JButton deleteButton=new JButton("Delete Student");
	JButton searchButton=new JButton("Search Student");
	JButton viewAllStudentButton=new JButton("View All student");
	
	
	JPanel panelNorth=new JPanel();
	JPanel panelWest=new JPanel();
	JPanel panelEast=new JPanel();
	JPanel panelSouth=new JPanel();

	public StudentManagement() {
		
		this.setTitle("Student Management"); 
		this.setSize(1370, 720);
		
		panelNorth.setBackground(Color.RED);
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
		
		panelWest.setLayout(new GridLayout(5,2,10,40));
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
		
		//MailAdress
		panelWest.add(labelMailAdress);
		panelWest.add(textFieldMailAdress);
		
		
		panelSouth.add(previousButton);
		panelSouth.add(viewAllStudentButton);
		panelSouth.add(updateButton);
		panelSouth.add(deleteButton);
		panelSouth.add(searchButton);
		
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
