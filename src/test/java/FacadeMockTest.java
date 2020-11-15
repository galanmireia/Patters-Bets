import static org.junit.Assert.assertTrue;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.TypedQuery;

import org.junit.Test;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.User;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FacadeMockTest {
	DataAccess DataAccess=Mockito.mock(DataAccess.class);


	@InjectMocks
	BLFacade sut=new BLFacadeImplementation(DataAccess);  
	
	/* public Vector<Event> getEvents(Date date) {
		System.out.println(">> DataAccess: getEvents");
		Vector<Event> res = new Vector<Event>();	
		TypedQuery<Event> query = db.createQuery("SELECT ev FROM Event ev WHERE ev.eventDate=?1",Event.class);   
		query.setParameter(1, date);
		List<Event> events = query.getResultList();
	 	 for (Event ev:events){
	 	   System.out.println(ev.toString());		 
		   res.add(ev);
		  }
	 	return res;
	}
	*/
	
	//Estaliko den baliokidetasun klasea 2, 3 . Exception bat egon beharko litzateke, baina ez da kontuan hartzen.
		@Test
		public void test1() {
			try {
				
				Date date = null;
			
				
					Vector<Event>	resul = sut.getEvents(date);
					assertTrue(resul==null);
					 System.out.println("Date ez da existitzen Vector<Event> resul == null");
			
				
			   } catch (NullPointerException e) {
				// TODO Auto-generated catch block
				   fail();
				
				} 
			   }
		//Estaliko den baliokidetasun klasea 1 ,4
		
		@Test
		public void test2() throws ParseException {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date date=null;
				
				Vector<Event> listaEvents = new Vector<Event>();
				Event e = new Event(1,"Mireia",date);
				Event e2 = new Event(2,"Mireia2",date);
				listaEvents.add(e);
				listaEvents.add(e2);
				
					date = sdf.parse("19/10/2020");
					
					Mockito.doReturn(listaEvents).when(DataAccess).getEvents(Mockito.any());
					
					Vector<Event>	resul = sut.getEvents(date);
				
					assert (resul == listaEvents);
					
			}catch(NullPointerException e) {
				// TODO Auto-generated catch block
				   fail();
		}
	
}
		
		@Test
		public void test3() throws ParseException { //Estaliko den baliokidetasun klasea 1 ,5 Exception bat egon beharko litzateke, baina ez da kontuan hartzen.
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date date=null;
				
				Vector<Event> listaEvents = new Vector<Event>();
				Event e = new Event(1,"Mireia",date);
				listaEvents.add(e);
				
					date = sdf.parse("17/10/2020");
					
					Mockito.doReturn(listaEvents).when(DataAccess).getEvents(Mockito.any());
					
					Vector<Event>	resul = sut.getEvents(date);
				
					assert (resul == listaEvents);
					
			}catch(NullPointerException e) {
				// TODO Auto-generated catch block
				   fail();
		}
	
}
		
		
	
}