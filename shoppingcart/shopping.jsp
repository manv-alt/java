<%@ page language="java" contentType="text/html;"%>
<%@ page import="java.util.*,javax.servlet.http.*"%>
<%
 List<String>cart;
    if(session.getAttribute("cart")==null){
        cart=new ArrayList<String>();
        session.setAttribute("cart",cart);    
        }else{
            cart=(List<String>)session.getAttribute("cart");
    }
    String itemToAdd =request.getParameter("item");
    if(itemToAdd!=null&&!itemToAdd.isEmpty()){
    cart.add(itemToAdd);
    }

    String itemToRemove =request.getParameter("removeItem");
    if(itemToRemove!=null&&!itemToRemove.isEmpty()){
    cart.remove(itemToRemove);
    }
    %>
    <html>
        <head>
            <title>shopping cart</title>
        </head>
        <body>
            <h1>Shopping Cart</h1>
            <form method="post" action="shopping.jsp">
                Add Item:<input type="text"name="item">
                <input type="submit"value="add to cart">
            </form>
            <h2>Cart Contents:</h2>
            <ul>
                <% for (String item:cart){%>
                <li>
                    <%=item%>
                    <a href="shopping.jsp?removeItem=<%=item %>">Remove</a>
                </li>
            <% } %> 
            </ul>
        </body>
    </html>