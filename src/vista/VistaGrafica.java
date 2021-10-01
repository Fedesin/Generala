package vista;

import controlador.Controlador;
import controlador.IVista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class VistaGrafica extends JFrame implements IVista {

	private int Jugador;
	private Controlador controlador;
	private JLabel lblNombredejugador;
	private JLabel lblJugador;
	private JLabel lblPuntos;
	private JLabel lblPuntosTotales;
	private JPanel panel_1;
	private JSeparator separator;
	private JLabel lblPuntosuno;
	private JLabel lblPuntosdos;
	private JLabel lblPuntostres;
	private JLabel lblPuntoscuatro;
	private JLabel lblPuntoscinco;
	private JLabel lblPuntosseis;
	private JLabel lblPuntosescalera;
	private JLabel lblPuntosfull;
	private JLabel lblPuntospoker;
	private JLabel lblPuntosgenerala;
	private JLabel lblPuntosgeneraladoble;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel lblEscalera;
	private JLabel lblFull;
	private JLabel lblPoker;
	private JLabel lblGenerala;
	private JLabel lblGeneralaDoble;
	private JPanel panel;
	private JLabel lblImagen;
	private JLabel lblImagen_1;
	private JLabel lblImagen_2;
	private JLabel lblImagen_3;
	private JLabel lblImagen_4;
	private JRadioButton rdbtnDado;
	private JRadioButton rdbtnDado_1;
	private JRadioButton rdbtnDado_2;
	private JRadioButton rdbtnDado_3;
	private JRadioButton rdbtnDado_4;
	private JButton btnVolverATirar;
	private JButton btnTerminarTurno;
	private JButton btnUltimaTirada;
	private JLabel lblTurnoDe;
	private JLabel lblJugadoract;
	private JButton btnEstoyListo;
	private JLabel lblPantalla ;
	private JPanel panel_2;
	private JButton btnRespuesta;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private JRadioButton radioButton_5;
	private JRadioButton rdbtnEscaleraServida;
	private JRadioButton rdbtnFullServido;
	private JRadioButton rdbtnPokerServido;
	private JRadioButton rdbtnEscalera;
	private JRadioButton rdbtnFull;
	private JRadioButton rdbtnPoker;
	private JRadioButton rdbtnGenerala;
	private JRadioButton rdbtnGeneralaDoble;
	private JButton btnTachar;
	private JButton btnMostrarLosMejores;
	File archivo;
    FileWriter escribir;
    PrintWriter linea;
    private JTextArea txtrGanadores;
    
    
	public VistaGrafica(Controlador controlador) {
		this.controlador=controlador;
		getContentPane().setForeground(UIManager.getColor("Button.background"));
		setControlador(controlador);
		//setJugador();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		this.setTitle("Generala");
		this.setSize(551,465);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lblJugador = new JLabel("Jugador:");
		lblJugador.setBounds(10, 11, 58, 14);
		getContentPane().add(lblJugador);
		
		lblNombredejugador = new JLabel("NombreDeJugador");
		lblNombredejugador.setBounds(66, 11, 194, 14);
		getContentPane().add(lblNombredejugador);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del jugador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 36, 147, 246);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblPuntos = new JLabel("Sus puntos son:");
		lblPuntos.setBounds(10, 20, 108, 22);
		panel_1.add(lblPuntos);
		
		lblPuntosTotales = new JLabel("Total");
		lblPuntosTotales.setBounds(113, 20, 62, 22);
		panel_1.add(lblPuntosTotales);
		
		separator = new JSeparator();
		separator.setBounds(10, 40, 127, 2);
		panel_1.add(separator);
		
		label = new JLabel("1:");
		label.setBounds(10, 53, 46, 14);
		panel_1.add(label);
		
		lblPuntosuno = new JLabel("PuntosUno");
		lblPuntosuno.setBounds(30, 53, 62, 14);
		panel_1.add(lblPuntosuno);
		
		label_1 = new JLabel("2:");
		label_1.setBounds(10, 70, 27, 14);
		panel_1.add(label_1);
		
		lblPuntosdos = new JLabel("PuntosDos");
		lblPuntosdos.setBounds(31, 70, 62, 14);
		panel_1.add(lblPuntosdos);
		
		label_2 = new JLabel("3:");
		label_2.setBounds(10, 85, 46, 14);
		panel_1.add(label_2);
		
		lblPuntostres = new JLabel("PuntosTres");
		lblPuntostres.setBounds(30, 85, 54, 16);
		panel_1.add(lblPuntostres);
		
		label_3 = new JLabel("4:");
		label_3.setBounds(10, 102, 27, 14);
		panel_1.add(label_3);
		
		lblPuntoscuatro = new JLabel("PuntosCuatro");
		lblPuntoscuatro.setBounds(30, 102, 73, 14);
		panel_1.add(lblPuntoscuatro);
		
		label_4 = new JLabel("5:");
		label_4.setBounds(10, 119, 16, 14);
		panel_1.add(label_4);
		
		lblPuntoscinco = new JLabel("PuntosCinco");
		lblPuntoscinco.setBounds(30, 119, 62, 14);
		panel_1.add(lblPuntoscinco);
		
		label_5 = new JLabel("6:");
		label_5.setBounds(10, 135, 16, 14);
		panel_1.add(label_5);
		
		lblPuntosseis = new JLabel("PuntosSeis");
		lblPuntosseis.setBounds(30, 135, 73, 14);
		panel_1.add(lblPuntosseis);
		
		lblEscalera = new JLabel("Escalera:");
		lblEscalera.setBounds(10, 153, 74, 14);
		panel_1.add(lblEscalera);
		
		lblPuntosescalera = new JLabel("PuntosEscalera");
		lblPuntosescalera.setBounds(79, 153, 80, 14);
		panel_1.add(lblPuntosescalera);
		
		lblFull = new JLabel("Full:");
		lblFull.setBounds(10, 172, 46, 14);
		panel_1.add(lblFull);
		
		lblPuntosfull = new JLabel("PuntosFull");
		lblPuntosfull.setBounds(79, 172, 54, 14);
		panel_1.add(lblPuntosfull);
		
		lblPoker = new JLabel("Poker:");
		lblPoker.setBounds(10, 189, 82, 14);
		panel_1.add(lblPoker);
		
		lblPuntospoker = new JLabel("PuntosPoker");
		lblPuntospoker.setBounds(79, 189, 73, 14);
		panel_1.add(lblPuntospoker);
		
		lblGenerala = new JLabel("Generala:");
		lblGenerala.setBounds(10, 206, 93, 14);
		panel_1.add(lblGenerala);
		
		lblPuntosgenerala = new JLabel("PuntosGenerala");
		lblPuntosgenerala.setBounds(79, 206, 80, 14);
		panel_1.add(lblPuntosgenerala);
		
		lblGeneralaDoble = new JLabel("Generala doble:");
		lblGeneralaDoble.setBounds(10, 225, 127, 14);
		panel_1.add(lblGeneralaDoble);
		
		lblPuntosgeneraladoble = new JLabel("PuntosGeneralaDoble");
		lblPuntosgeneraladoble.setBounds(100, 225, 46, 14);
		panel_1.add(lblPuntosgeneraladoble);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tirada", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 291, 515, 124);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(12, 49, 65, 65);
		panel.add(lblImagen);
		
		lblImagen_1 = new JLabel("");
		lblImagen_1.setBounds(119, 49, 65, 65);
		panel.add(lblImagen_1);
		
		lblImagen_2 = new JLabel("");
		lblImagen_2.setBounds(223, 49, 65, 65);
		panel.add(lblImagen_2);
		
		lblImagen_3 = new JLabel("");
		lblImagen_3.setBounds(334, 49, 65, 65);
		panel.add(lblImagen_3);
		
		lblImagen_4 = new JLabel("");
		lblImagen_4.setBounds(440, 49, 65, 65);
		panel.add(lblImagen_4);
		
		rdbtnDado = new JRadioButton("Dado 1");
		rdbtnDado.setBounds(12, 19, 71, 23);
		panel.add(rdbtnDado);
		
		rdbtnDado_1 = new JRadioButton("Dado 2");
		rdbtnDado_1.setBounds(119, 19, 65, 23);
		panel.add(rdbtnDado_1);
		
		rdbtnDado_2 = new JRadioButton("Dado 3");
		rdbtnDado_2.setBounds(223, 19, 65, 23);
		panel.add(rdbtnDado_2);
		
		rdbtnDado_3 = new JRadioButton("Dado 4");
		rdbtnDado_3.setBounds(334, 19, 65, 23);
		panel.add(rdbtnDado_3);
		
		rdbtnDado_4 = new JRadioButton("Dado 5");
		rdbtnDado_4.setBounds(440, 19, 65, 23);
		panel.add(rdbtnDado_4);
		
		btnVolverATirar = new JButton("Volver a tirar");
		btnVolverATirar.setVisible(false);
		btnVolverATirar.setBounds(297, 259, 228, 23);
		getContentPane().add(btnVolverATirar);
		
		btnTerminarTurno = new JButton("Terminar turno");
		btnTerminarTurno.setVisible(false);
		btnTerminarTurno.setBounds(297, 213, 228, 23);
		getContentPane().add(btnTerminarTurno);
		
		btnUltimaTirada = new JButton("Ultima tirada");
		btnUltimaTirada.setVisible(false);
		btnUltimaTirada.setBounds(297, 237, 228, 23);
		getContentPane().add(btnUltimaTirada);
		
		lblTurnoDe = new JLabel("Turno de:");
		lblTurnoDe.setBounds(375, 11, 65, 14);
		getContentPane().add(lblTurnoDe);
		
		lblJugadoract = new JLabel("JugadorAct");
		lblJugadoract.setBounds(450, 11, 75, 14);
		getContentPane().add(lblJugadoract);
		
		btnEstoyListo = new JButton("Estoy listo");
		btnEstoyListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tengo que poner que el jugador esta listo 
				//esto deberia ademas llamar al controlador y que el controlador
				//llame a un metodo del modelo que controle que esten todos los jugadores listos
				try {
					controlador.jugadorListo();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnEstoyListo.setVisible(false);
			}
		});
		btnEstoyListo.setBounds(167, 213, 128, 68);
		getContentPane().add(btnEstoyListo);
		
		panel_2 = new JPanel();
		panel_2.setVisible(false);
		
		lblPantalla = new JLabel("Pantalla");
		lblPantalla.setBounds(167, 34, 343, 49);
		getContentPane().add(lblPantalla);
		lblPantalla.setVerticalAlignment(SwingConstants.TOP);
		lblPantalla.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione el juego", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(167, 87, 358, 124);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnRespuesta = new JButton("Respuesta");
		btnRespuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Jugador==controlador.getTurno()) {
						radioButton.setVisible(false);
						radioButton_1.setVisible(false);
						radioButton_2.setVisible(false);
						radioButton_3.setVisible(false);
						radioButton_4.setVisible(false);
						radioButton_5.setVisible(false);
						
						panel_2.setVisible(false);
						update(getGraphics());
						
						if (rdbtnEscaleraServida.isVisible()==false
								&&
							rdbtnFullServido.isVisible()==false
								&&
							rdbtnPokerServido.isVisible()==false
								) {
							if(
									radioButton_5.isSelected()==false
									&&
									radioButton_4.isSelected()==false
									&&
									radioButton_3.isSelected()==false
									&&
									radioButton_2.isSelected()==false
									&&
									radioButton_1.isSelected()==false
									&&
									radioButton.isSelected()==false) {
									try {
										tacharPuntos();
									} catch (RemoteException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
						}
						
						
						
						
						
						
						
						if (rdbtnEscaleraServida.isSelected()==true) {
							try {
								rdbtnEscaleraServida.setSelected(false);
								rdbtnEscaleraServida.setVisible(false);
								controlador.respuestaEscaleraServida(true);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						if (rdbtnEscaleraServida.isSelected()==false
								&&
								rdbtnEscaleraServida.isVisible()==true) {
							rdbtnEscaleraServida.setVisible(false);
							rdbtnEscaleraServida.setSelected(false);
							menuVolverATirar();
						}
						
						if (rdbtnFullServido.isSelected()==true) {
							try {
								rdbtnFullServido.setSelected(false);
								rdbtnFullServido.setVisible(false);
								controlador.respuestaFullServido(true);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						if (rdbtnFullServido.isSelected()==false
								&&
								rdbtnFullServido.isVisible()==true) {
							rdbtnFullServido.setVisible(false);
							rdbtnFullServido.setSelected(false);
							menuVolverATirar();
						}
						
						if (rdbtnPokerServido.isSelected()==true) {
							try {
								rdbtnPokerServido.setSelected(false);
								rdbtnPokerServido.setVisible(false);
								controlador.respuestaPokerServido(true);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						if (rdbtnPokerServido.isSelected()==false
								&&
								rdbtnPokerServido.isVisible()==true) {
							rdbtnPokerServido.setVisible(false);
							rdbtnPokerServido.setSelected(false);
							menuVolverATirar();
						}
						
						
						
						if (radioButton_5.isSelected()==true) {//este es 6
							try {
								radioButton_5.setSelected(false);
								controlador.respuesta6(true);
								
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						if (radioButton_4.isSelected()==true) {//este es 5
							try {
								radioButton_4.setSelected(false);
								controlador.respuesta5(true);
								
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						if (radioButton_3.isSelected()==true) {// este es 4
							try {
								radioButton_3.setSelected(false);
								controlador.respuesta4(true);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						if (radioButton_2.isSelected()==true) {// este es 3
							try {
								radioButton_2.setSelected(false);
								controlador.respuesta3(true);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						if (radioButton_1.isSelected()==true) {// este es 2
							try {
								radioButton_1.setSelected(false);
								controlador.respuesta2(true);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						if (radioButton.isSelected()==true) {// este es 1
							try {
								radioButton.setSelected(false);
								controlador.respuesta1(true);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
		});
		
		btnRespuesta.setBounds(244, 47, 114, 23);
		panel_2.add(btnRespuesta);
		
		 radioButton = new JRadioButton("1");
		 radioButton.setVisible(false);
		radioButton.setBounds(6, 21, 46, 23);
		panel_2.add(radioButton);
		
		 radioButton_1 = new JRadioButton("2");
		 radioButton_1.setVisible(false);
		radioButton_1.setBounds(6, 47, 46, 23);
		panel_2.add(radioButton_1);
		
		 radioButton_2 = new JRadioButton("3");
		 radioButton_2.setVisible(false);
		radioButton_2.setBounds(54, 21, 46, 23);
		panel_2.add(radioButton_2);
		
		 radioButton_3 = new JRadioButton("4");
		 radioButton_3.setVisible(false);
		radioButton_3.setBounds(54, 47, 36, 23);
		panel_2.add(radioButton_3);
		
		 radioButton_4 = new JRadioButton("5");
		 radioButton_4.setVisible(false);
		radioButton_4.setBounds(102, 21, 36, 23);
		panel_2.add(radioButton_4);
		
		 radioButton_5 = new JRadioButton("6");
		 radioButton_5.setVisible(false);
		radioButton_5.setBounds(102, 47, 36, 23);
		panel_2.add(radioButton_5);
		
		 rdbtnEscaleraServida = new JRadioButton("Escalera Servida");
		 rdbtnEscaleraServida.setVisible(false);
		rdbtnEscaleraServida.setBounds(140, 21, 117, 23);
		panel_2.add(rdbtnEscaleraServida);
		
		 rdbtnFullServido = new JRadioButton("Full Servido");
		 rdbtnFullServido.setVisible(false);
		rdbtnFullServido.setBounds(140, 47, 98, 23);
		panel_2.add(rdbtnFullServido);
		
		 rdbtnPokerServido = new JRadioButton("Poker Servido");
		 rdbtnPokerServido.setVisible(false);
		rdbtnPokerServido.setBounds(249, 21, 123, 23);
		panel_2.add(rdbtnPokerServido);
		
		rdbtnEscalera = new JRadioButton("Escalera");
		rdbtnEscalera.setVisible(false);
		rdbtnEscalera.setBounds(6, 73, 84, 23);
		panel_2.add(rdbtnEscalera);
		
		rdbtnFull = new JRadioButton("Full");
		rdbtnFull.setVisible(false);
		rdbtnFull.setBounds(73, 73, 65, 23);
		panel_2.add(rdbtnFull);
		
		rdbtnPoker = new JRadioButton("Poker");
		rdbtnPoker.setVisible(false);
		rdbtnPoker.setBounds(121, 73, 65, 23);
		panel_2.add(rdbtnPoker);
		
		rdbtnGenerala = new JRadioButton("Generala");
		rdbtnGenerala.setVisible(false);
		rdbtnGenerala.setBounds(176, 73, 81, 23);
		panel_2.add(rdbtnGenerala);
		
		rdbtnGeneralaDoble = new JRadioButton("Generala doble");
		rdbtnGeneralaDoble.setVisible(false);
		rdbtnGeneralaDoble.setBounds(249, 73, 123, 23);
		panel_2.add(rdbtnGeneralaDoble);
		
		btnTachar = new JButton("Tachar");
		btnTachar.setVisible(false);
		btnTachar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton.setVisible(false);
				radioButton_1.setVisible(false);
				radioButton_2.setVisible(false);
				radioButton_3.setVisible(false);
				radioButton_4.setVisible(false);
				radioButton_5.setVisible(false);
				rdbtnEscalera.setVisible(false);
				rdbtnFull.setVisible(false);
				rdbtnPoker.setVisible(false);
				rdbtnGenerala.setVisible(false);
				rdbtnGeneralaDoble.setVisible(false);
				btnTachar.setVisible(false);
				btnRespuesta.setVisible(true);
				panel_2.setVisible(false);
				update(getGraphics());
				if(radioButton.isSelected()==true) {
					radioButton.setSelected(false);
					controlador.lugarATachar=0;
					try {
						controlador.actualizarATachar();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(radioButton_1.isSelected()==true) {
					radioButton_1.setSelected(false);
					controlador.lugarATachar=1;
					try {
						controlador.actualizarATachar();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(radioButton_2.isSelected()==true) {
					radioButton_2.setSelected(false);
					controlador.lugarATachar=2;
					try {
						controlador.actualizarATachar();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(radioButton_3.isSelected()==true) {
					radioButton_3.setSelected(false);
					controlador.lugarATachar=3;
					try {
						controlador.actualizarATachar();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(radioButton_4.isSelected()==true) {
					radioButton_4.setSelected(false);
					controlador.lugarATachar=4;
					try {
						controlador.actualizarATachar();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(radioButton_5.isSelected()==true) {
					radioButton_5.setSelected(false);
					controlador.lugarATachar=5;
					try {
						controlador.actualizarATachar();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(rdbtnEscalera.isSelected()==true) {
					rdbtnEscalera.setSelected(false);
					controlador.lugarATachar=6;
					try {
						controlador.actualizarATachar();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(rdbtnFull.isSelected()==true) {
					rdbtnFull.setSelected(false);
					controlador.lugarATachar=7;
					try {
						controlador.actualizarATachar();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(rdbtnPoker.isSelected()==true) {
					rdbtnPoker.setSelected(false);
					controlador.lugarATachar=8;
					try {
						controlador.actualizarATachar();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(rdbtnGenerala.isSelected()==true) {
					rdbtnGenerala.setSelected(false);
					controlador.lugarATachar=9;
					try {
						controlador.actualizarATachar();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(rdbtnGeneralaDoble.isSelected()==true) {
					rdbtnGeneralaDoble.setSelected(false);
					controlador.lugarATachar=10;
					try {
						
						controlador.actualizarATachar();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		btnTachar.setBounds(6, 96, 352, 23);
		panel_2.add(btnTachar);
		txtrGanadores = new JTextArea();
		txtrGanadores.setWrapStyleWord(true);
		txtrGanadores.setVisible(false);
		txtrGanadores.setBounds(167, 61, 208, 221);
		getContentPane().add(txtrGanadores);
		btnMostrarLosMejores = new JButton("Mostrar los mejores jugadores");
		btnMostrarLosMejores.setVisible(false);
		btnMostrarLosMejores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ac� tengo que mostrar un cartel o en el label pantalla los ganadores del txt pero los mejores.
				btnMostrarLosMejores.setVisible(false);
				txtrGanadores.setVisible(true);
				List<SimpleEntry<Integer, String>> result;
		        try (Stream<String> stream = Files.lines(Paths.get("Ganadores.txt"))) {
		           result = stream.map(s -> s.split("\\s"))
		                          .map(a -> new SimpleEntry<>(Integer.parseInt(a[0]), a[1]))
		                          .sorted(Comparator.comparingInt(SimpleEntry::getKey))
		                          .collect(Collectors.toCollection(ArrayList::new));
		               Collections.reverse(result);
		           for (int i=0;i<result.size();i++) {
		               String s =result.get(i).toString();
		               txtrGanadores.append(s+"\n");
		        }

		        } catch (IOException ee) { ee.printStackTrace(); }
				
				/*try {
					//sortObserve();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}//ordena el archivo
				ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "GanadoresOrdenados.txt");//y con esto lo muestro
                try {
                   // pb.start();
                } catch (IOException ee) {
                   // ee.printStackTrace();}
			}*/
			}
		});
		btnMostrarLosMejores.setBounds(317, 60, 208, 23);
		getContentPane().add(btnMostrarLosMejores);
		archivo = new File("Ganadores.txt");
		this.setVisible(true);
		
	}

	@Override
	public void setControlador(Controlador controlador) {
		//this.controlador = controlador;
		// this.controlador.setVista(this);
	}
	
	@Override
	public void setJugador() throws RemoteException {
		this.Jugador = controlador.cantJugadores();
	}
	

	@Override
	public void menujugando() throws RemoteException{
		//ac� es donde tengo que realizar toda la pantalla con todo lo que ve el usuario en su turno
		String s= new String(controlador.getNombre(Jugador));
		lblNombredejugador.setText(s);
		lblJugadoract.setText(controlador.mostrarJugador(controlador.getTurno()));
		lblPuntosTotales.setText(Integer.toString(controlador.mostrarPuntos(Jugador)));
		lblPuntosuno.setText(Integer.toString(controlador.mostrarTabla(Jugador,0)));
		lblPuntosdos.setText(Integer.toString(controlador.mostrarTabla(Jugador,1)));
		lblPuntostres.setText(Integer.toString(controlador.mostrarTabla(Jugador,2)));
		lblPuntoscuatro.setText(Integer.toString(controlador.mostrarTabla(Jugador,3)));
		lblPuntoscinco.setText(Integer.toString(controlador.mostrarTabla(Jugador,4)));
		lblPuntosseis.setText(Integer.toString(controlador.mostrarTabla(Jugador,5)));
		lblPuntosescalera.setText(Integer.toString(controlador.mostrarTabla(Jugador,6)));
		lblPuntosfull.setText(Integer.toString(controlador.mostrarTabla(Jugador,7)));
		lblPuntospoker.setText(Integer.toString(controlador.mostrarTabla(Jugador,8)));
		lblPuntosgenerala.setText(Integer.toString(controlador.mostrarTabla(Jugador,9)));
		lblPuntosgeneraladoble.setText(Integer.toString(controlador.mostrarTabla(Jugador,10)));
		update(getGraphics());
		
	}

	@Override
	public void tiradaRealizada() {
	lblPantalla.setText( "<html>Se realizo la tirada.<html>");	
	}

	@Override
	public void mostrarTirada()  throws RemoteException{
		int dado1;
		int dado2;
		int dado3;
		int dado4;
		int dado5;
		//ac� tengo que mostrar los daditos que salieron con imagencitas
		dado1=controlador.consultarDado(0);
		dado2=controlador.consultarDado(1);
		dado3=controlador.consultarDado(2);
		dado4=controlador.consultarDado(3);
		dado5=controlador.consultarDado(4);
		lblJugadoract.setText(controlador.getNombre(controlador.getTurno()));
		////DADO 1//////////////////////
		if (dado1==1) {
			//poner fotito dado1.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado1.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen.getWidth(),
	                lblImagen.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen.setIcon(iconoEscalado);
			//lblImagen.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado1.png"));
		}
		if (dado1==2) {
			//poner fotito dado2.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado2.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen.getWidth(),
	                lblImagen.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen.setIcon(iconoEscalado);
			//lblImagen.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado2.png"));
		}
		if (dado1==3) {
			//poner fotito dado3.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado3.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen.getWidth(),
	                lblImagen.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen.setIcon(iconoEscalado);
			//lblImagen.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado3.png"));
		}
		if (dado1==4) {
			//poner fotito dado4.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado4.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen.getWidth(),
	                lblImagen.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen.setIcon(iconoEscalado);
			//lblImagen.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado4.png"));
		}
		if (dado1==5) {
			//poner fotito dado5.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado5.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen.getWidth(),
	                lblImagen.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen.setIcon(iconoEscalado);
			//lblImagen.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado5.png"));
		}
		if (dado1==6) {
			//poner fotito dado6.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado6.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen.getWidth(),
	                lblImagen.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen.setIcon(iconoEscalado);
			//lblImagen.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado6.png"));
		}////DADO 2///////////////////////
		if (dado2==1) {
			//poner fotito dado1.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado1.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_1.getWidth(),
	                lblImagen_1.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_1.setIcon(iconoEscalado);
			//lblImagen_1.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado1.png"));
		}
		if (dado2==2) {
			//poner fotito dado2.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado2.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_1.getWidth(),
	                lblImagen_1.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_1.setIcon(iconoEscalado);
			//lblImagen_1.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado2.png"));
		}
		if (dado2==3) {
			//poner fotito dado3.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado3.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_1.getWidth(),
	                lblImagen_1.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_1.setIcon(iconoEscalado);
			//lblImagen_1.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado3.png"));
		}
		if (dado2==4) {
			//poner fotito dado4.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado4.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_1.getWidth(),
	                lblImagen_1.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_1.setIcon(iconoEscalado);
			//lblImagen_1.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado4.png"));
		}
		if (dado2==5) {
			//poner fotito dado5.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado5.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_1.getWidth(),
	                lblImagen_1.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_1.setIcon(iconoEscalado);
			//lblImagen_1.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado5.png"));
		}
		if (dado2==6) {
			//poner fotito dado6.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado6.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_1.getWidth(),
	                lblImagen_1.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_1.setIcon(iconoEscalado);
			
			//lblImagen_1.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado6.png"));
		}////////////////////////////
		////////DADO 3//////////////////////
		if (dado3==1) {
			//poner fotito dado1.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado1.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_2.getWidth(),
	                lblImagen_2.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_2.setIcon(iconoEscalado);
			//lblImagen_2.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado1.png"));
		}
		if (dado3==2) {
		//poner fotito dado2.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado2.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_2.getWidth(),
	                lblImagen_2.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_2.setIcon(iconoEscalado);
			//lblImagen_2.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado2.png"));
		}
		if (dado3==3) {
		//poner fotito dado3.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado3.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_2.getWidth(),
	                lblImagen_2.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_2.setIcon(iconoEscalado);
			//lblImagen_2.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado3.png"));
		}
		if (dado3==4) {
		//poner fotito dado4.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado4.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_2.getWidth(),
	                lblImagen_2.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_2.setIcon(iconoEscalado);
			//lblImagen_2.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado4.png"));
		}
		if (dado3==5) {
		//poner fotito dado5.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado5.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_2.getWidth(),
	                lblImagen_2.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_2.setIcon(iconoEscalado);
			//lblImagen_2.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado5.png"));
		}
		if (dado3==6) {
		//poner fotito dado6.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado6.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_2.getWidth(),
	                lblImagen_2.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_2.setIcon(iconoEscalado);
			//lblImagen_2.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado6.png"));
		}////////////////////////////
		///////DADO 4///////////////////////
		if (dado4==1) {
		//poner fotito dado1.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado1.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_3.getWidth(),
	                lblImagen_3.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_3.setIcon(iconoEscalado);
			//lblImagen_3.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado1.png"));
		}
		if (dado4==2) {
		//poner fotito dado2.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado2.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_3.getWidth(),
	                lblImagen_3.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_3.setIcon(iconoEscalado);
			//lblImagen_3.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado2.png"));
		}
		if (dado4==3) {
		//poner fotito dado3.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado3.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_3.getWidth(),
	                lblImagen_3.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_3.setIcon(iconoEscalado);
			//lblImagen_3.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado3.png"));
		}
		if (dado4==4) {
		//poner fotito dado4.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado4.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_3.getWidth(),
	                lblImagen_3.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_3.setIcon(iconoEscalado);
			//lblImagen_3.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado4.png"));
		}
		if (dado4==5) {
		//poner fotito dado5.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado5.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_3.getWidth(),
	                lblImagen_3.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_3.setIcon(iconoEscalado);
			//lblImagen_3.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado5.png"));
		}
		if (dado4==6) {
		//poner fotito dado6.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado6.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_3.getWidth(),
	                lblImagen_3.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_3.setIcon(iconoEscalado);
			//lblImagen_3.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado6.png"));
		}////////////////////////////
		//////DADO 5////////////////////////
		if (dado5==1) {
		//poner fotito dado1.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado1.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_4.getWidth(),
	                lblImagen_4.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_4.setIcon(iconoEscalado);
			//lblImagen_4.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado1.png"));
		}
		if (dado5==2) {
		//poner fotito dado2.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado2.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_4.getWidth(),
	                lblImagen_4.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_4.setIcon(iconoEscalado);
			//lblImagen_4.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado2.png"));
		}
		if (dado5==3) {
		//poner fotito dado3.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado3.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_4.getWidth(),
	                lblImagen_4.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_4.setIcon(iconoEscalado);
			//lblImagen_4.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado3.png"));
		}
		if (dado5==4) {
		//poner fotito dado4.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado4.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_4.getWidth(),
	                lblImagen_4.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_4.setIcon(iconoEscalado);
			//lblImagen_4.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado4.png"));
		}
		if (dado5==5) {
		//poner fotito dado5.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado5.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_4.getWidth(),
	                lblImagen_4.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_4.setIcon(iconoEscalado);
			//lblImagen_4.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado5.png"));
		}
		if (dado5==6) {
		//poner fotito dado6.png
			ImageIcon imgIcon = new ImageIcon("src/imagenes/dado6.png");
	        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblImagen_4.getWidth(),
	                lblImagen_4.getHeight(), Image.SCALE_SMOOTH);
	        Icon iconoEscalado = new ImageIcon(imgEscalada);
	        lblImagen_4.setIcon(iconoEscalado);
			//lblImagen_4.setIcon(new ImageIcon("C:/Users/fedec/Desktop/Universidad/Programaci�n orientada a objetos/Generala/src/imagenes/dado6.png"));
		}////////////////////////////
		update(getGraphics());
	}

	@Override
	public void ganaste() throws RemoteException{
		String s="Felicidades "+controlador.mostrarJugador(Jugador)+" Ganaste!!";
		lblPantalla.setText("<html>"+s+"<html>");
		update(getGraphics());
		
	}

	@Override
	public void preguntarEscaleraServida() {
		panel_2.setVisible(false);
		update(getGraphics());
		lblPantalla.setText("<html>Seleccione si va a tomar los 25 puntos de la Escalera Servida <html>");
		panel_2.setVisible(true);
		rdbtnEscaleraServida.setVisible(true);
		update(getGraphics());
	}

	@Override
	public void preguntarFullServido() {
		panel_2.setVisible(false);
		update(getGraphics());
		lblPantalla.setText("<html>�Desea usted tomar los 35 puntos hechos con el juego de Full Servido?<html>");
		panel_2.setVisible(true);
		rdbtnFullServido.setVisible(true);
		update(getGraphics());
	}

	@Override
	public void preguntarPokerServido() {
		panel_2.setVisible(false);
		update(getGraphics());
		lblPantalla.setText("<html>�Desea usted tomar los 45 puntos hechos con el juego de Poker Servido?<html>");
		panel_2.setVisible(true);
		rdbtnPokerServido.setVisible(true);
		update(getGraphics());
	}

	@Override
	public void actualizarTablaDePuntos() throws RemoteException {
		
		
		lblJugadoract.setText(controlador.getNombre(controlador.getTurno()));
		lblPantalla.setText("<html>Los puntos totales del jugador: "+controlador.mostrarJugador(Jugador)+" Se actualizaron y son: "+controlador.mostrarPuntos(Jugador)+" puntos.<html>");
		lblPuntosTotales.setText(Integer.toString(controlador.mostrarPuntos(Jugador)));
		lblPuntosuno.setText(Integer.toString(controlador.mostrarTabla(Jugador,0)));
		lblPuntosdos.setText(Integer.toString(controlador.mostrarTabla(Jugador,1)));
		lblPuntostres.setText(Integer.toString(controlador.mostrarTabla(Jugador,2)));
		lblPuntoscuatro.setText(Integer.toString(controlador.mostrarTabla(Jugador,3)));
		lblPuntoscinco.setText(Integer.toString(controlador.mostrarTabla(Jugador,4)));
		lblPuntosseis.setText(Integer.toString(controlador.mostrarTabla(Jugador,5)));
		lblPuntosescalera.setText(Integer.toString(controlador.mostrarTabla(Jugador,6)));
		lblPuntosfull.setText(Integer.toString(controlador.mostrarTabla(Jugador,7)));
		lblPuntospoker.setText(Integer.toString(controlador.mostrarTabla(Jugador,8)));
		lblPuntosgenerala.setText(Integer.toString(controlador.mostrarTabla(Jugador,9)));
		lblPuntosgeneraladoble.setText(Integer.toString(controlador.mostrarTabla(Jugador,10)));
		
	}

	@Override
	public void pasarAlSiguienteJugador() throws RemoteException{
		lblPantalla.setText("<html>Se acabo el turno de "+controlador.mostrarJugador(Jugador)+"<html>");
		if(Jugador==controlador.cantJugadores()) {
			lblJugadoract.setText(controlador.mostrarJugador(1));
		}else {
			lblJugadoract.setText(controlador.mostrarJugador(controlador.getTurno()+1));
		}
		
		update(getGraphics());
	}

	@Override
	public void menuVolverATirar()  {
		// pone visible un boton el cual esperamos a que sea clikeado
		// y cuando este boton sea clickeado se van a volver a tirar los dados que tengan el tick activado arriba de ellos.
		btnVolverATirar.setVisible(true);
		update(getGraphics());
		btnVolverATirar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				  if (rdbtnDado.isSelected()) {
						try {
							controlador.tirarDado(0);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						rdbtnDado.setSelected(false);
						
					}
					if (rdbtnDado_1.isSelected()) {
						try {
							controlador.tirarDado(1);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						rdbtnDado_1.setSelected(false);
						
					}
					if (rdbtnDado_2.isSelected()) {
						try {
							controlador.tirarDado(2);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						rdbtnDado_2.setSelected(false);
						
					}
					if (rdbtnDado_3.isSelected()) {
						try {
							controlador.tirarDado(3);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						rdbtnDado_3.setSelected(false);
						
					}
					if (rdbtnDado_4.isSelected()) {
						try {
							controlador.tirarDado(4);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						rdbtnDado_4.setSelected(false);
						
					}
					if (controlador.getTiradas()==1) {
					btnVolverATirar.setVisible(false);
					update(getGraphics());
					try {
						mostrarTirada();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					btnVolverATirar.repaint();
					//update(getGraphics());
					controlador.setTirada(2);
					try {
						actualizarATercerTirada();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					}
				}
			});	
	}
	
	@Override
	public void menuUltimaTirada() {
		btnUltimaTirada.setVisible(true);
		btnUltimaTirada.repaint();
		//update(getGraphics());
		btnUltimaTirada.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				  if (rdbtnDado.isSelected()) {
						try {
							controlador.tirarDado(0);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						rdbtnDado.setSelected(false);
						
					}
					if (rdbtnDado_1.isSelected()) {
						try {
							controlador.tirarDado(1);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						rdbtnDado_1.setSelected(false);
						
					}
					if (rdbtnDado_2.isSelected()) {
						try {
							controlador.tirarDado(2);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						rdbtnDado_2.setSelected(false);
						
					}
					if (rdbtnDado_3.isSelected()) {
						try {
							controlador.tirarDado(3);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						rdbtnDado_3.setSelected(false);
						
					}
					if (rdbtnDado_4.isSelected()) {
						try {
							controlador.tirarDado(4);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						rdbtnDado_4.setSelected(false);
						
					}
					if (controlador.getTiradas()==2) {
					btnUltimaTirada.setVisible(false);
					update(getGraphics());
					try {
						mostrarTirada();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					btnUltimaTirada.repaint();
					//update(getGraphics());
					controlador.setTirada(3);
					try {
						actualizarAConsultarPuntos();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				}
			});	
	}
	
	public void actualizarAConsultarPuntos() throws RemoteException{
		controlador.actualizarAConsultarPuntos();
	}
	
	public void actualizarATercerTirada() throws RemoteException{
		controlador.actualizarATercerTirada();
	}
	
	@Override
	public void menuDobleGenerala() {
		lblPantalla.setText("<html>Usted formo doble generala!!!, Se le van a sumar 100 puntos.<html>");
		update(getGraphics());
	}

	@Override
	public void anotarGenerala() {
		lblPantalla.setText("<html>Usted formo generala!!!, Se le van a sumar 50 puntos.<html>");
		update(getGraphics());
	}

	@Override
	public void anotarPoker() {
		lblPantalla.setText("<html>Usted formo Poker!!!, Se le van a sumar 40 puntos.<html>");
		update(getGraphics());
	}

	@Override
	public void anotarFull() {
		lblPantalla.setText("<html>Usted formo Full!!!, Se le van a sumar 30 puntos.<html>");
		update(getGraphics());	
		
	}		

	@Override
	public void anotarEscalera() {
	lblPantalla.setText("<html>Usted formo Escalera!!!, Se le van a sumar 20 puntos.<html>");
	update(getGraphics());
		
		
	}

	@Override
	public void preguntar6()  {
		panel_2.setVisible(false);
		update(getGraphics());
		lblPantalla.setText("<html>Seleccione que juego toma<html>");
		panel_2.setVisible(true);
		radioButton_5.setVisible(true);
		update(getGraphics());	
	}

	@Override
	public void preguntar5() {
		panel_2.setVisible(false);
		update(getGraphics());
		lblPantalla.setText("<html>Seleccione que juego toma<html>");
		panel_2.setVisible(true);
		radioButton_4.setVisible(true);
		update(getGraphics());
	}

	@Override
	public void preguntar4() {
		panel_2.setVisible(false);
		update(getGraphics());
		lblPantalla.setText("<html>Seleccione que juego toma<html>");
		panel_2.setVisible(true);
		radioButton_3.setVisible(true);
		update(getGraphics());
	}

	@Override
	public void preguntar3() {
		panel_2.setVisible(false);
		update(getGraphics());
		lblPantalla.setText("<html>Seleccione que juego toma<html>");
		panel_2.setVisible(true);
		radioButton_2.setVisible(true);
		update(getGraphics());		
	}

	@Override
	public void preguntar2() {
		panel_2.setVisible(false);
		update(getGraphics());
		lblPantalla.setText("<html>Seleccione que juego toma<html>");
		panel_2.setVisible(true);
		radioButton_1.setVisible(true);
		update(getGraphics());	
				
	}

	@Override
	public void preguntar1() {
		panel_2.setVisible(false);
		update(getGraphics());
		lblPantalla.setText("<html>Seleccione que juego toma<html>");
		panel_2.setVisible(true);
		radioButton.setVisible(true);
		update(getGraphics());
	}

	@Override
	public void tacharPuntos() throws RemoteException {
		panel_2.setVisible(true);
		btnRespuesta.setVisible(false);
		lblPantalla.setText("<html>Como usted no pudo formar juego de nada,  o no decidio anotarse puntos de ningun juego debe tacharse un juego.<html>");
		btnTachar.setVisible(true);
		
		if (controlador.puntajeDisponible(Jugador, 0)==true) {
			radioButton.setVisible(true);
		}
		if (controlador.puntajeDisponible(Jugador, 1)==true) {
			radioButton_1.setVisible(true);
		}
		if (controlador.puntajeDisponible(Jugador, 2)==true) {
			radioButton_2.setVisible(true);
		}
		if (controlador.puntajeDisponible(Jugador, 3)==true) {
			radioButton_3.setVisible(true);
		}
		if (controlador.puntajeDisponible(Jugador, 4)==true) {
			radioButton_4.setVisible(true);
		}
		if (controlador.puntajeDisponible(Jugador, 5)==true) {
			radioButton_5.setVisible(true);
		}
		if (controlador.puntajeDisponible(Jugador, 6)==true) {
			rdbtnEscalera.setVisible(true);
		}
		if (controlador.puntajeDisponible(Jugador, 7)==true) {
			rdbtnFull.setVisible(true);
		}
		if (controlador.puntajeDisponible(Jugador, 8)==true) {
			rdbtnPoker.setVisible(true);
		}
		if (controlador.puntajeDisponible(Jugador, 9)==true) {
			rdbtnGenerala.setVisible(true);
		}
		if (controlador.puntajeDisponible(Jugador, 10)==true) {
			rdbtnGeneralaDoble.setVisible(true);
		}
		update(getGraphics());
	}

	@Override
	public void mostrarGanador() throws RemoteException{
		String ganador=controlador.consultarGanador();
		String s="El jugador ganador es: "+ganador+" Felicidades!!! :D";
		lblPantalla.setText("<html>"+s+"<html>");
		guardarGanador();
		btnMostrarLosMejores.setVisible(true);
		update(getGraphics());
		
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
	
	public static void sortObserve() throws IOException {
		File fin = new File("Ganadores.txt");
		File fout = new File("GanadoresOrdenados.txt");
 
 
		FileInputStream fis = new FileInputStream(fin);
		FileOutputStream fos = new FileOutputStream(fout);
 
		BufferedReader in = new BufferedReader(new InputStreamReader(fis));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
 
		String aLine;
		LinkedList<String> al = new LinkedList<String> ();
 
 
		int i = 0;
		while ((aLine = in.readLine()) != null) {
			//get the lines you want, here I don't want something starting with - or empty
			if (!aLine.trim().startsWith("-") && aLine.trim().length() > 0) {
				//Collections.sort(al);
				al.add(aLine);
				i++;
				
			}
		}
		
		
		Collections.sort(al);
		Collections.reverse(al);
		//output sorted content to a file
		for (String s : al) {
		    out.write(s);
			out.newLine();
			out.write("-----------------------------------------");
			out.newLine();
		}
 
		in.close();
		out.close();
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
	public void mostrarGanadorServido() throws RemoteException{
		String ganador=controlador.consultarGanador();
		btnMostrarLosMejores.setVisible(true);
		String s="Felicidades "+controlador.mostrarJugador(Jugador)+" Ganaste!! ��Porque hiciste una generala servida!!";
		lblPantalla.setText("<html>"+s+"<html>");
		guardarGanadorServido();
		update(getGraphics());
		
		
	}

	@Override
	public void finalizar() {
		lblPantalla.setText("<html>Por favor reinicie el juego...<html>");
		update(getGraphics());
	}

	@Override
	public void elijaUnLugarValidoATachar() {
		lblPantalla.setText("<html>Por favor elija un lugar valido a tachar...<html>");
		update(getGraphics());
	}

	@Override
	public void cambiarJugador() throws RemoteException {
		btnVolverATirar.setVisible(false);
		btnUltimaTirada.setVisible(false);
		if(controlador.getTurno()==controlador.cantJugadores()) {
			lblJugadoract.setText(controlador.mostrarJugador(1));
		}else {
			lblJugadoract.setText(controlador.mostrarJugador(controlador.getTurno()+1));
		}
		//update(getGraphics());
		//btnTerminarTurno.setVisible(true);
		update(getGraphics());
		/*btnTerminarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTerminarTurno.setVisible(false);
				lblJugadoract.setText(controlador.mostrarJugador(controlador.getTurno()));
				update(getGraphics());
				controlador.pasarTurno();
			}
		});
		*/
	}

	@Override
	public void agregadoCorrecto(String nombre) {
		lblPantalla.setText("<html> Se agrego exitosamente al jugador: "+nombre+"<html>");
		update(getGraphics());
	}

	@Override
	public void mostrarJugadores(String jugadoresFormateados) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {	
				JOptionPane.showMessageDialog(null, "La lista de los jugadores es: "+jugadoresFormateados);
			
			}
		});
		
		
	}

	@Override
	public void comenzarJuego() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {	
				JOptionPane.showMessageDialog(null, "Como todos los jugadores estan listos,  se va a dar comienzo al juego");
			
			}
		});
	}
}
