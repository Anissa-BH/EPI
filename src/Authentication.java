import javax.swing.*;
import java.awt.*;

public class Authentication extends JFrame{
	
	JLabel labelBackground = new JLabel(new ImageIcon("C://Users//DELL//Desktop//JavaIcon/jardin.png")); 
	JPanel panelBackground = new JPanel();
	JPanel globalPanelPicture = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelSouth = new JPanel();
	JPanel globalPanel = new JPanel();
	JLabel labellogin = new JLabel("Username");
	JTextField textLogin = new JTextField();
	JLabel labelPassword = new JLabel("Password");
	JPasswordField textPassword = new JPasswordField();
	JButton loginButton = new JButton("Login");
	

	public Authentication() {
		this.setTitle("Authentication");
		this.setSize(1370, 720);
		panelCenter.setLayout(new GridLayout(2, 2, 20, 20));
		panelCenter.add(labellogin);
		panelCenter.add(textLogin);
		panelCenter.add(labelPassword);
		panelCenter.add(textPassword);
		panelSouth.add(loginButton);
		globalPanel.setLayout(new BorderLayout());
		globalPanel.add("Center",panelCenter);
		globalPanel.add("South",panelSouth);
		panelBackground.add(labelBackground);
		globalPanelPicture.add(panelBackground);
		Container container=getContentPane();
		
		container.add("North",globalPanelPicture);
		container.add("South",globalPanel);
		
		this.setVisible(true);
		
		//authentication event processing
		PEvent event = new PEvent(this);
		loginButton.addActionListener(event);
		
	}
	
	public static void main(String[] args) {
		
        new Authentication();
	}

}
