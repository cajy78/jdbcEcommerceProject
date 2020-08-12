package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/DisplayProducts")
public class DisplayProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try
		{
			String search = request.getParameter("searchVia");
			String query = "";
			//pw.write(search+"<br>");
			//pw.write("Query is now: "+query+"<br>");
			
			if(search.equals("viaProductID"))
			{
				String productID = request.getParameter("productID");
				if(productID.equals(""))
				{
					pw.write("Please enter a value within Product ID");
				}
				else {
					query = "Select * from Products where Product_ID="+productID;
					// test block pw.write("Query is now: "+query+"<br>");
				}
			}
			else if(search.equals("viaProductName"))
			{
				String productName = request.getParameter("productName");
				if(productName.equals(""))
				{
					pw.write("Please enter a Product Name");
				}
				else
				{
					query = "Select * from Products where Name='"+productName+"'";
					//pw.write("Query is now: "+query+"<br>");
				}
			}
			else if(search.equals("viaProductCat"))
			{
				String productCat = request.getParameter("productCategory");
				if(productCat.equals(""))
				{
					pw.write("Please enter a Product Category");
				}
				else
				{
					query = "Select * from Products where Category='"+productCat+"'";
					//pw.write("Query is now: "+query+"<br>");
				}
			}

			if(!query.equals(""))
			{
				//pw.write("Entered DB IF block Query is now: "+query+"<br>");
				Connection con = DatabaseConnection.InitiateDBConnection();
				Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stm.executeQuery(query);
				if(rs.next())
				{
					//pw.write("Entered RS If Block Query is now: "+query+"<br>");
					rs.beforeFirst();
					while(rs.next())
					{
						pw.write("There is data");
					}
				}
				else
				{
					pw.write("there's no data");
				}
			}
			else
			{
				pw.write("Enter data in text fields");
			}
		}
		catch(Exception e)
		{
			pw.write("Exception has occurred");
			e.printStackTrace();
		}
	}
}
