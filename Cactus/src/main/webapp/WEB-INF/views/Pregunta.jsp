<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
        <head>
                <title>Juegito preguntas</title>
                <meta charset="utf-8"/>
      			<spring:url value="/resources/Pregunta.css" var="preguntaCss" />
    			<spring:url value="/resources/Cactus Acertado.png" var="cactusAcertadoPng" />
    			<spring:url value="/resources/Cactus Albur.png" var="cactusAlburPng" />
    			<spring:url value="/resources/Cactus Error.png" var="cactusErrorPng" />
    			<spring:url value="/resources/Cactus Normal.png" var="cactusNormalPng" />
    			<spring:url value="/resources/Boton_juega.png" var="boton_juegaPng" />
    			<spring:url value="/resources/Estrella sola.png" var="estrellaPng" />

    			<link href="${preguntaCss}" rel="stylesheet">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        </head>            
        
        <body>
                
                        <div class="header"><p>${e0}</p> <p>${e1}</p><p>${e2}</p> <p>${e3}</p><p>${e4}</p> <p>${e5}</p><p>${e6}</p> <p>${e8}</p></div> 
                        <div class="centered">
                          <img src="${cactusImagen}" alt="Smile">
                        </div>
                        

                                <div class="rectangle"> <p>${pregunta}</p></div>
                             <ul>

                                    <div class="l1"><li style=${colorResp1}><a href="/pregunta?posicion=1&respuesta=<%=request.getAttribute("ref1")%>">${respuesta1}</a></li></div>
                                    <div class="l2"><li style=${colorResp2}><a href="/pregunta?posicion=2&respuesta=<%=request.getAttribute("ref2")%>">${respuesta2}</a></li></div>
                                    <div class="l3"><li style=${colorResp3}><a href="/pregunta?posicion=3&respuesta=<%=request.getAttribute("ref3")%>">${respuesta3}</a></li></div>
                                    
                            </ul>
                        

                        
                      
        </body>

</html>