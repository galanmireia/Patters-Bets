package gui;

import java.awt.Color;
import java.net.URL;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import fabric.BLFactory;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;

public class ApplicationLauncher  { 
	
	
	
	public static void main(String[] args) {

		ConfigXML c=ConfigXML.getInstance();
		
		System.out.println(c.getLocale());
		
		Locale.setDefault(new Locale(c.getLocale()));
		
		System.out.println("Locale: "+Locale.getDefault());
		
		BLFacade appFacadeInterface ;
		
		appFacadeInterface = (new BLFactory()).createAppFace(1);
		
		
		
		MainGUI.setBussinessLogic(appFacadeInterface);
		
		MainGUI a=new MainGUI();
		a.setVisible(true);
		

	}

}
