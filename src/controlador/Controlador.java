package controlador;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;

import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;
import modelo.Imodelo;
import vista.VistaConsola;
import vista.VistaGrafica;


public class Controlador implements IControladorRemoto {
	
	private IVista view;
	private Imodelo model;
	private int Jugador;
	private int jugada=1;
	private int tiradas=0;
	public boolean preguntaEscaleraServida=false;
	public boolean preguntaFullServido=false;
	public boolean preguntaPokerServido=false;
	public boolean pregunta6=false;
	public boolean pregunta5=false;
	public boolean pregunta4=false;
	public boolean pregunta3=false;
	public boolean pregunta2=false;
	public boolean pregunta1=false;
	public int lugarATachar=-1;
	
	
	public Controlador(IVista view, Imodelo model) throws RemoteException{
		this.view=view;
		this.model=model;
		this.Jugador=cantJugadores();
		view.setControlador(this);
		//model.addObserver(this);
	}
	
	public Controlador(Imodelo model) throws RemoteException{
		this.model=model;
		this.Jugador=cantJugadores();
		//model.addObserver(this);
	}
	
	public void setModelo(Imodelo modelo) throws RemoteException {
		this.setModeloRemoto(modelo);
	}
	
	public Controlador() {
		
	}
	
	public void setVista(IVista view) throws RemoteException {
        this.view = view;
        //this.Jugador=cantJugadores();
       // view.setControlador(this);
    }
	
	public void setJugador() throws RemoteException {
		this.Jugador=cantJugadores();
		this.view.setJugador();
	}
	
	public int cantJugadores() throws RemoteException {
		int respuesta=0;
		respuesta=model.cantidadDeJugadores();
		return respuesta;
		
	}
	
	public void Comenzar() throws RemoteException {
		model.iniciar();
	}
	
	
	public String getNombre(int jugador) throws RemoteException {
		String nombre="";
		nombre=model.mostrarJugador(jugador);
		return nombre;
	}
	
