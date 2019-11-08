
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DatabaseManagement {
	
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	
	String url="jdbc:mysql://localhost/miniprojetjavadb";
	String user="root";
	String password="";
	
	public DatabaseManagement() {
	
		connection=getConnection(url,user,password);
	}

	public Connection getConnection(String url,String user,String password) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error loading Driver");
		}
		try {
			return DriverManager.getConnection(url,user,password);
		}
		catch(Exception ex) {
			  System.out.println("Error connection");
		}
		return null;
	
	}

  public int updateQuery(String query) {
	  try {
		  statement=connection.createStatement();
	  }
	  catch(Exception e) {
		  System.out.println("Error creating statement");
	  }
	  try {
	  return statement.executeUpdate(query);
	  }
	  catch(SQLException e) {
		  System.out.println("Error execute update query"+e);
	  }
	  return -1;
  }
  
  public ResultSet selectQuery(String query) {
	  
	  try {
		  statement=connection.createStatement();
		  System.out.println("Statement OK");
	  }
	  catch(SQLException e) {
		  System.out.println("Error creating statement");
	  }
	  try{
		  return statement.executeQuery(query);
	  	}
	  catch(SQLException e) {
		  System.out.println("Error resultSet query");
	  }
	  return null;
  }

 public DefaultTableModel fillList(DefaultTableModel model,String query) {
	 try {
	 model.setRowCount(0);
	 resultSet=selectQuery(query);
	 int columsNumber=model.getColumnCount();
	 while(resultSet.next()) {
		 Object line[]=new Object[columsNumber];
		 for(int i=0;i<columsNumber;i++) 
			 line[i]=resultSet.getString(i+1);
		 model.addRow(line);
		 }
	 }
	 catch(SQLException e) {
		 System.out.println("Error resultSet: fillList ");
		 e.printStackTrace();
	 }
	 return model;
 }
}
