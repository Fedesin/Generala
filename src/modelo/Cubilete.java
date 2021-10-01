package modelo;
public class Cubilete {
	
	private Dado[] dados;

	public Cubilete() {//por default el cubilete se crea con 5 dados dentro
		dados = new Dado[5];
		dados[0]= new Dado();
		dados[1]= new Dado();
		dados[2]= new Dado();
		dados[3]= new Dado();
		dados[4]= new Dado();
	}
	
	public void setDados(int cantDados) {//ingreso una cantidad de 1 a 5 dados
		if (cantDados<6 && cantDados>0) {
		this.dados = new Dado[cantDados];
		for (int i=0; i<cantDados; i++) {
			dados[i]=new Dado();
		}
		}
	}	

	public void tirarDados() { //tiro todos los dados
		for (int i=0; i<5; i++) {
			dados[i].tirardado();
		}
	}
	
	public void tirarDado(int lugarDado) {
		dados[lugarDado].tirardado();
	}
	
	public int getDado(int posicion) {//con esto puedo mostrar los resultados de los dados despues de que se tiraron
		int resultado=0;
			resultado =dados[posicion].getValordado();
		return resultado;
	}
	
	public void vaciarCubilete() {
		dados= new Dado[0];//vacio el cubilete de dados con este metodo
	}
	
}
