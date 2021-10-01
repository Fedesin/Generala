package principal;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controlador.Controlador;
import controlador.IVista;
import modelo.Imodelo;
import modelo.Modelo;
import vista.VistaConsola;
import vista.VistaGrafica;

public class MainSinRMI {
	public static Imodelo m;
	public int i=1;

	public static void menuInicio() throws RemoteException {
		String[] opciones={"Agregar jugador", "Mostrar jugadores", "Iniciar partida"};
		Object opcion = JOptionPane.showInputDialog(null,"Menu principal",
				   "Seleccioné: ", JOptionPane.QUESTION_MESSAGE, null,
				  opciones,opciones[0]);
		if (opcion==opciones[0]) {//Si agrego jugador
			String nombre;
			nombre=JOptionPane.showInputDialog("Introduzca el nombre del jugador");
			m.AgregarJugador(nombre);
			if (m.cantidadDeJugadores()==1) {	
				Controlador c1 = new Controlador(m);
				VistaGrafica v1 = new VistaGrafica(c1);
				v1.setJugador();
			}
			if (m.cantidadDeJugadores()==2) {	
				Controlador c2 = new Controlador(m);
				VistaGrafica v2 = new VistaGrafica(c2);
				v2.setJugador();
			}
			menuInicio();
		}
	
		/*if (opcion==opciones[1]) {//Si quiere ver la lista de los jugadores
			String jugadores=m.getJugadoresFormateados();
			JOptionPane.showMessageDialog(null, jugadores);
			menuInicio();
		}*/
		if (opcion==opciones[2]) {//Si quiere iniciar el juego
			m.iniciar();
		}
	}
	
	
	
	public static void main(String args[]) throws RemoteException {
		m = new Modelo();
		String[] vistas={"Consola", "Grafica"};
		//cambiar aca si se va a utilizar la vista grafica o la vista de consola
		Object Opcion = JOptionPane.showInputDialog(null,"Seleccioné Una vista",
				   "Seleccioné la vista", JOptionPane.QUESTION_MESSAGE, null,
				  vistas,vistas[0]);
		if (Opcion==vistas[0]) {//Vista consola
		//IVista vista = new VistaConsola();
			//Controlador c = new Controlador(vista,m);
			menuInicio();
		}
		if (Opcion==vistas[1]) {//Vista grafica	
			menuInicio();
		} 		
	}
}
