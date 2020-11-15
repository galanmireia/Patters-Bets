package adapter;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import domain.Apustua;

import domain.User;

public class UserAdapter extends AbstractTableModel {
	
	private Vector<Apustua> bets;
	private List<String> event = new ArrayList<String>();
	private List<String> question = new ArrayList<String>();
	private List<Date> date = new ArrayList<Date>();
	private List<Double> bet = new ArrayList<Double>();
	
	UserAdapter(User u){
		bets = u.getErabiltzailearenApustuak();
		for(int i=0; i<bets.size(); i++) {
			Apustua apuesta = bets.get(i);
			this.event.add(apuesta.getEventoAsociado().getDescription());
			this.question.add(apuesta.getPreguntaAsociada().getQuestion());
			this.date.add(apuesta.getEventoAsociado().getEventDate());
			this.bet.add(apuesta.getCantidad());
		}
	}

	@Override
	public int getRowCount() {
		return bets.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return event.get(rowIndex);
		}
		if(columnIndex == 1) {
			return question.get(rowIndex);
		}
		if(columnIndex == 2) {
			return date.get(rowIndex);
		}
		if(columnIndex == 3) {
			return bet.get(rowIndex);
		}
		
		return null;
	}

}


