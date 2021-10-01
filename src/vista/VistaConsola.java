package vista;

import controlador.Controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import controlador.IVista;

public class VistaConsola implements IVista {
	private Controlador controlador;
	private int Jugador;
	private int listo=1;
	File archivo;
    FileWriter escribir;
    PrintWriter linea;
	protected static Scanner entrada = new Scanner(System.in);
	
	
	public VistaConsola(Controlador controlador) {
		this.controlador=controlador;
		setControlador(controlador);
		archivo = new File("Ganadores.txt");
	}
	
	
	/*@Override
	public void menuinicio() {
		System.out.println("===============================");
		System.out.println("==========Bienvenido===========");
		System.out.println("===============================");
		System.out.println("======1) Agregar jugador ======");
		System.out.println("======2) Mostrar jugadores ====");
		System.out.println("======3) Iniciar Juego ========");
		System.out.println("===============================");
		int i= entrada.nextInt();
		switch (i)
		{ case 1:
			agregarJugador();
			break;
		
		case 2:
			controlador.mostrarJugadores();
			break;
		case 3:
			controlador.actualizarAJugando();
			break;
		default:
			break;
		}
	}*/

	@Override
	public void setControlador(Controlador controlador) {
		//this.controlador = controlador;
		// this.controlador.setVista(this);
	}
	
