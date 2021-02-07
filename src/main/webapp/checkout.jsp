<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html>
<html>
	<body>
		<%
			HttpSession sessionsa = request.getSession(false);
			String name = (String) sessionsa.getAttribute("username");
			String[] items = (String[]) sessionsa.getAttribute("itemsSelected");
		%>
		<h2>Hello <%=name%></h2>
		<h3>You Have Selected the Following Items</h3>
		<%
		if(items!=null){
			for(int i=0;i<items.length;i++){
				out.print(items[i]+"<br>");
			}
		}else{
			out.println("You have not selected any items.");
		}
		%>
		<br/><br/><br/><br/><br/>
		<form action=checkOut>
			<input type=submit value='Check Out'/>
		</form>
	</body>
</html>