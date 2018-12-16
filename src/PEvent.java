
import java.awt.event.*;
import  java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseListener;

public class PEvent implements ActionListener,MouseListener{
	
	Acceuil acceuil;
	Student student;
	StudentManagement studentManagement;
	DatabaseManagement dataBaseManagement=new DatabaseManagement();
	
	
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
	
	public void actionPerformed(ActionEvent e) {
		
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
					addStudent();
					student.textFieldFirstName.setText("");
					student.textFieldLastName.setText("");
					student.textFieldPhoneNumber.setText("");
					student.textFieldMailAdress.setText("");
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
		String query="UPDATE student SET First_Name='"+studentManagement.textFieldFirstName.getText()+"',Last_Name='"+studentManagement.textFieldLastName.getText()+"',Phone_Number='"+studentManagement.textFieldPhoneNumber.getText()+"',Mail_Adress='"+studentManagement.textFieldMailAdress.getText()+"' WHERE Id_Student="+studentManagement.textFieldId.getText();
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
	

}
