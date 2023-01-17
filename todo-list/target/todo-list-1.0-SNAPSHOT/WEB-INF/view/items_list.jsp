<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="academy.learnprogramming.util.Mappings" %>

<html>
 <head>
  <title>Todo Items</title>
      <style>
    body{
           background-color:pink;
           color:white;
          }
      </style>
 </head>
<body>
    <div align="center">
    <c:url var="addUrl" value="${Mappings.ADD_ITEM}"/>
    <a href="${addUrl}">New Item</a>


        <table border="1" cellpadding="5">
        <caption><h2>Todo Items</h2><caption>

        <tr>
            <th>Title</th>
            <th>Deadline</th>

        </tr>
            <c:forEach var="item" items="${todoData.items}">
                 <tr>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.deadline}"/></td>

                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>