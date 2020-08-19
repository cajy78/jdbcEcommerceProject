package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {

    private static final long serialVersionUID = 1L;
	private PreparedStatement pstm;
	private static Connection con;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		
		PrintWriter pw = response.getWriter();
		String cust_Name = request.getParameter("customer_Name");
		String city = request.getParameter("city");
		String mobile = request.getParameter("mobile");
		//System.out.println(cust_Name);
		pw.println("The Customer's name is: "+cust_Name);
		pw.println("");
		pw.println("The Customer's located in: "+city);
		pw.println("");
		pw.println("The Customer's mobile number is: "+mobile);
		pw.println("");
		try
		{
			Connection con = DatabaseConnection.InitiateDBConnection();
			pstm = con.prepareStatement("insert into customer(Name, city, Mobile_no) values(?,?,?)");
			pstm.setString(1, cust_Name);
			pstm.setString(2, city);
			pstm.setString(3, mobile);
			if(pstm.executeUpdate()==1)
				response.sendRedirect("index.html");
			else
				pw.println("Something went wrong in updating the database");
			pw.println("");
		}
		catch(Exception e)
		{
			pw.println("");
			pw.println("There was an exception while adding the info to the database");
			System.out.println("Errrrrrr...............................:");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstm.close();
				con.close();
			}
			catch(Exception e)
			{
				pw.println("");
				pw.println("There was an exception while trying to close the connection to the database");
				pw.println(e.getStackTrace());
			}
		}
	}
}
