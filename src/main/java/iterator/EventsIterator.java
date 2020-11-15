package iterator;


import java.util.List;

import domain.Event;


public class EventsIterator<Event> implements ExtendedIterator {

	private List<Event> events;
	private int position;
	
	public EventsIterator(List<Event> events){
		this.events = events;
		this.position = 0;
	}
	


	@Override
	public Object previous() {
		// TODO Auto-generated method stub
		
		Event Event=events.get(position);
	
		position--;
		return Event;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return position>0;
	}
	
	@Override
	public void goLast() {
		// TODO Auto-generated method stub
		position=events.size()-1;
		
	}
	
	public boolean hasNext() {
		return position<events.size();
	}
	
	public Object next() {
		Event Events=events.get(position);
		position++;
		return Events;
	}



	@Override
	public void goFirst() {
		// TODO Auto-generated method stub
		position=0;
	}



}
