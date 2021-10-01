package controlador;


import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;

public interface IVista {
		
	 	
	    //void menu(String nombre);
	 	//void ejecutar();//esto es solo para ejecutar la ventana de la vista grafica
	    void setControlador(Controlador controlador);
	    void menujugando() throws RemoteException;//menu
	    void tiradaRealizada();//menu
	    void mostrarTirada() throws RemoteException;//menu
	    void menuUltimaTirada() throws RemoteException ;//menu
	    void ganaste() throws RemoteException;//menu
	    void cambiarJugador() throws RemoteException;//menu
	   
	    void actualizarTablaDePuntos() throws RemoteException;//menu
	    void pasarAlSiguienteJugador() throws RemoteException;//menu
	    void menuVolverATirar() throws RemoteException ;//menu
	    void menuDobleGenerala() throws RemoteException ;//menu
	    void anotarGenerala() throws RemoteException ;//menu
	    void anotarPoker() throws RemoteException ;//menu
	    void anotarFull() throws RemoteException ;//menu
	    void anotarEscalera() throws RemoteException ;//menu
	    void preguntar6() ;//pregunta al usuario
	    void preguntar5() ;//pregunta al usuario
	    void preguntar4() ;//pregunta al usuario
	    void preguntar3() ;//pregunta al usuario
	    void preguntar2() ;//pregunta al usuario 
	    void preguntar1() ;//pregunta al usuario
	    void preguntarEscaleraServida() ;//pregunta al usuario
	    void preguntarFullServido() ;//pregunta al usuario
	    void preguntarPokerServido() ;//pregunta al usuario
	    void tacharPuntos() throws RemoteException  ;//pregunta al usuario
	    void mostrarGanador() throws RemoteException;//menu
	    void mostrarGanadorServido() throws RemoteException;
	    void finalizar();//menu
		void elijaUnLugarValidoATachar();//menu
		void setJugador() throws RemoteException;//le seteo un jugador a cada vista
		void agregadoCorrecto(String nombre);
		void mostrarJugadores(String string);
		void comenzarJuego();
}
