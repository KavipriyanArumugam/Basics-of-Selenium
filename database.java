import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class database {

		// TODO Auto-generated method stub
		public Connection getConnection(){
			Connection connection=null;
		String jdbcURl="jdbc:postgresql://localhost:5432/datapg";
		String username = "postgres";
		String password = "admin123";
       try {
		connection = DriverManager.getConnection(jdbcURl,username,password);
		if (connection!=null) {
			System.out.println("connect to postgres server");
		}else {
			System.out.println("failed to connect to postgres server");
		}
		
		java.sql.Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("SELECT VERSION()");
		if(resultSet.next()){
			System.out.println(resultSet.getString(1));
		}
	} catch (SQLException e) {
		System.out.println("Error");
		e.printStackTrace();
	}
	return connection;

	}
		public static void main(String[] args) throws SQLException {
			// TODO Auto-generated method stub
			database connectDatabasedemo=new database();
			System.out.println(connectDatabasedemo.getConnection());
			Connection connection=connectDatabasedemo.getConnection();
			java.sql.Statement statement=null;
			//String queryString="create table employee(id SERIAL primary key ,firstname varchar(25),address varchar(25))";
			//	String queryString="insert into employee(firstname,address) values('kavi','india')";
			//	String queryString="delete from employee where firstname='kavi'";
			String queryString="drop table employee";
			statement=connection.createStatement();
			
			statement.executeUpdate(queryString);
		}	
}


	