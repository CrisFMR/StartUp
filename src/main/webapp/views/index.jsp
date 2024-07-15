<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="" />
	<meta name="author" content="Cristopher Montecinos" />
    <title>Login</title>
<!-- BOOTSTRAP 5.3.3 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	
<!-- GoogleFonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&family=Permanent+Marker&display=swap" rel="stylesheet">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/assets/css/styles.css" rel="stylesheet" />
</head>
<body>
<main>
<section>
<div class="row justify-content-center align-items-center py-5">
<div class="card" style="width: 25rem;">
  <div class="card-body text-center">
  <img width="96" height="96" src="https://img.icons8.com/nolan/96/internet.png" alt="internet"/>
        <h2 class="lobster-regular p-4">Bienvenido(a)</h2>
        <hr>
        <div class="row mb-4 justify-content-center">
            <div class="col-4">
                <form action="${pageContext.request.contextPath}/views/register.jsp" method="get">
                    <button type="submit" class="btn">Registro</button>
                </form>
            </div>
            <div class="col-4">
                <form action="${pageContext.request.contextPath}/views/login.jsp" method="get">
                    <button type="submit" class="btn">Login</button>
                </form>
            </div>
        </div>
    </div>
   </div>
 	</div>
 	<h1 class="permanent-marker-regular text-light text-center">StartUP</h1>
 	<p class="text-center"><i class="fa-solid fa-rocket fa-rotate-by fa-xl" style="color: #ffffff; --fa-rotate-angle: 45deg;""></i></p>
</section>
</main>   
<footer class="p-3">
<div class="container pt-3">
<h6 class="text text-center fst-italic text-light opacity-50 lobster-regular">Todos los derechos reservados. ©2024 Praxis</h6>
</div>
</footer>
<!-- Script Bootstrap-->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/976707c066.js" crossorigin="anonymous"></script>
</body>
</html>