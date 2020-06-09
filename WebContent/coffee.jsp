<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

     <sql:setDataSource dataSource="jdbc/COFFEES" />

        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
        <html>
        <head>
        <title>COFFEE LIST</title>
        </head>
        <body>

        <h1>Find the Coffee List Here:</h1>

        Welcome to our coffee inventory. 
         
        <h2>This is our current stock and pricing</h2> 
        <table border='1'>
          <tr><th>Coffee Selection</th><th>Price</th></tr>

       <sql:query var="qryCoffees" >
                  SELECT COF_NAME, PRICE FROM COFFEES
          </sql:query>

       <c:forEach var="row" items="${qryCoffees.rows}">
	        <tr>
               <td><c:out value="${row.COF_NAME}" /></td>
                  <td><c:out value="${row.PRICE}" /></td>
	        </tr>
          </c:forEach>
        </table>

        </body>
        </html>