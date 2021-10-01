package modelo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

public interface Imodelo extends IObservableRemoto{

	int getTurno() throws RemoteException;

	void setTurno(int turno) throws RemoteException;

	int getRonda() throws RemoteException;

	void setRonda(int ronda) throws RemoteException;

	void setCubilete(Cubilete c) throws RemoteException;

	ArrayList<Jugador> getJugadores() throws RemoteException;

	void AgregarJugador(String nombre) throws RemoteException;

	void iniciar() throws RemoteException;

	String getJugadoresFormateados() throws RemoteException;

	String mostrarJugador(int turno) throws RemoteException;

	int mostrarPuntos(int turno) throws RemoteException;

	int mostrarTabla(int turno, int lugarPuntaje) throws RemoteException;

	void realizarTirada() throws RemoteException;

	boolean consultarGenerala() throws RemoteException;

	int consultarDado(int dadoNumero) throws RemoteException;

	boolean consultarEscalera() throws RemoteException;

	int controlarPuntos(int numJugador, int lugarEnLaTabla) throws RemoteException;

	void sumarPuntos(int numJugador, int puntosASumar, int lugarEnLaTabla) throws RemoteException;

	void actualizarAJugando() throws RemoteException;

	int cantidadDeJugadores() throws RemoteException;

	boolean consultarFull() throws RemoteException;

	boolean consultarPoker() throws RemoteException;

	void pasarTurno(int turno) throws RemoteException;

	void cambiarJugador() throws RemoteException;

	void tirarDado(int lugarDado) throws RemoteException;

	boolean puntajeDisponible(int numJugador, int lugarTabla) throws RemoteException;

	boolean consultar6() throws RemoteException;

	boolean consultar5() throws RemoteException;

	boolean consultar4() throws RemoteException;

	boolean consultar3() throws RemoteException;

	boolean consultar2() throws RemoteException;

	boolean consultar1() throws RemoteException;

	int calcularPuntos(int numero) throws RemoteException;

	void tacharTabla(int turno, int lugarATachar) throws RemoteException;

	void actualizarAFinalizar() throws RemoteException;

	String consultarGanador() throws RemoteException;

	boolean consultarDobleGenerala(int numJugador) throws RemoteException;

	void actualizarAGanadorServido() throws RemoteException;

	void actualizarATercerTirada() throws RemoteException;

	void actualizarAConsultarPuntos() throws RemoteException;

	void actualizarAMenuInicial() throws RemoteException;

	void jugadorListo(int jugador) throws RemoteException;

	void actualizarAEscaleraServida() throws RemoteException;
	
	void actualizarAFullServido() throws RemoteException;
	
	void actualizarAPokerServido() throws RemoteException;
	
	void actualizarASeis() throws RemoteException;
	
	void actualizarACinco() throws RemoteException;
	
	void actualizarACuatro() throws RemoteException;
	
	void actualizarATres() throws RemoteException;
	
	void actualizarADos() throws RemoteException;
	
	void actualizarAUno() throws RemoteException;

	void cambiarATachar()throws RemoteException;

	int puntosGanardor()throws RemoteException;

	boolean seEscribio()throws RemoteException;
	
	void yaSeEscribio()throws RemoteException;

}