	@Override
	public void actualizar(IObservableRemoto arg0, Object arg1) throws RemoteException {//esto se usa para recibir data del modelo
		//aca tengo que llamar a la actualización de la vista
		int a= (int)arg1;
		switch (a) { 
		case 1://JugadorAgregado
			view.agregadoCorrecto(mostrarJugador(cantJugadores()));
			view.mostrarJugadores(model.getJugadoresFormateados());
			break;
		case 2://Menu inicial para cada jugador
			view.menujugando();
			break;
			
		
		case 3://Notifica cuando todos los jugadores estan listos y inicia el juego
			view.comenzarJuego();//avisa que estan todos los jugadores listos
			break;
			
		case 4://Primer tirada y tirada realizada
			if (jugada!=1) {
				break;
			}
			if (model.getTurno()!=Jugador) {
				break;
			}
			//jugada=1;
			view.menujugando();
			realizarTirada();
			
			view.tiradaRealizada();
			view.mostrarTirada();
			if (consultarGenerala()==true) {//ganas de una
				cambiarAGanadorServido();
				break;
					}else{//o sumas puntos
						//si es alguno de estos 
						//le pregunto al usuario si se queda con eso
						//o sigue haciendo tiradas
						if (consultarEscalera()==true) {
							if(model.puntajeDisponible(Jugador, 6)) {
								view.preguntarEscaleraServida();
								break;
							}
						}
						if (consultarFull()==true) {
							if(model.puntajeDisponible(Jugador, 7)) {
								view.preguntarFullServido();
								break;
							}
						}
							if (consultarPoker()==true) {
								if(model.puntajeDisponible(Jugador, 8)) {
									view.preguntarPokerServido();
									break;	
								}
							}
							//aca programo la segunda tirada
							view.menuVolverATirar();
							break;	
					}
		case 5: //notifica la escalera servida
			if (consultarEscalera()==true) {
				if(model.puntajeDisponible(Jugador, 6)) {
					if (jugada!=1) {
						break;
					}
					if (model.getTurno()!=Jugador) {
						break;
					}
						sumarPuntos(Jugador,25,6);
						view.actualizarTablaDePuntos();
						view.pasarAlSiguienteJugador();
						view.cambiarJugador();
						jugada=1;
						model.cambiarJugador();
						break;
				} else {break;}
			}else {break;}		
			
			
			
		case 6: //notifica el full servido
			if (consultarFull()==true) {
				if(model.puntajeDisponible(Jugador, 7)) {
					if (jugada!=1) {
						break;
					}
					if (model.getTurno()!=Jugador) {
						break;
					}
						sumarPuntos(Jugador,35,7);
						view.actualizarTablaDePuntos();
						view.pasarAlSiguienteJugador();
						view.cambiarJugador();
						jugada=1;
						model.cambiarJugador();
						break;
				} else {break;}
			}else {break;}		
			
			
				
					
					
					
	case 7: //notifica el pokerservido
		if (consultarPoker()==true) {
			if(model.puntajeDisponible(Jugador, 8)) {
				if (jugada!=1) {
					break;
				}
				if (model.getTurno()!=Jugador) {
					break;
				}
					sumarPuntos(Jugador,45,8);
					view.actualizarTablaDePuntos();
					view.pasarAlSiguienteJugador();
					view.cambiarJugador();
					jugada=1;
					model.cambiarJugador();
					break;	
			} else {break;}
		}else {break;}		
		
		
					
				
			
	case 8://TercerTirada //case 8
						//aca programo la tercer tirada
		if (model.getTurno()!=Jugador) {
			break;
		}
		if (jugada!=1) {// cuidado con la jugada
			break;
		}
		this.pregunta6=false;
		this.pregunta5=false;
		this.pregunta4=false;
		this.pregunta3=false;
		this.pregunta2=false;
		this.pregunta1=false;
		view.menuUltimaTirada();
		break;
	case 9://ConsultarPuntos //case 9
		if (tiradas!=3) {
			break;
		}
		if (model.getTurno()!=Jugador) {
			break;
		}
		if (jugada!=1) {
			break;
		}else {jugada++;}
		
						if (consultarDobleGenerala()==true) {
								if(model.puntajeDisponible(Jugador, 10)) {
									view.menuDobleGenerala();
									sumarPuntos(Jugador,100,10);
									view.actualizarTablaDePuntos();
									view.pasarAlSiguienteJugador();
									view.cambiarJugador();
									jugada=1;
									model.cambiarJugador();	
									break;
							}
						}

						if (consultarGenerala()==true) {
							if(model.puntajeDisponible(Jugador, 9)) {
								view.anotarGenerala();
								sumarPuntos(Jugador,50,9);
								view.actualizarTablaDePuntos();
								view.pasarAlSiguienteJugador();
								view.cambiarJugador();
								jugada=1;
								model.cambiarJugador();	
								break;
							}
						}

					
						if (consultarPoker()==true) {
							if(model.puntajeDisponible(Jugador, 8)) {
								view.anotarPoker();
								sumarPuntos(Jugador,40,8);
								view.actualizarTablaDePuntos();
								view.pasarAlSiguienteJugador();
								view.cambiarJugador();
								jugada=1;
								model.cambiarJugador();							
								break;
							}
						}
						
						if (consultarFull()==true) {
							if(model.puntajeDisponible(Jugador, 7)) {
								view.anotarFull();
								sumarPuntos(Jugador,30,7);
								view.actualizarTablaDePuntos();
								view.pasarAlSiguienteJugador();
								view.cambiarJugador();
								jugada=1;
								model.cambiarJugador();								
								break;
							}
						}
						
						if (consultarEscalera()==true) {
							if(model.puntajeDisponible(Jugador, 6)) {
								view.anotarEscalera();
								sumarPuntos(Jugador,20,6);
								view.actualizarTablaDePuntos();
								view.pasarAlSiguienteJugador();
								view.cambiarJugador();
								jugada=1;
								model.cambiarJugador();
								break;
							}
						}
						
						if (consultar6()==true) {
							if (model.puntajeDisponible(Jugador, 5)) {
								if(this.pregunta6==false) {
									view.preguntar6();
									this.pregunta6=true;
									//break;	
								}
							}
						}

						if (consultar5()==true) {
							if (model.puntajeDisponible(Jugador, 4)) {
								if (this.pregunta5==false) {
								view.preguntar5();
								this.pregunta5=true;
								//break;					
								}
							}
						}

						if (consultar4()==true) {
							if (model.puntajeDisponible(Jugador, 3)) {
								if (this.pregunta4==false) {
								view.preguntar4();
								this.pregunta4=true;
								//break;		
								}
							}
						}

						if (consultar3()==true) {
							if (model.puntajeDisponible(Jugador, 2)) {
								if (this.pregunta3==false) {
									view.preguntar3();
									this.pregunta3=true;
									//break;		
									}	
							}
						}

						if (consultar2()==true) {
							if (model.puntajeDisponible(Jugador, 1)) {
								if (this.pregunta2==false) {
									view.preguntar2();
									this.pregunta2=true;
									//break;		
									}
							}
						}
						if (consultar1()==true) {
							if (model.puntajeDisponible(Jugador, 0)) {
								if (this.pregunta1==false) {
									view.preguntar1();
									this.pregunta1=true;
									//break;		
									}
							}
						}
						
						
						if (this.pregunta1==true) {
							break;
						}
						if (this.pregunta2==true) {
							break;
						}
						if (this.pregunta3==true) {
							break;
						}
						if (this.pregunta4==true) {
							break;
						}
						if (this.pregunta5==true) {
							break;
						}
						if (this.pregunta6==true) {
							break;
						}
						
						
						view.tacharPuntos();
						break;
						
		
		case 10: //notifica el la suma de puntos de 6
			if (jugada!=2) {
				break;
			}
			if (model.getTurno()!=Jugador) {
				break;
			}
				sumarPuntos(Jugador,model.calcularPuntos(6),5);
				view.actualizarTablaDePuntos();
				view.pasarAlSiguienteJugador();
				view.cambiarJugador();
				jugada=1;
				model.cambiarJugador();
				break;
				
		case 11: //notifica la suma de puntos de 5
			if (jugada!=2) {
				break;
			}
			if (model.getTurno()!=Jugador) {
				break;
			}
			sumarPuntos(Jugador,model.calcularPuntos(5),4);
			view.actualizarTablaDePuntos();
			view.pasarAlSiguienteJugador();
			view.cambiarJugador();
			jugada=1;
			model.cambiarJugador();
			break;
			
		case 12: //notificar la suma de puntos de cuatro
			if (jugada!=2) {
				break;
			}
			if (model.getTurno()!=Jugador) {
				break;
			}
				sumarPuntos(Jugador,model.calcularPuntos(4),3);
				view.actualizarTablaDePuntos();
				view.pasarAlSiguienteJugador();
				view.cambiarJugador();
				jugada=1;
				model.cambiarJugador();
				break;
				
		case 13: //notifica la suma de puntos de tres
			if (jugada!=2) {
				break;
			}
			if (model.getTurno()!=Jugador) {
				break;
			}
				sumarPuntos(Jugador,model.calcularPuntos(3),2);
				view.actualizarTablaDePuntos();
				view.pasarAlSiguienteJugador();
				view.cambiarJugador();
				jugada=1;
				model.cambiarJugador();
				break;
				
				
		case 14: //notifica la suma de puntos de 2
			if (jugada!=2) {
				break;
			}
			if (model.getTurno()!=Jugador) {
				break;
			}
				sumarPuntos(Jugador,model.calcularPuntos(2),1);
				view.actualizarTablaDePuntos();
				view.pasarAlSiguienteJugador();
				view.cambiarJugador();
				jugada=1;
				model.cambiarJugador();
				break;
				
		case 15: //notifica la suma de puntos con unos
			if (jugada!=2) {
				break;
			}
			if (model.getTurno()!=Jugador) {
				break;
			}
				sumarPuntos(Jugador,model.calcularPuntos(1),0);
				view.actualizarTablaDePuntos();
				view.pasarAlSiguienteJugador();
				view.cambiarJugador();
				jugada=1;
				model.cambiarJugador();
				break;
						
	
		case 16:// case 16 notificar tachar lugar en la tabla
			//
			if (jugada!=2) {
				break;
			}
			if (model.getTurno()!=this.Jugador) {
				break;
			}
			//si para el final 
			//no se anoto nada, pedirle que se tache un puntaje que no haya formado
			if (this.lugarATachar==-1) {
				break;
			}
			if (puntajeDisponible(this.Jugador, this.lugarATachar)==false) {
				break;
			}
			tacharTabla(lugarATachar);
			view.actualizarTablaDePuntos();
			view.pasarAlSiguienteJugador();
			view.cambiarJugador();
			jugada=1;
			tiradas=0;
			model.cambiarJugador();
			break;
		case 17://finalizar por turnos case 17
			view.mostrarGanador();
			break;
		case 18://finalizar por generala servida case 18
			view.mostrarGanadorServido();
			break;
		default:
			break;
			
		}


	}
	
	
	public int puntosGanador() throws RemoteException {
		return model.puntosGanardor();
	}
	
	
	public int getTiradas() {
		return this.tiradas;
	}
	
