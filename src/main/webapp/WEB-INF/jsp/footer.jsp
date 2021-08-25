<%--
  Created by IntelliJ IDEA.
  User: fabiopetrisco
  Date: 18/08/21
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="./css/footer.css">
</head>
<body>

<footer class="footer">

    <div class="container">

        <div class="row">

            <div class="footer-col">
                <h4>Library</h4>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/IndexServlet">Home</a></li>
                    <li><a href="#">Chi siamo</a></li>
                </ul>
            </div>

            <div class="footer-col">
                <h4>Account</h4>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/OrdiniServlet">Ordini</a></li>

                </ul>
            </div>

            <div class="footer-col">
                <h4>Seguici</h4>
                <div class="social-links">
                    <a href="#"><i class="fab fa-facebook-f"></i></a>
                    <a href="#"><i class="fab fa-twitter"></i></a>
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>

        </div>

    </div>

</footer>

</body>
</html>