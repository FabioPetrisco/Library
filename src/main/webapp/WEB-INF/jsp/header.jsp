<%--
  Created by IntelliJ IDEA.
  User: fabiopetrisco
  Date: 17/08/21
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <link rel="stylesheet" href="./css/header.css">
</head>
<body>
 <div class="header">
     <div class="logo">

     </div>

     <div class="barra_di_ricerca">
         <div class="elenco_categorie">
             <select name="categoria">
                 <option value="categoria1">categoria1</option>
                 <option>categoria2</option>
             </select>

         </div>
         <form>
             <input type="text" placeholder="Cerca libro">
             <input type="submit" value="Cerca">
         </form>
     </div>

     <div class="login_carrello">
         <p class="login"><a href="${pageContext.request.contextPath}/LogServlet">login</a></p>
         <p class="carrello"><a>carrello</a></p>
     </div>

 </div>

      <%@include file="footer.jsp"%>
</body>
</html>
