import gnu.prolog.term.AtomTerm;
import gnu.prolog.term.CompoundTerm;
import gnu.prolog.term.IntegerTerm;
import gnu.prolog.term.Term;
import gnu.prolog.term.VariableTerm;
import gnu.prolog.vm.Environment;
import gnu.prolog.vm.Interpreter;
import gnu.prolog.vm.PrologCode;
import gnu.prolog.vm.PrologException;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Menu extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	static Menu frame;
	
	static DatosNino frame1;
	static Regalo frame2;
	static BadChildren frame3;
	static GoodChildren frame4;
	static AccBuenas frame5;
	static AccMalas frame6;
	static TopListaRegalos frame7;
	static ListaRegalos frame8;
	static ListaPosiblesRegalos frame9;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new Menu();					
					frame.setVisible(true);
					frame.setResizable(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		FileWriter archiv;
		FileWriter archiv1;
		try {
			archiv = new FileWriter("BaseConocimiento.pl",false);
			archiv1=new FileWriter("BaseConocimiento1.pl",false);
			PrintWriter pw=new PrintWriter(archiv);
			PrintWriter pw1=new PrintWriter(archiv1);
			pw.print("esnino(A,B,C,D,E,F,G):-nino(A,B,C,D,_,_,_),nino(A,B,C,_,E,_,_),nino(A,B,C,_,_,F,_),nino(A,B,C,_,_,_,G);nino(A,B,C, _, _, _, _),nino(_, B, _, _, _, _, _),nino(_,_,C,_,_,_,_).");
			pw1.print("esregalo(W,X,Y,Z):-regalo(W,_,_,Z),regalo(W,X,_,_),regalo(W,_,Y,_);regalo(W,_,_,_),regalo(_,X,_,_).");
			pw.print("\nesnin(A,B,C,D,E,F,G):-nino(A,B,C,_,_,F,_),nino(A,B,C,_,_,_,G),nino(A,B,C,_,E,_,_),nino(A,B,C,D,_,_,_);nino(A,B,C, _, _, _, _),nino(_, B, _, _, _, _, _),nino(_,_,C,_,_,_,_).");
			archiv.close();
			archiv1.close();
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 406);
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/ldcoma10/workspace1/Diego/src/santa.gif"));
		lblNewLabel.setBounds(252, 0, 336, 320);
		panel.add(lblNewLabel);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Dialog", Font.BOLD, 49));
		lblBienvenido.setBounds(12, 12, 315, 64);
		panel.add(lblBienvenido);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/ldcoma10/workspace1/Diego/src/Paisajes de nieve (7)P.gif"));
		lblNewLabel_1.setBounds(0, -11, 600, 399);
		panel.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon("/home/ldcoma10/workspace1/Diego/src/images.jpg"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem.setForeground(Color.WHITE);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("SALIR           ");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		mntmNewMenuItem_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1.setBackground(Color.DARK_GRAY);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		
		JMenu mnMantenimientoDeDatos = new JMenu("Mantenimiento de Datos");
		mnMantenimientoDeDatos.setForeground(Color.WHITE);
		mnMantenimientoDeDatos.setBackground(Color.WHITE);
		menuBar.add(mnMantenimientoDeDatos);
		
		JMenuItem mntmIngresarDatosNi = new JMenuItem("Ingresar Datos Niñ@");
		final PoloNorteInc lista= new PoloNorteInc();
		mntmIngresarDatosNi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1=new DatosNino(frame,lista);
				frame1.setVisible(true);
				frame1.setResizable(false);
				frame.setVisible(false);
			}
		});
		mntmIngresarDatosNi.setForeground(Color.WHITE);
		mntmIngresarDatosNi.setBackground(Color.DARK_GRAY);
		mnMantenimientoDeDatos.add(mntmIngresarDatosNi);
				
		JMenuItem mntmIngresarInfoDe = new JMenuItem("Ingresar Info de Regalo");
		mntmIngresarInfoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2=new Regalo(frame,lista);
				frame2.setVisible(true);
				frame2.setResizable(false);
				frame.setVisible(false);
			}
		});
		mntmIngresarInfoDe.setForeground(Color.WHITE);
		mntmIngresarInfoDe.setBackground(Color.DARK_GRAY);
		mnMantenimientoDeDatos.add(mntmIngresarInfoDe);
		
		JMenu mnConsulta = new JMenu("Consulta");
		mnConsulta.setForeground(Color.WHITE);
		
		JMenuItem mntmListaDeNios = new JMenuItem("Lista de Niñ@s Buen@s");
		mntmListaDeNios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame4=new GoodChildren(frame,lista);
				frame4.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		mntmListaDeNios.setForeground(Color.WHITE);
		
		menuBar.add(mnConsulta);
		mntmListaDeNios.setBackground(Color.DARK_GRAY);
		mnConsulta.add(mntmListaDeNios);
		
		JMenuItem mntmListaDeNios_1 = new JMenuItem("Lista de Niñ@s Mal@s");
		mntmListaDeNios_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame3=new BadChildren(frame,lista);
				frame3.setVisible(true);
				frame.setVisible(false);
			}
		});
		mntmListaDeNios_1.setForeground(Color.WHITE);
		mntmListaDeNios_1.setBackground(Color.DARK_GRAY);
		mnConsulta.add(mntmListaDeNios_1);
		
		JMenuItem mntmListaDeAcciones = new JMenuItem("Lista de Acciones Buenas");
		mntmListaDeAcciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cadena=JOptionPane.showInputDialog(panel, "Escriba el nombre de la acción");
				if (cadena!=""){					
						frame5=new AccBuenas(frame,lista.lista,cadena.toLowerCase());
						frame5.setVisible(true);
						frame.setVisible(false);}}
				
				
			
		});
		mntmListaDeAcciones.setForeground(Color.WHITE);
		mntmListaDeAcciones.setBackground(Color.DARK_GRAY);
		
		menuBar.add(mnConsulta);
		mnConsulta.add(mntmListaDeAcciones);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Lista de Acciones Malas");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cadena=JOptionPane.showInputDialog(panel, "Escriba el nombre de la acción");
				if (cadena!=""){					
						frame6=new AccMalas(frame,lista.lista,cadena.toLowerCase());
						frame6.setVisible(true);
						frame.setVisible(false);}}
		});
		mntmNewMenuItem_2.setForeground(Color.WHITE);
		mntmNewMenuItem_2.setBackground(Color.DARK_GRAY);
		mnConsulta.add(mntmNewMenuItem_2);
		
		JMenuItem mntmTopDe = new JMenuItem("Top 5 de Regalos");
		mntmTopDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame7=new TopListaRegalos(frame,lista);
				frame7.setVisible(true);
				frame.setVisible(false);
			}
		});
		mntmTopDe.setBackground(Color.DARK_GRAY);
		mntmTopDe.setForeground(Color.WHITE);
		mnConsulta.add(mntmTopDe);
		
		JMenuItem mntmListaDeRegalos = new JMenuItem("Lista de Regalos por Niñ@");
		mntmListaDeRegalos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cadena=JOptionPane.showInputDialog(panel, "Escriba el nombre del niñ@, la edad y el país respectivamente (divididos por comas)");
				StringTokenizer tokens= new StringTokenizer(cadena, ",");
				if (cadena!=""& tokens.countTokens()==3){					
					System.out.println(lista.lista.size());
					String nombre=tokens.nextToken();
					int edad=Integer.parseInt(tokens.nextToken());
					String pais=tokens.nextToken();
					System.out.println("datos"+nombre+edad+pais);
					boolean enc=lista.buscarnino(nombre, edad, pais);					
					if (enc==true){
						frame8=new ListaRegalos(frame,nombre,edad,pais);
						frame8.setVisible(true);
						frame.setVisible(false);}}
			}
		});			
		
		mntmListaDeRegalos.setForeground(Color.WHITE);
		mntmListaDeRegalos.setBackground(Color.DARK_GRAY);
		mnConsulta.add(mntmListaDeRegalos);
		
		JMenuItem mntmListaDeRegalos_1 = new JMenuItem("Regalos válidos para el niñ@");
		mntmListaDeRegalos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cadena=JOptionPane.showInputDialog(panel, "Escriba el nombre del niñ@, la edad y el país respectivamente (divididos por comas)");
				StringTokenizer tokens= new StringTokenizer(cadena, ",");
				if (cadena!=""& tokens.countTokens()==3){
					
					System.out.println(lista.lista.size());
					String nombre=tokens.nextToken();
					int edad=Integer.parseInt(tokens.nextToken());
					String pais=tokens.nextToken();
					System.out.println("datos"+nombre+edad+pais);
					boolean enc=lista.buscarnino(nombre, edad, pais);
					
					if (enc==true){
						frame9=new ListaPosiblesRegalos(frame,nombre,edad,pais);
						frame9.setVisible(true);
						frame.setVisible(false);}}
			}
		});
		mntmListaDeRegalos_1.setForeground(Color.WHITE);
		mntmListaDeRegalos_1.setBackground(Color.DARK_GRAY);
		mnConsulta.add(mntmListaDeRegalos_1);
		
		JMenuItem mntmPresupuestoTotalDe = new JMenuItem("Presupuesto Total de Santa");
		mntmPresupuestoTotalDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//prolog
				Integer pres=0;
				String ni="Regalos";
				int cont=lista.lista.size();
				Environment env = new Environment();				    
			    env.ensureLoaded(AtomTerm.get("/home/ldcoma10/workspace1/Diego/BaseConocimiento.pl"));
			    Interpreter interpreter = env.createInterpreter();	 
			    env.runInitialization(interpreter);
				for(int m=0;m<cont;m++){		    
				
				VariableTerm a=new VariableTerm();
			    VariableTerm b=new VariableTerm();
			    VariableTerm c=new VariableTerm();
			    VariableTerm d=new VariableTerm();
			   
			    
			    //Se construye la pregunta a prolog
			    Term[] arg={AtomTerm.get(lista.lista.get(m).Nombre),IntegerTerm.get(lista.lista.get(m).Edad),AtomTerm.get(lista.lista.get(m).Pais),a,b,c,d};
			    CompoundTerm goalTerm = new CompoundTerm(AtomTerm.get("esnin"), arg);
			         				       
			   boolean x=true;
			   String lista3 = null;
			   	        
					
						try {
							if (interpreter.runOnce(goalTerm) == PrologCode.SUCCESS )
							{           
								lista3=c.toString();
								System.out.println(lista3+"arriba");
								
								
								if (lista3.equals("[mediasdegolfista]")){
									x=false;
														}
							else{
								x=true;
							}}
								        	
							else {
								x=false;}
						} catch (PrologException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
							
				   
		        
				
				if (x==true){
					lista3=lista3.replace("]", "");
					lista3=lista3.replace("[", "");
					StringTokenizer tokens3= new StringTokenizer(lista3, ",");
				
			    
					int presupuesto=Integer.parseInt(d.toString());
			     while (tokens3.hasMoreTokens()){
			    	 Environment env1 = new Environment();				    
					 env1.ensureLoaded(AtomTerm.get("/home/ldcoma10/workspace1/Diego/BaseConocimiento1.pl"));
					 Interpreter interpreter1 = env1.createInterpreter();	 
					 env1.runInitialization(interpreter1);
			    	 String posible=tokens3.nextToken();
			    	   
			    	    
			    	    
			    	    VariableTerm w=new VariableTerm();
					    VariableTerm y=new VariableTerm();
					    VariableTerm z=new VariableTerm();
					    
					   		    	     
			    	    
					   	Term[] arg1={AtomTerm.get(posible),w,y,z};
						
					    CompoundTerm goalTerm1 = new CompoundTerm(AtomTerm.get("esregalo"), arg1);
					    
					    try {
							if (interpreter1.runOnce(goalTerm1) == PrologCode.SUCCESS){  
								
									
								
								int precio=Integer.parseInt(y.toString());							
								String temp=w.toString();
								int edad=Integer.parseInt(temp);					

								if (lista.lista.get(m).Edad>=edad && precio<=presupuesto ){
									ni+="\n"+posible;
									pres+=precio;
									presupuesto-=precio;}
								
								
								}
							else{ 
								x=true;
								System.out.println("no funco");
							}
							
							
						
						} catch (PrologException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			    
					    env1.closeStreams(); 
					    env.closeStreams();
					   env.ensureLoaded(AtomTerm.get("/home/ldcoma10/workspace1/Diego/BaseConocimiento.pl"));
					    interpreter = env.createInterpreter();	 
					    env.runInitialization(interpreter);
			     
			     
			
		    
			     }}}
				JOptionPane.showMessageDialog(panel,"El presupuesto total de Santa es   "+pres+"\n"+ni);
			}
		});
		mntmPresupuestoTotalDe.setForeground(Color.WHITE);
		mntmPresupuestoTotalDe.setBackground(Color.DARK_GRAY);
		mnConsulta.add(mntmPresupuestoTotalDe);
		
		JMenu mnNewMenu_1 = new JMenu("Ayuda");
		mnNewMenu_1.setForeground(Color.WHITE);
		mnNewMenu_1.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmInformacinDe = new JMenuItem("Info de Polo Norte INC ");
		mntmInformacinDe.setForeground(Color.WHITE);
		mntmInformacinDe.setBackground(Color.DARK_GRAY);
		mnNewMenu_1.add(mntmInformacinDe);
		
	}

}