	public void setTirada(int numero) {
		this.tiradas=numero;
	}
	
	public void pasarTurno() throws RemoteException {
		model.cambiarJugador();
	}
	
	public boolean puntajeDisponible(int numJugador,int lugarTabla) throws RemoteException {
		boolean respuesta;
		respuesta=model.puntajeDisponible(numJugador, lugarTabla);
		return respuesta;
	}
	
	private void cambiarAGanadorServido() throws RemoteException{
		model.actualizarAGanadorServido();
		
	}

	public void actualizarAConsultarPuntos() throws RemoteException{
		model.actualizarAConsultarPuntos();
	}	
	
	private boolean consultarDobleGenerala() throws RemoteException{
		boolean respuesta=false;
			respuesta=model.consultarDobleGenerala(model.getTurno());
		return respuesta;
	}

	public String consultarGanador() throws RemoteException{
		return model.consultarGanador();
	}
	
	private void actualizarAFinalizar() throws RemoteException{
		model.actualizarAFinalizar();
	}

	private void tacharTabla(int lugarATachar) throws RemoteException{
		model.tacharTabla(model.getTurno(),lugarATachar);
	}

	private boolean consultar6() throws RemoteException{
		boolean respuesta=false;
			respuesta=model.consultar6();
		return respuesta;
	}
	
