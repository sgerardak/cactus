<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>JavaSpringWebApp</title>
    <meta name="description" content="" />

    <spring:url value="/resources/Pregunta.css" var="preguntaCss" />
    <spring:url value="/resources/Kaktus letrero.png" var="kaktusLetreroPng" />
    <spring:url value="/resources/Boton_juega.png" var="boton_juegaPng" />

    <link href="${preguntaCss}" rel="stylesheet">
  </head>
  <body>
        <div class="image">
        <img src="${kaktusLetreroPng}" alt="Smile"  id="kaktus">
    	</div>
    <div class="image2">
       <a href="pregunta"> <img src="${boton_juegaPng}" alt="botton" id="botton">
       </a>
    </div>
            

</body>
	</html>