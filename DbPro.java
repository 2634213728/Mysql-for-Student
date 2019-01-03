import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbPro{
	Connection connection = null;
	ResultSet rs = null;

	//mysql���ݿ�url
	String userMySql="root"; 
	String passwordMySql="705010610";
	String urlMySql = "jdbc:mysql://localhost:3306/note?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
	
	
	public DbPro() {
		try {
			//mysql���ݿ�����������������
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//System.out.println("mysql���ݿ��������سɹ�");
	        System.out.println("mysql���ݿ��������سɹ�");

		}
		catch(java.lang.ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void connect(){
		try{
			//mysql���ݿ�
			connection = DriverManager.getConnection(urlMySql,userMySql,passwordMySql);  
			if(connection!=null){
	            System.out.println("���ݿ����ӳɹ�");
	        }
		}
		catch(Exception e){
			System.out.printf("chucuo");
			e.printStackTrace();
		}
	}
	
	public void disconnect(){
		try{
			if(connection != null){
				connection.close();
				connection = null;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


	public ResultSet executeQuery(String sql) {
		try {
			System.out.println("executeQuery(). sql = " + sql);
			
			PreparedStatement pstm = connection.prepareStatement(sql);
			// ִ�в�ѯ
			
			rs = pstm.executeQuery();
		} 
		catch(SQLException ex) { 
			ex.printStackTrace();
		}
		return rs;
	}
	
	//����
	//executeUpdate �ķ���ֵ��һ��������ָʾ��Ӱ��������������¼�������
	//executeUpdate����ִ�� INSERT��UPDATE �� DELETE ���
	//�Լ� SQL DDL�����ݶ������ԣ���䣬���� CREATE TABLE �� DROP TABLE��
	
	//ִ������ɾ�������ķ���
	public int executeUpdate(String sql) {
		int count = 0;
		connect();
		try {
			Statement stmt = connection.createStatement();
			count = stmt.executeUpdate(sql);
		} 
		catch(SQLException ex) { 
			System.err.println(ex.getMessage());		
		}
		disconnect();
		return count;
	}
}
