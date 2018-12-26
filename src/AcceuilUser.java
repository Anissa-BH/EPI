
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AcceuilUser extends JFrame{
	
	Registration registration;
	
	
	JPanel panelHaut=new JPanel();
	JPanel panelBas=new JPanel();
	JPanel panelPicture = new JPanel();
	JLabel labelHomePicture = new JLabel(new ImageIcon("C://Users//DELL//Desktop//JavaIcon/epiGroupe.png"));
	JButton presentationButton=new JButton(new ImageIcon("C://Users//DELL//Desktop//JavaIcon/picture.png"));
	JButton registrationButton=new JButton(new ImageIcon("C://Users//DELL//Desktop//JavaIcon/registration.png"));
	JButton parametreButton=new JButton(new ImageIcon("C://Users//DELL//Desktop//JavaIcon/settings.png"));
	JButton autheticationButton=new JButton(new ImageIcon("C://Users//DELL//Desktop//JavaIcon/bigHome.png"));
	

	public AcceuilUser() {
		
		this.setTitle("Home user");
		this.setSize(1370, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container= getContentPane();
		container.setLayout(new BorderLayout());
	   
		panelHaut.setPreferredSize(new Dimension(800, 350));
		labelHomePicture.setPreferredSize(new Dimension(750,300));
		panelPicture.setPreferredSize(new Dimension(750, 700));
		panelPicture.add(labelHomePicture);
		panelHaut.setBackground(Color.WHITE);
		panelHaut.add(panelPicture);
		
		
		panelBas.setPreferredSize(new Dimension(800,400));
		panelBas.setBackground(Color.white);
		
		panelPicture.setPreferredSize(new Dimension(700, 300));
		
		//presentationButton.setBackground(Color.white);
		//registrationButton.setBackground(Color.white);
		//parametreButton.setBackground(Color.white);
		
		
		presentationButton.setPreferredSize(new Dimension(160,160));
		registrationButton.setPreferredSize(new Dimension(160,160));
		parametreButton.setPreferredSize(new Dimension(160,160));
		autheticationButton.setPreferredSize(new Dimension(160,160));
		
		panelBas.add(autheticationButton);
	    panelBas.add(registrationButton);
		panelBas.add(presentationButton);
	    panelBas.add(registrationButton);
	    panelBas.setBackground(Color.white);
		//panelBas.add(parametreButton); 
		
		container.add("North",panelHaut);
		container.add("Center",panelBas);
		setVisible(true);
		//Event of student button ** Displaying student page 
		PEvent pEvent=new PEvent(this);
		registrationButton.addActionListener(pEvent);
		presentationButton.addActionListener(pEvent);
		autheticationButton.addActionListener(pEvent);
				
	}
	
	public static void main(String[] args) {
		
           new AcceuilUser();
	}

}