	@Override
	public void setJugador() throws RemoteException {
		this.Jugador = controlador.cantJugadores();
	}
	/*
	@Override
	public void agregarJugador() {
		
		System.out.println("===========================");
		System.out.println("Ingrese el nombre del jugador: ");
		String nombre=entrada.next();
		controlador.agregarJugador(nombre);
		
	}*/
	
	
	@Override
	public void menujugando() throws RemoteException {
		System.out.println("==========Jugando==========");
		System.out.println("==========Información del jugador ==========");
		System.out.println("Jugador: "+controlador.mostrarJugador(Jugador));
		System.out.println("==Turno de: "+controlador.mostrarJugador(controlador.getTurno())+".");
		System.out.println("==Sus puntos son: "+controlador.mostrarPuntos(Jugador) +".");
		System.out.println("=1: "+controlador.mostrarTabla(Jugador,0)+".");
		System.out.println("=2: "+controlador.mostrarTabla(Jugador,1)+".");
		System.out.println("=3: "+controlador.mostrarTabla(Jugador,2)+".");
		System.out.println("=4: "+controlador.mostrarTabla(Jugador,3)+".");
		System.out.println("=5: "+controlador.mostrarTabla(Jugador,4)+".");
		System.out.println("=6: "+controlador.mostrarTabla(Jugador,5)+".");
		System.out.println("=Escalera: "+controlador.mostrarTabla(Jugador,6)+".");
		System.out.println("=Full: "+controlador.mostrarTabla(Jugador,7)+".");
		System.out.println("=Poker: "+controlador.mostrarTabla(Jugador,8)+".");
		System.out.println("=Generala: "+controlador.mostrarTabla(Jugador,9)+".");
		System.out.println("=Generala Doble: "+controlador.mostrarTabla(Jugador,10)+".");
		System.out.println("==========Información del jugador ==========");
		if (listo==1) {
			listo++;
			System.out.println("Ingrese 1 si esta listo");
			if (entrada.nextInt()==1) {
				try {
					controlador.jugadorListo();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Ingrese 1 cuando este listo...");
				menujugando();
			}
		}
		
		
		//System.out.println("Se va a realizar la primer tirada: ");
	}
	
	@Override
	public void agregadoCorrecto(String nombre) {
		System.out.println("El jugador se agrego correctamente al jugador "+ nombre);
		
		
		
	}

	@Override
	public void mostrarJugadores(String jugadoresFormateados) {
		System.out.println("La lista de los jugadores es: "+jugadoresFormateados);
		//String nombre=entrada.next();
		
	}
	

	
	
	

	@Override
	public void tiradaRealizada() {
		System.out.println("Se realizo la tirada!");
		
	}

	@Override
	public void mostrarTirada() throws RemoteException {//ahora debo consultar los valores de los dados en el cubilete
		System.out.println("dado a: "+controlador.consultarDado(0));
		System.out.println("dado b: "+controlador.consultarDado(1));
		System.out.println("dado c: "+controlador.consultarDado(2));
		System.out.println("dado d: "+controlador.consultarDado(3));
		System.out.println("dado e: "+controlador.consultarDado(4));
	}

	@Override
	public void ganaste() throws RemoteException {
		System.out.println("==============================");
		System.out.println("Felicidades "+controlador.consultarGanador()+" GANASTE!!!!");
		System.out.println("==============================");
		
	}

	@Override
	public void preguntarEscaleraServida() {
		System.out.println("Usted formo Escalera Servida!!");
			System.out.println("¿Desea usted tomar los 25 puntos o desea seguir tirando?");
			System.out.println("Ingrese 1 para aceptar y ingrese cualquier otro numero para seguir con las tiradas");
			if (entrada.nextInt() == 1) {
				try {
					controlador.respuestaEscaleraServida(true);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//cuando sumas puntos significa que se termina tu turno.
			}else {
				try {
					menuVolverATirar();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		//return respuesta;
	}

	@Override
	public void actualizarTablaDePuntos() throws RemoteException {
		System.out.println("Se actualizo la tabla de puntos!");
		System.out.println("Jugador:"+controlador.getNombre(Jugador));
		System.out.println("==Sus puntos son: "+controlador.mostrarPuntos(Jugador) +".");
		System.out.println("=1: "+controlador.mostrarTabla(Jugador,0)+".");
		System.out.println("=2: "+controlador.mostrarTabla(Jugador,1)+".");
		System.out.println("=3: "+controlador.mostrarTabla(Jugador,2)+".");
		System.out.println("=4: "+controlador.mostrarTabla(Jugador,3)+".");
		System.out.println("=5: "+controlador.mostrarTabla(Jugador,4)+".");
		System.out.println("=6: "+controlador.mostrarTabla(Jugador,5)+".");
		System.out.println("=Escalera: "+controlador.mostrarTabla(Jugador,6)+".");
		System.out.println("=Full: "+controlador.mostrarTabla(Jugador,7)+".");
		System.out.println("=Poker: "+controlador.mostrarTabla(Jugador,8)+".");
		System.out.println("=Generala: "+controlador.mostrarTabla(Jugador,9)+".");
		System.out.println("=Generala Doble: "+controlador.mostrarTabla(Jugador,10)+".");
		
	}

	@Override
	public void preguntarFullServido() {
		boolean respuesta=false;
		System.out.println("Usted formo Full Servido!!");
		System.out.println("¿Desea usted tomar los 35 puntos o desea seguir tirando?");
		System.out.println("Ingrese 1 para aceptar y ingrese cualquier otro numero para seguir con las tiradas");
		if (entrada.nextInt() == 1) {
			try {
				controlador.respuestaFullServido(true);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				menuVolverATirar();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//return respuesta;
	}

	@Override
	public void preguntarPokerServido() {
		boolean respuesta=false;
		System.out.println("Usted formo Poker Servido!!");
		System.out.println("¿Desea usted tomar los 45 puntos o desea seguir tirando?");
		System.out.println("Ingrese 1 para aceptar y ingrese cualquier otro numero para seguir con las tiradas");
		if (entrada.nextInt() == 1) {
			try {
				controlador.respuestaPokerServido(true);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				menuVolverATirar();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//return respuesta;
	}

	@Override
	public void pasarAlSiguienteJugador() {
		System.out.println("Por favor pulse cualquier tecla y presione enter para ir al turno del siguiente jugador...");
		String s=entrada.next();
		
	}

	@Override
	public void menuVolverATirar() throws RemoteException {
		System.out.println("Por favor escoja los dados que desea volver a tirar:");
		System.out.println("(Para no escoger dado y continuar pulse cualquier otra tecla)");
		char c=entrada.next().charAt(0);
			if (c=='a') {
				controlador.tirarDado(0);
				System.out.println("Se volvio a tirar el dado.");
				menuVolverATirar();
			}else {
				if (c=='b') {
					controlador.tirarDado(1);
					System.out.println("Se volvio a tirar el dado.");
					menuVolverATirar();
				}else {
					if (c=='c') {
						controlador.tirarDado(2);
						System.out.println("Se volvio a tirar el dado.");
						menuVolverATirar();
					} else {
						if(c=='d') {
							controlador.tirarDado(3);
							System.out.println("Se volvio a tirar el dado.");
							menuVolverATirar();
						}else {
							if(c=='e') {
								controlador.tirarDado(4);
								System.out.println("Se volvio a tirar el dado.");
								menuVolverATirar();
							}else {
								mostrarTirada();
								controlador.setTirada(2);
								actualizarATercerTirada();
							}
						}
					}
				}
			}
	}


	private void actualizarATercerTirada() throws RemoteException {
		controlador.actualizarATercerTirada();
	}


	@Override
	public void menuDobleGenerala() throws RemoteException {
		System.out.println("Se le anotaron 100 puntos al jugador "+controlador.mostrarJugador(controlador.getTurno())+" por haber hecho la doble generala.");
	}

	@Override
	public void anotarGenerala() throws RemoteException {
		System.out.println("Se le anotaron 50 puntos al jugador "+controlador.mostrarJugador(controlador.getTurno())+" por haber hecho la generala.");
	}

	@Override
	public void anotarPoker() throws RemoteException {
		System.out.println("Se le anotaron 40 puntos al jugador "+controlador.mostrarJugador(controlador.getTurno())+" por haber hecho poker.");
	}

	@Override
	public void anotarFull() throws RemoteException {
		System.out.println("Se le anotaron 30 puntos al jugador "+controlador.mostrarJugador(controlador.getTurno())+" por haber hecho full.");
	}
	
	
	@Override
	public void anotarEscalera() throws RemoteException {
		System.out.println("Se le anotaron 20 puntos al jugador "+controlador.mostrarJugador(controlador.getTurno())+" por haber hecho escalera.");
	}

	@Override
	public void preguntar6() {
		boolean respuesta=false;
		System.out.println("Usted formo juego de 6!!");
		System.out.println("¿Desea usted tomar los puntos o desea seguir tirando?");
		System.out.println("Ingrese 1 para aceptar y ingrese cualquier otro numero para seguir con las tiradas");
		if (entrada.nextInt() == 1) {
			try {
				controlador.respuesta6(true);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//anota los puntos
		}
		//return respuesta;
	}

	@Override
	public void preguntar5() {
		boolean respuesta=false;
		System.out.println("Usted formo juego de 5!!");
		System.out.println("¿Desea usted tomar los puntos o desea seguir tirando?");
		System.out.println("Ingrese 1 para aceptar y ingrese cualquier otro numero para seguir con las tiradas");
		if (entrada.nextInt() == 1) {
			try {
				controlador.respuesta5(true);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//anota los puntos
		}
		//return respuesta;
	}

	@Override
	public void preguntar4() {
		boolean respuesta=false;
		System.out.println("Usted formo juego de 4!!");
		System.out.println("¿Desea usted tomar los puntos o desea seguir tirando?");
		System.out.println("Ingrese 1 para aceptar y ingrese cualquier otro numero para seguir con las tiradas");
		if (entrada.nextInt() == 1) {
			try {
				controlador.respuesta4(true);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//anota los puntos
		}
		//return respuesta;
	}

	@Override
	public void preguntar3() {
		boolean respuesta=false;
		System.out.println("Usted formo juego de 3!!");
		System.out.println("¿Desea usted tomar los puntos o desea seguir tirando?");
		System.out.println("Ingrese 1 para aceptar y ingrese cualquier otro numero para seguir con las tiradas");
		if (entrada.nextInt() == 1) {
			try {
				controlador.respuesta3(true);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//anota los puntos
		}
		//return respuesta;
	}

	@Override
	public void preguntar2() {
		boolean respuesta=false;
		System.out.println("Usted formo juego de 2!!");
		System.out.println("¿Desea usted tomar los puntos o desea seguir tirando?");
		System.out.println("Ingrese 1 para aceptar y ingrese cualquier otro numero para seguir con las tiradas");
		if (entrada.nextInt() == 1) {
			try {
				controlador.respuesta2(true);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//anota los puntos
		}
		//return respuesta;
	}

	@Override
	public void preguntar1() {
		boolean respuesta=false;
		System.out.println("Usted formo juego de 1!!");
		System.out.println("¿Desea usted tomar los puntos o desea seguir tirando?");
		System.out.println("Ingrese 1 para aceptar y ingrese cualquier otro numero para seguir con las tiradas");
		if (entrada.nextInt() == 1) {
			try {
				controlador.respuesta1(true);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//anota los puntos
		}
		//return respuesta;
	}

	@Override
	public void tacharPuntos() throws RemoteException {
		int lugarParaTachar=0;
			System.out.println("Como usted en este turno no pudo formar juego de nada o no quizo anotarse juego de algo que formo, debe tacharse un juego que no haya tachado antes y nunca haya anotado puntos, debe indicar el numero.");
			System.out.println("0 |=1: "+controlador.mostrarTabla(Jugador,0)+".");
			System.out.println("1 |=2: "+controlador.mostrarTabla(Jugador,1)+".");
			System.out.println("2 |=3: "+controlador.mostrarTabla(Jugador,2)+".");
			System.out.println("3 |=4: "+controlador.mostrarTabla(Jugador,3)+".");
			System.out.println("4 |=5: "+controlador.mostrarTabla(Jugador,4)+".");
			System.out.println("5 |=6: "+controlador.mostrarTabla(Jugador,5)+".");
			System.out.println("6 |=Escalera: "+controlador.mostrarTabla(Jugador,6)+".");
			System.out.println("7 |=Full: "+controlador.mostrarTabla(Jugador,7)+".");
			System.out.println("8 |=Poker: "+controlador.mostrarTabla(Jugador,8)+".");
			System.out.println("9 |=Generala: "+controlador.mostrarTabla(Jugador,9)+".");
			System.out.println("10|=Generala Doble: "+controlador.mostrarTabla(Jugador,10)+".");
			lugarParaTachar= entrada.nextInt();
			if (lugarParaTachar==9) {
				if (controlador.controlarPuntos(Jugador,10)!=-1) {
					System.out.println("No se puede tachar la generala antes de tachar la doble generala.");
					System.out.println("Capo, ingresa bien el numero...");
					tacharPuntos();
				}
			}
			if ((controlador.controlarPuntos(Jugador,lugarParaTachar)!=0)) {	
				System.out.println("Capo, ingresa bien el numero...");
				tacharPuntos();
			}
		 controlador.lugarATachar=lugarParaTachar;
		 controlador.actualizarATachar();
	}

	@Override
	public void mostrarGanador() throws RemoteException{
		String ganador=controlador.consultarGanador();
		System.out.println("Felicidades "+ganador+" ganaste el juego!!!");
		guardarGanador();
		mostrarGanadoresOrdenados();
	}
	
	private void mostrarGanadoresOrdenados() {
		List<SimpleEntry<Integer, String>> result;
        try (Stream<String> stream = Files.lines(Paths.get("Ganadores.txt"))) {
           result = stream.map(s -> s.split("\\s"))
                          .map(a -> new SimpleEntry<>(Integer.parseInt(a[0]), a[1]))
                          .sorted(Comparator.comparingInt(SimpleEntry::getKey))
                          .collect(Collectors.toCollection(ArrayList::new));
               Collections.reverse(result);
           for (int i=0;i<result.size();i++) {
               String s =result.get(i).toString();
               System.out.println(s+"\n");
        }

        } catch (IOException ee) { ee.printStackTrace(); }
	}


	public void guardarGanador() throws RemoteException {
		if(controlador.seEscribio()==false) {
			String nombreGanador=controlador.consultarGanador();
			int puntosGanador=controlador.puntosGanador();
			if (!archivo.exists()) {
	            try {
	                archivo.createNewFile();
	                escribir = new FileWriter(archivo, true);
	                linea = new PrintWriter(escribir);
	                linea.print(puntosGanador);
	                linea.print("	"+nombreGanador);
	               linea.println(" Gano por puntos.");
	                linea.close();
	                escribir.close();
	                controlador.yaSeEscribio();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	        } else {
	            try {
	                escribir = new FileWriter(archivo, true);
	                linea = new PrintWriter(escribir);
	                linea.print(puntosGanador);
	                linea.print("	"+nombreGanador);
	               linea.println(" Gano por puntos.");
	                linea.close();
	                escribir.close();
	                controlador.yaSeEscribio();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	        }
		}
		
		
	}

	@Override
	public void finalizar() {
		System.out.println("Por favor reinicie el juego...");
		
	}

	@Override
	public void mostrarGanadorServido() throws RemoteException{
		System.out.println("El jugador "+controlador.consultarGanador()+" gano la generala porque obtuvo GENERALA SERVIDA!!!!!");
		System.out.println("Felicidades usted es muy capo/a. :D");
		guardarGanadorServido();
		mostrarGanadoresOrdenados();
	}
	
	public void guardarGanadorServido() throws RemoteException {
		if(controlador.seEscribio()==false) {
			String nombreGanador=controlador.consultarGanador();
			int puntosGanador=controlador.puntosGanador();
			if (!archivo.exists()) {
	            try {
	                archivo.createNewFile();
	                escribir = new FileWriter(archivo, true);
	                linea = new PrintWriter(escribir);
	                linea.print(puntosGanador);
	               linea.print("	"+nombreGanador);
	               linea.println(" Hizo generala servida :O");
	                linea.close();
	                escribir.close();
	                controlador.yaSeEscribio();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	        } else {
	            try {
	                escribir = new FileWriter(archivo, true);
	                linea = new PrintWriter(escribir);
	                linea.print(puntosGanador);
	               linea.print("	"+nombreGanador);
	               linea.println(" Hizo generala servida :O");
	                linea.close();
	                escribir.close();
	                controlador.yaSeEscribio();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	        }
		}
		
		
	}

	@Override
	public void menuUltimaTirada() throws RemoteException {
		System.out.println("Por favor escoja los dados que desea volver a tirar:");
		System.out.println("(Para no escoger dado y continuar pulse cualquier otra tecla)");
		char c=entrada.next().charAt(0);
			if (c=='a') {
				controlador.tirarDado(0);
				System.out.println("Se volvio a tirar el dado.");
				menuUltimaTirada();
			}else {
				if (c=='b') {
					controlador.tirarDado(1);
					System.out.println("Se volvio a tirar el dado.");
					menuUltimaTirada();
				}else {
					if (c=='c') {
						controlador.tirarDado(2);
						System.out.println("Se volvio a tirar el dado.");
						menuUltimaTirada();
					} else {
						if(c=='d') {
							controlador.tirarDado(3);
							System.out.println("Se volvio a tirar el dado.");
							menuUltimaTirada();
						}else {
							if(c=='e') {
								controlador.tirarDado(4);
								System.out.println("Se volvio a tirar el dado.");
								menuUltimaTirada();
							}else {
								mostrarTirada();
								controlador.setTirada(3);
								actualizarAConsultarPuntos();
							}
						}
					}
				}
			}
			
			
		
	}

	private void actualizarAConsultarPuntos() throws RemoteException {
		controlador.actualizarAConsultarPuntos();
	}


	@Override
	public void elijaUnLugarValidoATachar() {
		System.out.println("Por favor elija un lugar valido a tachar...");
		
	}

	@Override
	public void cambiarJugador() {
		System.out.println("Se va a cambiar de jugador...");
	}

	@Override
	public void comenzarJuego() {
		System.out.println("Como todos los jugadores estan listos,  se va a dar comienzo al juego");
	}

	

	


	
	
	
	
}