	private boolean consultar5() throws RemoteException{
		boolean respuesta=false;
			respuesta=model.consultar5();
		return respuesta;
	}
	
	private boolean consultar4() throws RemoteException{
		boolean respuesta=false;
			respuesta=model.consultar4();
		return respuesta;
	}
	
	private boolean consultar3() throws RemoteException{
		boolean respuesta=false;
			respuesta=model.consultar3();
		return respuesta;
	}
	
	private boolean consultar2() throws RemoteException{
		boolean respuesta=false;
			respuesta=model.consultar2();
		return respuesta;
	}
	private boolean consultar1() throws RemoteException{
		boolean respuesta=false;
			respuesta=model.consultar1();
		return respuesta;
	}

	public void cambiarJugador() throws RemoteException{
		model.cambiarJugador();
	}
	
	private boolean consultarPoker() throws RemoteException{
		boolean respuesta=false;
		respuesta=model.consultarPoker();
		return respuesta;
	}

	private boolean consultarFull() throws RemoteException{
		boolean respuesta=false;
			respuesta=model.consultarFull();
		return respuesta;
	}

	
	
	public void tirarDado(int lugarDado) throws RemoteException{
		model.tirarDado(lugarDado);
	}
	
	public void actualizarAJugando() throws RemoteException{
		model.actualizarAJugando();
	}
	
