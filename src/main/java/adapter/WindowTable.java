package adapter;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import domain.User;

public class WindowTable extends JFrame{
	private User user;
	private JTable tabla;
	public WindowTable(User user1){
		this.setBounds(100, 100, 700, 200);
		this.user = user1;
		UserAdapter adapt = new UserAdapter(user);
		tabla = new JTable(adapt);
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(tabla);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}

