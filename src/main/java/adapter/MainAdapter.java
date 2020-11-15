package adapter;


import businessLogic.BLFacade;
import domain.User;
import fabric.BLFactory;
import gui.MainGUI;

public class MainAdapter {

	public static void main(String[] args) {
		int isLocal = 1;
		BLFacade blFacade = (new BLFactory()).createAppFace(isLocal);
		User u1 = blFacade.getUser("Mireia");
		
		WindowTable a=new WindowTable(u1);
		a.setVisible(true);

	}

}
