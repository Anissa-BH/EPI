import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Presentation extends JFrame implements ActionListener {

    JLabel pic = new JLabel();
    Timer tm;
    int x = 0;
    String[] list = {"C:/Users/DELL/Documents/p2.jpg",
    		     "C:/Users/DELL/Documents/p1.jpg",
    		     "C:/Users/DELL/Documents/p3.jpg",
    		     "C:/Users/DELL/Documents/p4.jpg",
		     "C:/Users/DELL/Documents/p5.jpg",
                     "C:/Users/DELL/Documents/p6.jpg",
    		     "C:/Users/DELL/Documents/p7.jpg",
                     "C:/Users/DELL/Documents/p8.jpg"
		    };

	public Presentation() {
	super("Java SlideShow");	
        pic.setBounds(0,0,1370, 700);
        setImageSize(2);
        tm = new Timer(2500,this);
        add(pic);
        tm.start();
        setLayout(null);
        this.setSize(1350, 700);
        getContentPane().setBackground(Color.decode("#bdb67b"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        PEvent pEvent=new PEvent(this);
	this.addKeyListener(pEvent);
	}
	
	public void actionPerformed(ActionEvent e) {
	setImageSize(x);
        x += 1;
        if(x >= list.length )
            x = 0;
        }
	
	public void setImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
        }
	public static void main(String[] args) {
        new Presentation();
	}

}
