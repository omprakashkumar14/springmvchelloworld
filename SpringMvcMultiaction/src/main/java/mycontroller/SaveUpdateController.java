package mycontroller;

 
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
 
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
 
public class SaveUpdateController extends MultiActionController {
	
	public ModelAndView DucatempsaveCurd(HttpServletRequest request,HttpServletResponse res) {
		 
		  
	//  public ModelAndView empsave(HttpServletRequest request,HttpServletResponse res) {
		  System.out.println("empsave...............");
		  int id  = Integer.parseInt(request.getParameter("id").trim());
		  try {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,request.getParameter("username").trim());
			ps.setString(3,request.getParameter("email").trim());
			ps.setString(4,request.getParameter("address").trim());
			int insert = ps.executeUpdate();
			if(insert != 0) 
				return new ModelAndView("success");
			else
				return new ModelAndView("fail");
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		  
		  return null;
	  }
	 public ModelAndView  DucatempupdateCurd(HttpServletRequest request,HttpServletResponse res) {
	 //public ModelAndView empupdate(HttpServletRequest request,HttpServletResponse res) {
		  int id  = Integer.parseInt(request.getParameter("id").trim());
		  try {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			PreparedStatement ps = conn.prepareStatement("update users set username=?,email=?,address=? where id=?");
			ps.setString(1,request.getParameter("username").trim());
			ps.setString(2,request.getParameter("email").trim());
			ps.setString(3,request.getParameter("address").trim());
			ps.setInt(4,id);
			int insert = ps.executeUpdate();
			if(insert != 0) 
				return new ModelAndView("success");
			else
				return new ModelAndView("fail");
		} catch (Exception e) {
			 e.printStackTrace();
		}
		  
		  
		  return null;
	  }

}
//create table users(id number ,username varchar(255),email varchar(255), address varchar(255));