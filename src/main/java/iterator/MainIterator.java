package iterator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import businessLogic.BLFacade;
import configuration.ConfigXML;
import domain.Event;
import fabric.BLFactory;

public class MainIterator {

	static ConfigXML c = ConfigXML.getInstance();
	
	  static BLFacade facadeInterface = (new BLFactory()).createAppFace(1);

	public static void main(String[] args) {
		 boolean isLocal=true;
		 //Facade objektua lortu lehendabiziko ariketa erabiliz
		 //BLFacade facadeInterface=……….
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
			
			try {
				date = sdf.parse("17/12/2020");
				ExtendedIterator<Event> i= facadeInterface.getEventsIterator(date);
		 
		 Event ev;
		 i.goLast();
		 while (i.hasPrevious()){
		 ev=(Event) i.previous();
		 System.out.println(ev);
		 }
		 //Nahiz eta suposatu hasierara ailegatu garela, eragiketa egiten dugu.
		 i.goFirst();
		 while (i.hasNext()){
		 ev=(Event) i.next();
		 System.out.println(ev);
		 }


			} catch (ParseException e1) {
				System.out.println("Problems with date?? " + "17/12/2020");
			}

	}
}
	
