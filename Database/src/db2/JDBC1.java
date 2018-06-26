package db2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC1 {
   // JDBC driver name and database URL
   static final String driver = "com.mysql.jdbc.Driver";  
   static final String url = "jdbc:mysql://localhost/crmdb?useUnicode=true&characterEncoding=utf-8";

   //  Database credentials
   static final String username = "root";
   static final String password = "yyc19970204";

   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   ResultSet rs=null;
   Customer c=null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(driver);

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(url,username,password);

      //STEP 4: Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();
      
      String sql2 = "use crmdb";
      stmt.executeUpdate(sql2);
      System.out.println("Database changed...");
      
      String sql3 = "create table customer(cid integer not null primary key,name varchar(20),principalship varchar(10),company varchar(40),telephone varchar(20),address varchar(40))ENGINE=InnoDB DEFAULT CHARSET=utf8";
      stmt.executeUpdate(sql3);
      System.out.println("table created...");
      
      String sql4 = "insert into customer values(2017001,'胡振','总经理','华夏大邦','8226858','上海'),(2017002,'李兴','经理','九州方圆','6182755','北京'),(2018001,'江中','董事长','时代在线','8372168','长沙'),(2018002,'郭华','董事长','光华集团','8221089','深圳')";
      stmt.executeUpdate(sql4);
      System.out.println("inserted...");
      
      String sql5 = "select *from customer where company='时代在线'";
      rs=stmt.executeQuery(sql5);
      while(rs.next())
      {
    	  c=new Customer();
    	  c.setCid(rs.getInt("cid"));
    	  c.setName(rs.getString("name"));
    	  c.setPrincipalship(rs.getString("principalship"));
    	  c.setCompany(rs.getString("company"));
    	  c.setTelephone(rs.getString("telephone"));
    	  c.setAddress(rs.getString("address"));
      }
      System.out.println("时代在线基本信息："+c);
      
      String sql6 = "update customer set telephone='021-8226859' where name='胡振'";
      stmt.executeUpdate(sql6);
      System.out.println("updated...");
      
      String sql7 = "delete from customer where cid=2017002";
      stmt.executeUpdate(sql7);
      System.out.println("deleted...");
      
      List<Customer> list=new ArrayList<Customer>();
      String sql8 = "select *from customer";
      rs=stmt.executeQuery(sql8);
      while(rs.next())
      {
    	  c=new Customer();
    	  c.setCid(rs.getInt("cid"));
    	  c.setName(rs.getString("name"));
    	  c.setPrincipalship(rs.getString("principalship"));
    	  c.setCompany(rs.getString("company"));
    	  c.setTelephone(rs.getString("telephone"));
    	  c.setAddress(rs.getString("address"));
    	  list.add(c);
      }
      System.out.println("所有信息："+list);
   }catch(SQLException se){
      
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }finally{
     
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   System.out.println("Goodbye!");
}
}