
import javax.swing.*;
import java.awt.event.*;
import  java.awt.*;

public class Acceuil extends JFrame{
	
	Student student;
	
	JPanel panelHaut=new JPanel();
	JPanel panelBas=new JPanel();
	JLabel welcomeLabel=new JLabel("Welcome to the Student Management Application");
	JButton autheticationButton=new JButton(new ImageIcon("C://Users//DELL//Desktop//JavaIcon/home1.png"));
	JButton etudiantButton=new JButton(new ImageIcon("C://Users//DELL//Desktop//JavaIcon/addStudent.png"));
	JButton parametreButton=new JButton(new ImageIcon("C://Users//DELL//Desktop//JavaIcon/admin.png"));
	

	public Acceuil() {
		
		this.setTitle("Acceuil");
		this.setSize(1370, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container= getContentPane();
		container.setLayout(new BorderLayout());
	   
		panelHaut.setPreferredSize(new Dimension(800, 400));
		panelHaut.setBackground(Color.blue);
		
		welcomeLabel.setFont(new Font("Arial",Font.LAYOUT_RIGHT_TO_LEFT,30));
		welcomeLabel.setForeground(Color.WHITE);
		panelHaut.add(welcomeLabel);
		
		panelBas.setPreferredSize(new Dimension(800,400));
		
		autheticationButton.setBackground(Color.white);
		etudiantButton.setBackground(Color.white);
		parametreButton.setBackground(Color.white);
		
		
		autheticationButton.setPreferredSize(new Dimension(160,160));
		etudiantButton.setPreferredSize(new Dimension(160,160));
		parametreButton.setPreferredSize(new Dimension(160,160));
		
		panelBas.add(autheticationButton);
	    panelBas.add(etudiantButton);
		panelBas.add(parametreButton); 
		
		
		container.add("North",panelHaut);
		container.add("Center",panelBas);
		setVisible(true);
		
		//Event of student button ** Displaying student page 
		PEvent pEvent=new PEvent(this);
		etudiantButton.addActionListener(pEvent);
		autheticationButton.addActionListener(pEvent);
		parametreButton.addActionListener(pEvent);
	}
	
	public static void main(String[] args) {
		
           new Acceuil();
	}

}
