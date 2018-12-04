package com.aws.codestar.projecttemplates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Basic Spring MVC controller that handles all GET requests.
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

    private final String siteName;

    public HelloWorldController(final String siteName) {
        this.siteName = siteName;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("siteName", this.siteName);
        return mav;
    }
    static int estrellas=0;
	static int errores=0;
	static M4 quiz=new M4();
	static Random rand=new Random();
	static String table="preguntas";
	static LinkedList<Integer> a = new LinkedList<Integer>();
	static ImageIcon icon = new ImageIcon("Estrella sola.png");
	static Image im = icon.getImage();
	static int id; 
	static String cactusImagen;
	static String cactusPregunta="/resources/Cactus Normal.png";
	static String cactusCorrecto="/resources/Cactus Acertado.png";
	static String cactusError="/resources/Cactus Error.png";
	static String cactusAlbur="/resources/Cactus Albur.png";
	static String colorRojo="\"background-color:rgb(255, 0, 0)\"";
	static String colorVerde="\"background-color:rgb(0,255,0)\"";
	static String colorGris="\"background-color:lightgrey\"";
	static String imagenEstrella="<img src=\"/resources/Estrella sola.png\" alt =\"\"";
	static String colorResp1;// Lo estas usando para la prueba en el futuro usa el random
	static String colorResp2;
	static String colorResp3;
	static String ref1;
	static String ref2;
	static String ref3;	
	static int sizeT=quiz.numPreguntas(table);
	//static int sizeT=quiz.numPreguntas(table);
	

	@RequestMapping("/pregunta")
	public String changeRoom(Model model, 
			@RequestParam(name="respuesta", required=false, defaultValue="inicio") String resp,
			@RequestParam(name="posicion", required=false, defaultValue="0") int pos) {
		if(resp.equals("inicio")) {
			cactusImagen=cactusPregunta;
			colorResp1=colorGris;
			colorResp2=colorGris;
			colorResp3=colorGris;

			if(a.size()==sizeT) {
				a.removeAll(a);
				id=0;
				estrellas=0;
				errores=0;// estas usando este en vez de random solo para checar las preguntas este lo puedes camb
				return "Pregunta";}
			else {
				do
				{
					
					id =rand.nextInt(sizeT)+1;
					
				} while (a.contains(id));
				a.add(id);

		}
			quiz.set(a.getLast(),table);
			ref1=quiz.respuesta1;
			ref2=quiz.respuesta2;
			ref3=quiz.respuesta3;

		}else if(quiz.tipo.equals("A")) {
			cactusImagen=cactusAlbur;
			ref1="inicio";
			ref2="inicio";
			ref3="inicio";
			quiz.pregunta="OH OH TE ACABAMOS DE ALBUREAR HAHAHAH!";
			quiz.respuesta1="Eres";
			quiz.respuesta2="un/ a";
			quiz.respuesta3="pilluelo/ a!";
		}else if(quiz.checkAnswer(resp)) { 
		
			
			estrellas++;

			cactusImagen=cactusCorrecto;
			ref1="inicio";
			ref2="inicio";
			ref3="inicio";
			if(pos==1) {
				colorResp1=colorVerde;
			}else if(pos==2) {
				colorResp2=colorVerde;
			}else {
				colorResp3=colorVerde;
			}
		}
		else  {
			errores++;
			cactusImagen=cactusError;
			ref1="inicio";
			ref2="inicio";
			ref3="inicio";
			if(pos==1) {
				colorResp1=colorRojo;
			}else if(pos==2) {
				colorResp2=colorRojo;
			}else {
				colorResp3=colorRojo;
			}
			if(quiz.respuesta1.equals(quiz.respuestaCorrecta)) {
				colorResp1=colorVerde;
			}else if(quiz.respuesta2.equals(quiz.respuestaCorrecta)) {
				colorResp2=colorVerde;
			}else  {
				colorResp3=colorVerde;
			}	
		}
		
		
		
		for(int i=0;i<estrellas;i++) {
			model.addAttribute("e"+i,imagenEstrella);
		}
		model.addAttribute("cactusImagen", cactusImagen);
		model.addAttribute("colorResp1", colorResp1);
		model.addAttribute("colorResp2", colorResp2);
		model.addAttribute("colorResp3", colorResp3);
				


	
		model.addAttribute("respCorrecta",quiz.respuestaCorrecta);
		model.addAttribute("pregunta", quiz.pregunta);
		model.addAttribute("respuesta1",quiz.respuesta1);
		model.addAttribute("respuesta2", quiz.respuesta2);
		model.addAttribute("respuesta3", quiz.respuesta3);
		model.addAttribute("ref1",ref1);
		model.addAttribute("ref2",ref2);
		model.addAttribute("ref3",ref3);
		model.addAttribute("err", errores);
		model.addAttribute("este", estrellas);
		model.addAttribute("resp", resp);
	//	for(int i=1;i<estrellas+1;i++) {
			//model.addAttribute("e", "<img src=\"Estrella sola.png\" alt =\"\"");	/*te quedaste en el pedo de ir imprimiendo mas estrellitas y recuerda que eliminaste el return buuu cuando hay mas de dos errores vas bien animo*/
			//model.addAttribute("e"+i, "<img src=\"Estrella sola.png\" alt =\"\"");
		//}
		

		
		if(errores>2	) {
			errores=0;
			a.removeAll(a);
			id=0;
			estrellas=0;		
			return"buuu";}
		else {
			return "Pregunta";}

	}
	
	/*public class HelloController {
	    @RequestMapping("/")
	    public String hello(Model model) {
	        return "index";
	    }
	}*/
	
	
	
	
}