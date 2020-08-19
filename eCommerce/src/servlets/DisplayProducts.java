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
			
			if(search.equals("viaProductID"))
			{
				String productID = request.getParameter("productID");
				if(productID.equals(""))
				{
					pw.write("Please enter a value within Product ID");
				}
				else
				{
					query = "Select * from Products where Product_ID="+productID;
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
					query = "Select * from Products where Name LIKE '%"+productName+"%'";
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
					query = "Select * from Products where Category LIKE '%"+productCat+"%'";
				}
			}

			if(!query.equals(""))
			{
				Connection con = DatabaseConnection.InitiateDBConnection();
				Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stm.executeQuery(query);
				if(rs.next())
				{
					pw.write("<h1>Product Info Page</h1>");
					pw.write("<table border=1>");
					pw.write("<thead><tr><th>Name</th><th>Category</th><th>Sub-Category</th>"
							+ "<th>Price</th><th>Stock</th><th>Description</th></tr></thead>");
					pw.write("<tbody>");
					rs.beforeFirst();
					while(rs.next())
					{
						pw.write("<tr>"
									+"<td>"+ rs.getString(2)+"</td>"
									+ "<td>"+ rs.getString(3)+"</td>"
									+ "<td>"+ rs.getString(4)+"</td>"
									+ "<td>"+ rs.getFloat(5)+"</td>"
									+ "<td>"+ rs.getInt(6)+"</td>"
									+ "<td>"+ rs.getString(7)+"</td>"
									+"</tr>");
					}
					pw.write("</tbody>");
					pw.write("</table>");
					pw.write("<br><br><a href='index.html'>Products Master Page</a>");
				}
				else
				{
					pw.write("<h1>Product Info Page</h1>");
					pw.write("<p style='color:red'>No data exists with the current selection</p>");
					pw.write("<p style='color:red'>Please enter correct Product ID Or Name Or Category</p>");
					pw.write("<br><br><a href='index.html'>Products Master Page</a>");
				}
			}
		}
		catch(Exception e)
		{
			pw.write("Exception has occurred");
			e.printStackTrace();
		}
	}
}