	public boolean consultarEscalera() throws RemoteException{
		 boolean respuesta=false;
		 	respuesta= model.consultarEscalera();
		 return respuesta;
	}

	public void actualizarATercerTirada() throws RemoteException{
		model.actualizarATercerTirada();
	}
	
	public boolean consultarGenerala() throws RemoteException{
		boolean respuesta=false;
			respuesta= model.consultarGenerala();
		return respuesta;
	}
	
	public void agregarJugador(String nombre) throws RemoteException{
		model.AgregarJugador(nombre);
		setJugador();
		model.actualizarAMenuInicial();
	}
	
	public String getJugadoresFormateados() throws RemoteException{
		return model.getJugadoresFormateados();
	}
	
	
	public String mostrarJugador(int turno) throws RemoteException{
		String nombre="";
			nombre=model.mostrarJugador(turno);
		return nombre;
	}
	
	public int mostrarPuntos(int turno) throws RemoteException{
		int puntos=0;
			puntos=model.mostrarPuntos(turno);
		return puntos;
	}
	
	public int mostrarTabla(int turno, int lugarPuntaje) throws RemoteException{
		int puntos=0;
		 puntos= model.mostrarTabla(turno,lugarPuntaje);
		return puntos;
	}
	
	public void realizarTirada() throws RemoteException{
		this.tiradas=1;
		model.realizarTirada();
	}
	
	public int consultarDado(int dadoNumero) throws RemoteException{
		int valor=0;
			valor=model.consultarDado(dadoNumero);
		return valor;
	}
	
	public int controlarPuntos(int numJugador,int lugarEnLaTabla) throws RemoteException{
		int puntosActuales=0;
			puntosActuales=model.controlarPuntos(numJugador,lugarEnLaTabla);
		return puntosActuales;
	}
	
	public void sumarPuntos(int numJugador, int puntosASumar, int lugarEnLaTabla) throws RemoteException {
		model.sumarPuntos(numJugador,puntosASumar,lugarEnLaTabla);
	}
	
	public int getTurno() throws RemoteException{
		return model.getTurno();
	}


	public <T extends IObservableRemoto> void setModeloRemoto(T modeloRemoto) {
		this.model = (Imodelo) modeloRemoto; // es necesario castear el modelo remoto 
	}

	public void jugadorListo() throws RemoteException {
		model.jugadorListo(this.Jugador);
		
	}

	public void respuestaEscaleraServida(boolean b) throws RemoteException {
		if (model.getTurno()==Jugador) {
			if (b==true) {
				model.actualizarAEscaleraServida();
				
			}
		}
		
	}

	public void respuestaFullServido(boolean b) throws RemoteException {
		if (model.getTurno()==Jugador) {
			if (b==true) {
				model.actualizarAFullServido();
				
			}
		}
	}

	public void respuestaPokerServido(boolean b) throws RemoteException {
		if (model.getTurno()==Jugador) {
			if (b==true) {
				model.actualizarAPokerServido();
				
			}
		}
	}

	public void respuesta6(boolean b) throws RemoteException {
		if (b==true) {
			model.actualizarASeis();
		}
	}
	
	public void respuesta5(boolean b) throws RemoteException {
		if (b==true) {
			model.actualizarACinco();
		}
	}
	
	public void respuesta4(boolean b) throws RemoteException {
		if (b==true) {
			model.actualizarACuatro();
		}
	}
	
	public void respuesta3(boolean b) throws RemoteException {
		if (b==true) {
			model.actualizarATres();
		}
	}
	
	public void respuesta2(boolean b) throws RemoteException {
		if (b==true) {
			model.actualizarADos();
		}
	}
	
	public void respuesta1(boolean b) throws RemoteException {
		if (b==true) {
			model.actualizarAUno();
		}
	}

	public void actualizarATachar() throws RemoteException {
		model.cambiarATachar();
	}

	public boolean seEscribio() throws RemoteException {//pregunta si ya escribio
		return model.seEscribio();
	}
	
	public void yaSeEscribio() throws RemoteException {//setea la lectura
		model.yaSeEscribio();
	}
	
}
