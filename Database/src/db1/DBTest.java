package db1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBTest extends DBConnection {
	

	private Connection conn=null;
	private PreparedStatement ps;
	private ResultSet rs=null;
	public DBTest() {
		conn=getConn();
	}
	public List<Employee> getAllEmp(){
		List<Employee> list=new ArrayList<Employee>();
		String sql="select * from employee";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				list.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DBTest t1=new DBTest();
		List<Employee> list=t1.getAllEmp();
		System.out.println(list);
		
	}

}
