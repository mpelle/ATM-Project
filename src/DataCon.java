
import java.sql.*;

public class DataCon{
	public Connection con;
	public String url="jdbc:mysql://127.0.0.1:3306/test";//db location
	public String message;

//connect to db
public boolean connection(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		 
	}catch(ClassNotFoundException e){
		message=e.getMessage();
		System.exit(-1);
	}

	try{
		con=DriverManager.getConnection(url,"root","");
		
		return true;
	}catch(SQLException ex){
		message=ex.getMessage();
		return false;
	}
}

//�ر����ݿ������
public boolean close(){
	try{
		con.close();
		return true;
	}catch(Exception ex){
		message=ex.getMessage();
		return false;
	}
}


//ʹ��SQL��������������
public ResultSet exeSQL(String sqlstr){
	try{
		connection();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sqlstr);
		return rs;
	}catch(Exception ex){
		message=ex.getMessage();
		System.out.print("test");
	}
		return null;
}

//ʹ��SQL���������ݵĸ���
public int exeUpdate(String sqlstr){
	try{
		connection();
		Statement stmt=con.createStatement();
		int temp=stmt.executeUpdate(sqlstr);
		return temp;	
	}catch(Exception ex){
		message=ex.getMessage();	
	}
		return 0; 
}
//public static void main(String args[])
//{
//	DataCon databaseCon=new DataCon();
//	
//	//if(databaseCon.connection())
//	//{
//	//	System.out.println("�������ݿ�ɹ�����");
//		String check="select * from customer where ID=801 and password='123456'";
//		System.out.println(check);
//		ResultSet rs=null;
//		rs=databaseCon.exeSQL(check);
//
//		try {
//			if(rs.next())
//			{
//				String avBalance=rs.getString("availableBalance"); 
//				String totalMoney=rs.getString("totalBalance");
//				System.out.println(avBalance);
//				System.out.println(totalMoney);
//				Account accounts = new Account(801, 123456,Double.valueOf(avBalance),Double.valueOf(totalMoney));
//				//accounts[1]=new Account();
//				//return true;
//			}
//			else 
//				System.out.println("sdfsdf");
//		} catch (SQLException e) {
//		
//			e.printStackTrace();
//			System.out.println("Error!");
//		}
//
//	//}
//
//}
}