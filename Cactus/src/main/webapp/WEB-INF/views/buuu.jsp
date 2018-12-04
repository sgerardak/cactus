<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
        <head>
                <title>Juegito preguntas</title>
                <meta charset="utf-8"/>
				<spring:url value="/resources/Pregunta.css" var="preguntaCss" />
                <spring:url value="/resources/Cactus Perdiste.png" var="cactusPerdistePng" />
        
        	    <link href="${preguntaCss}" rel="stylesheet">
        </head>            
        
        <body>
                
                        <div class="header"><p>${e0}</p> <p>${e1}</p><p>${e2}</p> <p>${e3}</p><p>${e4}</p> <p>${e5}</p><p>${e6}</p> <p>${e8}</p></div> 
                        <div class="centered">
                          <img src="${cactusPerdistePng}" alt="Smile">

                        </div>
                        

                                <div class="rectangle"> <p>Perdiste amigo esta vez lograste ${este} estrellas.
                            Sabemos que tu tambien quieres preguntarnos cosas o tal vez alburearnos sigue el siguiente <a href="https://goo.gl/forms/lHhISim11zgA8RQO2">link</a> y 
                            preguntanos! Ya veremos que tan bueno eres! </p></div>

                      

                        
                      
        </body>

</html>