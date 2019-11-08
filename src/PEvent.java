
import java.awt.event.*;
import  java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PEvent implements ActionListener,MouseListener,KeyListener{
	
	Acceuil acceuil;
	AcceuilUser acceuilUser;
	Student student;
	Registration registration;
	Presentation presentation;
	StudentManagement studentManagement;
	DatabaseManagement dataBaseManagement=new DatabaseManagement();
	Authentication authentication;
	String username;
	
	public PEvent(Acceuil acceuil) {
		this.acceuil=acceuil;	
	}
	
	public PEvent(Student students) {
		this.student=students;
		//dataBaseManagement= new DatabaseManagement();
	}
	public PEvent(StudentManagement studentManagement) {
		this.studentManagement=studentManagement;
	}
	public PEvent(Authentication authentication) {
		this.authentication=authentication;
	}
	public PEvent(AcceuilUser acceuilUser) {
		this.acceuilUser=acceuilUser;	
	}
	public PEvent(Registration registration) {
		this.registration=registration;	
	}
	public PEvent(Presentation presentation) {
	        this.presentation=presentation;
	}
	
	public void actionPerformed(ActionEvent e) {
		
			//User home - go to Registration page
				if(acceuilUser!=null && e.getSource()==acceuilUser.registrationButton) {
					new Registration();
					acceuilUser.setVisible(false);
				}
				//To do registration
				if(registration!=null && e.getSource()==registration.validateRegistrationButton) {
					addRegistration();
					new AcceuilUser();
					registration.setVisible(false);
				}
				// to display slideShow
				if(acceuilUser!=null && e.getSource()==acceuilUser.presentationButton) {
					new Presentation();
					acceuilUser.setVisible(false);
				}
				// from acceuil user to home page
				if(acceuilUser!=null && e.getSource()==acceuilUser.autheticationButton) {
					new Authentication();
					acceuilUser.setVisible(false);
				}
				
				// to return from registration page to home page
				if(registration!=null && e.getSource()==registration.homeRegistrationButton) {
					new AcceuilUser();
					registration.setVisible(false);
				}
				
			        //Login
				if(authentication!=null && e.getSource()==authentication.loginButton) {
					String query="SELECT login FROM user WHERE login ='"+authentication.textLogin.getText()+"' and password ='"+authentication.textPassword.getText()+"'";
					ResultSet resultSet=dataBaseManagement.selectQuery(query);
					
					try {
						if(!resultSet.isBeforeFirst()) {
							JOptionPane.showMessageDialog(null, "Username or password incorrect","identification",JOptionPane.ERROR_MESSAGE);							
						}
					}
					catch(Exception e1) {
						System.out.println("Error for verify is resultset is empty");
						e1.printStackTrace();
					}
					try {
						while(resultSet.next()) {
						username= resultSet.getString("login");
						if(username.equals("demo"))
							new Acceuil();
						else
						new AcceuilUser();
						}
						resultSet.close();
					}
					catch(Exception exception) {
					System.out.println("Problem when recovering the username");
					exception.printStackTrace();
					}
				}
			        //Event to go to identification page
				if(acceuil!=null && e.getSource()==acceuil.autheticationButton) {
					new Authentication();
					acceuil.setVisible(false);
				}
			        //from home page to management student page
				if(acceuil!=null && e.getSource()==acceuil.parametreButton) {
					new StudentManagement();
					acceuil.setVisible(false);
				}
			    
			        //Event of student button in home page
				if(acceuil!=null && e.getSource()==acceuil.etudiantButton) {
					
					Student student=new Student();
					acceuil.setVisible(false);
					}
			
			        //Event of home button in student page
				if(student!=null && e.getSource()==student.homeStudentButton) {
					Acceuil acceuil=new Acceuil();
					student.setVisible(false);
					}
			        //Event of home button in student management page
						if(studentManagement!=null && e.getSource()==studentManagement.homeStudentManagementButton) {
							Acceuil acceuil=new Acceuil();
							studentManagement.setVisible(false);
							}
			        //Add student event
				if(student!=null && e.getSource()==student.addStudentButton) {
					
					if ((student.textFieldFirstName.getText().trim().length() > 0) && (student.textFieldLastName.getText().trim().length() > 0) &&(student.textFieldPhoneNumber.getText().trim().length() > 0) && (student.textFieldMailAdress.getText().trim().length() > 0)) {
						
						addStudent();
						student.textFieldFirstName.setText("");
						student.textFieldLastName.setText("");
						student.textFieldPhoneNumber.setText("");
						student.textFieldMailAdress.setText("");
					}
					else
						JOptionPane.showMessageDialog(null,"Empty field not allowed", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			        //Show student management JFrame 
				if(student!=null && e.getSource()==student.studentManagementButton) {
					
					new StudentManagement();
					student.setVisible(false);
					}
			        // View All student event button
				if(studentManagement!=null && e.getSource()==studentManagement.viewAllStudentButton) {
					viewStudents();
				}
				
				if(studentManagement!=null && e.getSource()==studentManagement.previousButton) {
					new Student();
					studentManagement.setVisible(false);
				}
				
				if(studentManagement!=null && e.getSource()==studentManagement.updateButton) {
					updateStudent();
					refresh();
				}
				
				if(studentManagement!=null && e.getSource()==studentManagement.deleteButton)
					deleteStudent();
					refresh();
	}
	
	public void mouseClicked(MouseEvent e) {
		
		DefaultTableModel model=(DefaultTableModel)studentManagement.studentsList.getModel();
		int selectedRowIndex=studentManagement.studentsList.getSelectedRow();
		
		studentManagement.textFieldId.setText(model.getValueAt(selectedRowIndex, 0).toString());
		studentManagement.textFieldFirstName.setText(model.getValueAt(selectedRowIndex, 1).toString());
		studentManagement.textFieldLastName.setText(model.getValueAt(selectedRowIndex, 2).toString());
		studentManagement.textFieldPhoneNumber.setText(model.getValueAt(selectedRowIndex, 4).toString());
		studentManagement.textFieldMailAdress.setText(model.getValueAt(selectedRowIndex, 5).toString());
		
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	
	// Add informations
	public void addStudent() {
			String sex="Homme";
			if(student!=null && student.radioButtonFemale.isSelected()) 
				sex="Femme";
				
			String query="INSERT INTO student (First_Name,Last_Name,Sex,Phone_Number,Mail_Adress,Nationality,Training) VALUES ('"+student.textFieldFirstName.getText()+"','"+student.textFieldLastName.getText()+"','"+sex+"',"+student.textFieldPhoneNumber.getText()+",'"+student.textFieldMailAdress.getText()+"','"+student.comboNationality.getSelectedItem()+"','"+student.comboTraining.getSelectedItem()+"')";
			JOptionPane.showMessageDialog(null, (dataBaseManagement.updateQuery(query)>0)?"Student added":"Student not added", "Confirm message", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void viewStudents() {      
			String query="SELECT * FROM student";
			dataBaseManagement.fillList(studentManagement.model,query);
		}
	
	public void updateStudent() {
		String sex="Homme";
		if(studentManagement!=null && studentManagement.radioButtonFemale.isSelected()) 
			sex="Femme";
		
		String query="UPDATE student SET First_Name='"+studentManagement.textFieldFirstName.getText()+"',Last_Name='"+studentManagement.textFieldLastName.getText()+"',Sex='"+sex+"',Nationality='"+studentManagement.comboNationality.getSelectedItem()+"',Phone_Number='"+studentManagement.textFieldPhoneNumber.getText()+"',Mail_Adress='"+studentManagement.textFieldMailAdress.getText()+"',Training='"+studentManagement.comboTraining.getSelectedItem()+"' WHERE Id_Student="+studentManagement.textFieldId.getText();
		JOptionPane.showMessageDialog(null, (dataBaseManagement.updateQuery(query)>0)?"Student uppdated":"Student not uppdated", "Confirm message", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void deleteStudent() {
		String query="DELETE FROM student WHERE Id_Student="+studentManagement.textFieldId.getText();
		JOptionPane.showMessageDialog(null, (dataBaseManagement.updateQuery(query)>0)?"Student deleted":"Student not deleted", "Confirm message", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void refresh() {
		    studentManagement.textFieldId.setText("");
		    studentManagement.textFieldFirstName.setText("");
		    studentManagement.textFieldLastName.setText("");
		    studentManagement.textFieldPhoneNumber.setText("");
		    studentManagement.textFieldMailAdress.setText("");
	}
	
	public void addRegistration() {
		String sex="Homme";
		if(student!=null && student.radioButtonFemale.isSelected()) 
			sex="Femme";
			
		String query="INSERT INTO student (First_Name,Last_Name,Sex,Phone_Number,Mail_Adress,Nationality,Training) VALUES ('"+registration.textFieldFirstName.getText()+"','"+registration.textFieldLastName.getText()+"','"+sex+"',"+registration.textFieldPhoneNumber.getText()+",'"+registration.textFieldMailAdress.getText()+"','"+registration.comboNationality.getSelectedItem()+"','"+registration.comboTraining.getSelectedItem()+"')";
		JOptionPane.showMessageDialog(null, (dataBaseManagement.updateQuery(query)>0)?"You are registered !":"Error", "Confirm message", JOptionPane.INFORMATION_MESSAGE);
}
	
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) 
			presentation.setVisible(false);
			new AcceuilUser();
	}
	
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}

}
