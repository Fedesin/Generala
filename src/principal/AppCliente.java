package principal;

import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ar.edu.unlu.rmimvc.RMIMVCException;
import ar.edu.unlu.rmimvc.Util;
import controlador.Controlador;
import controlador.IVista;
import vista.VistaConsola;
import vista.VistaGrafica;
import ar.edu.unlu.rmimvc.cliente.Cliente;

public class AppCliente{

	public static void main(String[] args) throws RemoteException {
		ArrayList<String> ips = Util.getIpDisponibles();
		String ip = (String) JOptionPane.showInputDialog(
				null, 
				"Seleccione la IP en la que escuchará peticiones el cliente", "IP del cliente", 
				JOptionPane.QUESTION_MESSAGE, 
				null,
				ips.toArray(),
				null
		);
		String port = (String) JOptionPane.showInputDialog(
				null, 
				"Seleccione el puerto en el que escuchará peticiones el cliente", "Puerto del cliente", 
				JOptionPane.QUESTION_MESSAGE,
				null,
				null,
				9999
		);
		String ipServidor = (String) JOptionPane.showInputDialog(
				null, 
				"Seleccione la IP en la corre el servidor", "IP del servidor", 
				JOptionPane.QUESTION_MESSAGE, 
				null,
				null,
				null
		);
		String portServidor = (String) JOptionPane.showInputDialog(
				null, 
				"Seleccione el puerto en el que corre el servidor", "Puerto del servidor", 
				JOptionPane.QUESTION_MESSAGE,
				null,
				null,
				8888
		);
		Controlador controlador = new Controlador();
		IVista vista = new VistaGrafica(controlador);
		controlador.setVista(vista);
		Cliente c = new Cliente(ip, Integer.parseInt(port), ipServidor, Integer.parseInt(portServidor));
		try {
			c.iniciar(controlador);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (RMIMVCException e) {
			e.printStackTrace();
		}
		String nombre=JOptionPane.showInputDialog("Introduzca el nombre del jugador");
		controlador.agregarJugador(nombre); 
		
	}
}

	
