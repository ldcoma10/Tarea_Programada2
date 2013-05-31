import gnu.prolog.term.AtomTerm;
import gnu.prolog.term.CompoundTerm;
import gnu.prolog.term.IntegerTerm;
import gnu.prolog.term.Term;
import gnu.prolog.term.VariableTerm;
import gnu.prolog.vm.Environment;
import gnu.prolog.vm.Interpreter;
import gnu.prolog.vm.PrologCode;
import gnu.prolog.vm.PrologException;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import java.util.StringTokenizer;



public class ListaRegalos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public ListaRegalos(final JFrame frame,String Nombre,Integer Edad,String Pais) {
		
		
		//prolog 
		String ni="Regalo";
		
		Environment env = new Environment();				    
	    env.ensureLoaded(AtomTerm.get("/home/ldcoma10/workspace1/Diego/BaseConocimiento.pl"));
	    Interpreter interpreter = env.createInterpreter();	 
	    env.runInitialization(interpreter);
	    
	    
		
		VariableTerm a=new VariableTerm();
	    VariableTerm b=new VariableTerm();
	    VariableTerm c=new VariableTerm();
	    VariableTerm d=new VariableTerm();
    
	    //Se construye la pregunta a prolog
	    Term[] arg={AtomTerm.get(Nombre.toLowerCase()),IntegerTerm.get(Edad.toString()),AtomTerm.get(Pais.toLowerCase()),a,b,c,d};
	    CompoundTerm goalTerm = new CompoundTerm(AtomTerm.get("esnin"), arg);
	         				       
	   boolean x=true;
	   String lista3 = null;
	   
        try {
			if (interpreter.runOnce(goalTerm) == PrologCode.SUCCESS )
			{           
				lista3=c.toString();
						
				if (lista3.equals("[mediasdegolfista]")){
					ni+="\nmedias de golfista";
					x=false;
										}
			else{				
				   int j=0;
				   while (j!=14){ni+=" "; j++;}
				   ni+="\tMarca";
				   j=0;
				   while (j!=15){ni+=" "; j++;}
				   ni+="\tPrecio";
				x=true;
			}}
				        	
			else {
				ni= "no se encontró";
				}
		} catch (PrologException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
        env.closeStreams();
		
		if (x==true){
			Environment env1 = new Environment();				    
		    env.ensureLoaded(AtomTerm.get("/home/ldcoma10/workspace1/Diego/BaseConocimiento1.pl"));
		    Interpreter interpreter1 = env.createInterpreter();	 
		    env1.runInitialization(interpreter1);
		
			
		    
		lista3=lista3.replace("]", "");
		
		lista3=lista3.replace("[", "");
		System.out.println(lista3);
		StringTokenizer tokens3= new StringTokenizer(lista3, ",");
		
	    
		
	     while (tokens3.hasMoreTokens()){
	    	    String posible=tokens3.nextToken();
	    	    	    
	    	    
	    	    VariableTerm w=new VariableTerm();
			    VariableTerm y=new VariableTerm();
			    VariableTerm z=new VariableTerm();
			    
			   		    	     
	    	    
			   	Term[] arg1={AtomTerm.get(posible),w,y,z};
				
			    CompoundTerm goalTerm1 = new CompoundTerm(AtomTerm.get("esregalo"), arg1);
			    
			    try {
					if (interpreter1.runOnce(goalTerm1) == PrologCode.SUCCESS){  
												
						
						Integer precio=Integer.parseInt(y.toString());							
						String temp=z.toString();						
						int cont=20-posible.length();
						ni+="\n"+posible;
						for(int i=0;i!=cont;i++){if (cont<0)break; ni+=" ";}
						cont=20-temp.length();
						ni+="\t"+temp;
						for(int i=0;i!=cont;i++){if (cont<0)break; ni+=" ";}
						cont=20-precio.toString().length();
						ni+="\t"+precio;
						
						
						w.value=null;
						y.value=null;
						
						}
					else{ 
						x=true;
						System.out.println("no funco");
					}
					
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (PrologException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	     
		  
	     
	     env1.closeStreams();
	  // Fin.
	     
	     }}
		
		
		
		setBackground(Color.LIGHT_GRAY);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 0, 438, 271);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblninoosbuenos = new JLabel("Lista de Regalos");
		lblninoosbuenos.setBounds(106, 24, 238, 15);
		lblninoosbuenos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblninoosbuenos.setForeground(new Color(255, 255, 255));
		panel.add(lblninoosbuenos);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				ListaRegalos.this.dispose();
			}
		});
		btnNewButton.setBounds(284, 201, 117, 25);
		panel.add(btnNewButton);
		
				
		TextArea textArea = new TextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setForeground(Color.BLACK);
		textArea.setBounds(10, 59, 268, 202);
		textArea.setEditable(false);
		textArea.setText(ni);
		panel.add(textArea);
	    
  		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/home/ldcoma10/workspace1/Diego/src/regalos.gif"));
		lblNewLabel_1.setBounds(284, 24, 130, 165);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/home/ldcoma10/workspace1/Diego/src/arboles-de-navidad-fondos-pantalla.jpg"));
		lblNewLabel.setBounds(-69, -126, 693, 542);
		panel.add(lblNewLabel);
		
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
				frame.setVisible(true);
				ListaRegalos.this.dispose();
			}
		});
		mntmNewMenuItem_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1.setBackground(Color.DARK_GRAY);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1.setBackground(Color.DARK_GRAY);
		mnNewMenu.add(mntmNewMenuItem_1);
		
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
