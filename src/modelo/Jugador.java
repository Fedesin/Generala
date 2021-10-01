package modelo;

public class Jugador {

	protected String nombre;
	protected int turno=0;	
	protected static int cantidadJugadores=0;
	protected int puntos;
	protected int [] tablaDePuntos;
	protected boolean listo=false;
	
	public Jugador(String nombre) {//el constructor del jugador es con el nombre si o si
		this.nombre=nombre;
		this.puntos=0;
		++cantidadJugadores;
		this.turno=cantidadJugadores;
		tablaDePuntos= new int[11];
		for (int i=0; i<11; i++) {//inicializo mi tabla de puntos
			tablaDePuntos[i]=0;
		}
	}

	public String getNombre() {
		return nombre;
	}
	
	public boolean consultarDisponible(int lugarTabla) {
		boolean respuesta=true;
			if (tablaDePuntos[lugarTabla]!=0) {
				respuesta=false;
			}
		return respuesta;
	}
	
	public int getTurno() {
		return turno;
	}

	public int getPuntos() {
		return puntos;
	}

	public int[] getTablaDePuntos() {
		return tablaDePuntos;
	}
	
	public void actualizarPuntos() {
		puntos=0;
		for (int i=0; i<11; i++) {
			if (tablaDePuntos[i]==-1) {//cuando en la tabla de puntos se tacha algun resultado para el conteo final eso es lo mismo que 0
				puntos = puntos + 0;
			}else{
			puntos = puntos + tablaDePuntos[i];
			}
		}
	}
	
	public void sumarPuntos(int puntosASumar, int lugarEnLaTabla) {
		this.tablaDePuntos[lugarEnLaTabla]=puntosASumar;
	}
	
	public int controlarPocisionTabla(int lugarEnLaTabla) {
		int puntosActuales=0;
			puntosActuales=tablaDePuntos[lugarEnLaTabla];
		return puntosActuales;
	}
	
	public void modificarTabla(int puntos,int lugar) {
		tablaDePuntos[lugar]=puntos;
	}
	

}
