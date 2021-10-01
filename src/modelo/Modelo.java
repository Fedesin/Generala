package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import javax.swing.JOptionPane;

import ar.edu.unlu.rmimvc.observer.ObservableRemoto;
import controlador.Controlador;
import vista.VistaGrafica;

public class Modelo extends ObservableRemoto implements Imodelo{

	private Cubilete cubilete;
	private ArrayList<Jugador> jugadores;
	private int turno=1;
	private int ronda=1;
	File archivo;
    FileWriter escribir;
    PrintWriter linea;
	private boolean escribio=false;
	
	public Modelo(){
		jugadores = new ArrayList<>();
		cubilete = new Cubilete();
		
	}

	
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#getTurno()
	 */
	@Override
	public int getTurno() throws RemoteException{
		return turno;
	}



	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#setTurno(int)
	 */
	@Override
	public void setTurno(int turno) throws RemoteException{
		this.turno = turno;
	}



	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#getRonda()
	 */
	@Override
	public int getRonda() throws RemoteException{
		return ronda;
	}



	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#setRonda(int)
	 */
	@Override
	public void setRonda(int ronda) throws RemoteException{
		this.ronda = ronda;
	}



	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#setCubilete(modelo.Cubilete)
	 */
	@Override
	public void setCubilete(Cubilete c) throws RemoteException {
		this.cubilete = c;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#getJugadores()
	 */
	@Override
	public ArrayList<Jugador> getJugadores() throws RemoteException {
		return jugadores;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#AgregarJugador(java.lang.String)
	 */
	@Override
	public void AgregarJugador(String nombre) throws RemoteException {
		Jugador j = new Jugador(nombre);
		jugadores.add(j);
		notificar(1);
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#iniciar()
	 */
	@Override
	public void iniciar() throws RemoteException {
		//Cubilete cubilete = new Cubilete();
		setCubilete(cubilete);
		notificar(4);
	}
	
	
	

	private void notificar(int i) throws RemoteException {// usa el observer y el observable
		notificarObservadores(i);
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#getJugadoresFormateados()
	 */
	@Override
	public String getJugadoresFormateados() throws RemoteException{
		String todosLosJugadores = "";
		for (Jugador jugador : jugadores) {
			todosLosJugadores += "\n Jugador: " + jugador.getNombre()+" ";
			//todosLosJugadores += "Puntos: " + jugador.getPuntos()+" ";
			//todosLosJugadores += "Tabla de puntos: " + Arrays.toString((jugador.getTablaDePuntos()))+"";
		}
		return todosLosJugadores;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#mostrarJugador(int)
	 */
	@Override
	public String mostrarJugador(int turno) throws RemoteException{
		String nombre = "";
		for (Jugador jugador : jugadores) {
			if (jugador.getTurno() == turno) {
				nombre = jugador.getNombre();
			}
		}
		return nombre;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#mostrarPuntos(int)
	 */
	@Override
	public int mostrarPuntos(int turno) throws RemoteException{
		int puntos = 0;
			puntos=jugadores.get(turno-1).getPuntos();
		return puntos;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#mostrarTabla(int, int)
	 */
	@Override
	public int mostrarTabla(int turno, int lugarPuntaje) throws RemoteException{
		int puntos = 0;
		for (Jugador jugador : jugadores) {
			if (jugador.getTurno() == turno) {
				puntos = jugador.tablaDePuntos[lugarPuntaje];
			}
		}
		return puntos;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#realizarTirada()
	 */
	@Override
	public void realizarTirada() throws RemoteException{
		cubilete.tirarDados();
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultarGenerala()
	 */
	@Override
	public boolean consultarGenerala() throws RemoteException{
		boolean respuesta = false;
		int primero = cubilete.getDado(0);
		int segundo = cubilete.getDado(1);
		int tercero = cubilete.getDado(2);
		int cuarto = cubilete.getDado(3);
		int quinto = cubilete.getDado(4);
		if ((primero == segundo) && (segundo == tercero) && (tercero == cuarto) && (cuarto == quinto)) {
			respuesta = true;// hay generala
		} else {
			respuesta = false;// no hay generala
		}
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultarDado(int)
	 */
	@Override
	public int consultarDado(int dadoNumero) throws RemoteException{
		int valor = 0;
		valor = cubilete.getDado(dadoNumero);
		return valor;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultarEscalera()
	 */
	@Override
	public boolean consultarEscalera() throws RemoteException{
		boolean respuesta=false;
		int primero =cubilete.getDado(0);
		int segundo =cubilete.getDado(1);	
		int tercero =cubilete.getDado(2);
		int cuarto =cubilete.getDado(3);
		int quinto =cubilete.getDado(4);
		if ( (primero==2)
				||
				(segundo==2)
				||
				(tercero==2)
				||
				(cuarto==2)
				||
				(quinto==2)
				) { //si un dado cualquiera es 2 pregunto si existe un dado cuyo valor sea 3
			if (
					(primero==3)
					||
					(segundo==3)
					||
					(tercero==3)
					||
					(cuarto==3)
					||
					(quinto==3)
					) {
				if (
						(primero==4)
						||
						(segundo==4)
						||
						(tercero==4)
						||
						(cuarto==4)
						||
						(quinto==4)
						)
				{
					if (
							(primero==5)
							||
							(segundo==5)
							||
							(tercero==5)
							||
							(cuarto==5)
							||
							(quinto==5)
							) {
						//si encuentra que hay 2, 3, 4 y 5 tengo que buscar si hay 1 o 6
						if (
								(primero==6)
								||
								(segundo==6)
								||
								(tercero==6)
								||
								(cuarto==6)
								||
								(quinto==6)
								) {//si hay 2 3 4 5 y 6, hay escalera
							respuesta=true;
						}
						else {//si no hay 6 busco si hay 1
							if(
									(primero==1)
									||
									(segundo==1)
									||
									(tercero==1)
									||
									(cuarto==1)
									||
									(quinto==1)
									) {//si hay 1 2 3 4 5 hay escalera
								respuesta=true;
							}//si no hay ni 6 ni 1 entonces no hay escalera
							else{
								respuesta=false;
							}
						}
					}else {//si no hay 5, no hay escalera
						respuesta=false;
					}
				}
				else{//si no hay 4, no hay escalera
					respuesta=false;
				}

			}else {
				respuesta=false;//si no hay 3, no hay escalera
			}
		}
		else {
			respuesta = false;// si no hay 2, no hay escalera	

		}
		return respuesta;
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#controlarPuntos(int, int)
	 */
	@Override
	public int controlarPuntos(int numJugador,int lugarEnLaTabla) throws RemoteException{
		int puntosActuales;
			puntosActuales=jugadores.get(numJugador-1).controlarPocisionTabla(lugarEnLaTabla);
		return puntosActuales;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#sumarPuntos(int, int, int)
	 */
	@Override
	public void sumarPuntos(int numJugador, int puntosASumar, int lugarEnLaTabla) {
		jugadores.get(numJugador-1).sumarPuntos(puntosASumar,lugarEnLaTabla);
		jugadores.get(numJugador-1).actualizarPuntos();
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#actualizarAJugando()
	 */
	@Override
	public void actualizarAJugando() throws RemoteException{
		notificar(4);
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#cantidadDeJugadores()
	 */
	@Override
	public int cantidadDeJugadores() throws RemoteException{
		int cantJugadores=0;
			cantJugadores=jugadores.size();
		return cantJugadores;
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultarFull()
	 */
	@Override
	public boolean consultarFull() throws RemoteException{
		boolean respuesta=false;
		int iguales=0;
		int valor1=0;
		int valor2=0;
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (cubilete.getDado(i)==cubilete.getDado(j)) {
					iguales++;
				}
			}
			if (iguales==2) {
				valor1=cubilete.getDado(i);
			}else {
				if (iguales==3) {
					valor2=cubilete.getDado(i);
				}
			}
			iguales=0;	
		}
		if (valor1==0
				||
				valor2==0) {
			respuesta=false;
		} else {
			if (valor1!=valor2) {
				respuesta=true;
			}
		}
		return respuesta;
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultarPoker()
	 */
	@Override
	public boolean consultarPoker() throws RemoteException{
		boolean respuesta=false;
		int iguales=0;
		//tengo que recorrer el cubilete y preguntar por 4 valores iguales y ya esta.
		for (int i=0; i<5; i++) {
			cubilete.getDado(i);
			for (int j=0; j<5; j++) {
				cubilete.getDado(j);
				if (cubilete.getDado(i)==cubilete.getDado(j)) {
					iguales++;
				}
			}
			if (iguales==4) {
				respuesta=true;
			}else
			{iguales=0;}
		}
		return respuesta;
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#pasarTurno(int)
	 */
	@Override
	public void pasarTurno(int turno) throws RemoteException{
		int cantJugadores = cantidadDeJugadores();
		if (turno==cantJugadores) {
			setTurno(1);
			setRonda(getRonda()+1);
		}else
		{
			setTurno(getTurno()+1);
		}
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#cambiarJugador()
	 */
	@Override
	public void cambiarJugador() throws RemoteException{
		//aca tengo que hacer el cambio de jugador y poner activo al siguiente jugador y inactivo al actual
		pasarTurno(getTurno());
		if (getRonda()==12) {
			notificar(17);
		}
		else {
		notificar(4);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#tirarDado(int)
	 */
	@Override
	public void tirarDado(int lugarDado) throws RemoteException{
		cubilete.tirarDado(lugarDado);
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#puntajeDisponible(int, int)
	 */
	@Override
	public boolean puntajeDisponible(int numJugador, int lugarTabla) {
		boolean respuesta=true;
			if (jugadores.get(numJugador-1).consultarDisponible(lugarTabla)==false) {
				respuesta=false;
			}
		return respuesta;
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultar6()
	 */
	@Override
	public boolean consultar6() throws RemoteException{
		boolean respuesta=false;
			for (int i=0;i<5;i++) {
				if (cubilete.getDado(i)==6) {
					respuesta=true;
				}
			}
		return respuesta;
	}
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultar5()
	 */
	@Override
	public boolean consultar5() throws RemoteException{
		boolean respuesta=false;
			for (int i=0;i<5;i++) {
				if (cubilete.getDado(i)==5) {
					respuesta=true;
				}
			}
		return respuesta;
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultar4()
	 */
	@Override
	public boolean consultar4() throws RemoteException{
		boolean respuesta=false;
			for (int i=0;i<5;i++) {
				if (cubilete.getDado(i)==4) {
					respuesta=true;
				}
			}
		return respuesta;
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultar3()
	 */
	@Override
	public boolean consultar3() throws RemoteException{
		boolean respuesta=false;
			for (int i=0;i<5;i++) {
				if (cubilete.getDado(i)==3) {
					respuesta=true;
				}
			}
		return respuesta;
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultar2()
	 */
	@Override
	public boolean consultar2() throws RemoteException{
		boolean respuesta=false;
			for (int i=0;i<5;i++) {
				if (cubilete.getDado(i)==2) {
					respuesta=true;
				}
			}
		return respuesta;
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultar1()
	 */
	@Override
	public boolean consultar1() throws RemoteException{
		boolean respuesta=false;
			for (int i=0;i<5;i++) {
				if (cubilete.getDado(i)==1) {
					respuesta=true;
				}
			}
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#calcularPuntos(int)
	 */
	@Override
	public int calcularPuntos(int numero) throws RemoteException{
		int respuesta=0;
			for (int i=0; i<5; i++) {
				if(cubilete.getDado(i)==numero) {
					respuesta+=numero;
				}
			}
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#tacharTabla(int, int)
	 */
	@Override
	public void tacharTabla(int turno,int lugarATachar) throws RemoteException{
		jugadores.get(turno-1).modificarTabla(-1, lugarATachar);
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#actualizarAFinalizar()
	 */
	@Override
	public void actualizarAFinalizar() throws RemoteException{
		notificar(17);
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultarGanador()
	 */
	@Override
	public String consultarGanador() throws RemoteException{
		String respuesta= "empate";
		int mayor=0;
			for (int i=0; i< jugadores.size();i++) {
				if (jugadores.get(i).getPuntos()>mayor) {
					respuesta=jugadores.get(i).getNombre();
					mayor=jugadores.get(i).getPuntos();
				}
			}
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#consultarDobleGenerala(int)
	 */
	@Override
	public boolean consultarDobleGenerala(int numJugador) throws RemoteException{
		boolean respuesta=false;
			if ((jugadores.get(numJugador-1).controlarPocisionTabla(9)!=-1)//si el jugador no tacho la generala
					&&
					(jugadores.get(numJugador-1).controlarPocisionTabla(9)!=0)//y el jugador hizo la generala
					) {
				if ((jugadores.get(numJugador-1).consultarDisponible(10)==true)) {//pregunto si esta disponible la doble
					if (consultarGenerala()==true) {
						respuesta=true;
					}
					
				}
			}
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#actualizarAGanadorServido()
	 */
	@Override
	public void actualizarAGanadorServido() throws RemoteException{
		notificar(18);
	}
	
	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#actualizarATercerTirada()
	 */
	@Override
	public void actualizarATercerTirada() throws RemoteException{
		notificar(8);
	}



	/* (non-Javadoc)
	 * @see modelo.IObservableRemoto#actualizarAConsultarPuntos()
	 */
	@Override
	public void actualizarAConsultarPuntos() throws RemoteException{
		notificar(9);	
	}



	@Override
	public void actualizarAMenuInicial() throws RemoteException {
		notificar(2);
	}



	@Override
	public void jugadorListo(int jugador) throws RemoteException {
		jugadores.get(jugador-1).listo=true;
		boolean respuesta=true;
		for (Jugador jug: jugadores) {
			if (jug.listo==false) {
				respuesta=false;
			}
		}
		
		if (respuesta==true) {
		notificar(3);
		iniciar();
		}
	}



	@Override
	public void actualizarAEscaleraServida() throws RemoteException {
		notificar(5);
	}



	@Override
	public void actualizarAFullServido() throws RemoteException {
		notificar(6);
		
	}



	@Override
	public void actualizarAPokerServido() throws RemoteException {
		notificar(7);
	}



	@Override
	public void actualizarASeis() throws RemoteException {
		notificar(10);
	}



	@Override
	public void actualizarACinco() throws RemoteException {
		notificar(11);
	}



	@Override
	public void actualizarACuatro() throws RemoteException {
		notificar(12);
	}



	@Override
	public void actualizarATres() throws RemoteException {
		notificar(13);
	}



	@Override
	public void actualizarADos() throws RemoteException {
		notificar(14);
	}



	@Override
	public void actualizarAUno() throws RemoteException {
		notificar(15);
	}



	@Override
	public void cambiarATachar() throws RemoteException {
		notificar(16);
	}



	@Override
	public int puntosGanardor() throws RemoteException {
		String nombreGanador;
		int puntos;
		int turnoGanador = 0;
		nombreGanador=consultarGanador();
		for (Jugador jug: jugadores) {
			if (jug.nombre==nombreGanador) {
				turnoGanador=jug.turno;
			}
		}
		return puntos=mostrarPuntos(turnoGanador);
	}



	@Override
	public boolean seEscribio() throws RemoteException {
		
		return escribio;
	}
	
	@Override
	public void yaSeEscribio() throws RemoteException {
		escribio=true;
	}
	
}

