package fabric;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import gui.MainGUI;

public class BLFactory {
	
	private static ConfigXML c=ConfigXML.getInstance();



	public BLFacade createAppFace(int afi) {

	try {
		
		BLFacade appFacadeInterface;
//		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
//		UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			if(afi == 1) {
		
			
			//In this option the DataAccess is created by FacadeImplementationWS
			//appFacadeInterface=new BLFacadeImplementation();

			//In this option, you can parameterize the DataAccess (e.g. a Mock DataAccess object)

			DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
			BLFacadeImplementation a = new  BLFacadeImplementation(da);
			
			return a;
			
		}
		
		else { //If remote
			
			 String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
			 
			//URL url = new URL("http://localhost:9999/ws/ruralHouses?wsdl");
			URL url = new URL(serviceName);

	 
	        //1st argument refers to wsdl document above
			//2nd argument is service name, refer to wsdl document above
//	        QName qname = new QName("http://businessLogic/", "FacadeImplementationWSService");
	        QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
	 
	        Service service = Service.create(url, qname);

	         appFacadeInterface = service.getPort(BLFacade.class);
	         return appFacadeInterface;
		} 
		/*if (c.getDataBaseOpenMode().equals("initialize")) 
			appFacadeInterface.initializeBD();
			*/
		//MainGUI.setBussinessLogic(appFacadeInterface);
		
	

		
	}catch (Exception e) {
		
		
		System.out.println("Error in ApplicationLauncher: "+e.toString());
	}
	//a.pack();
	return null;


}

}
