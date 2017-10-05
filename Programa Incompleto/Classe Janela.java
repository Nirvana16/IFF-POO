import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// Ctrl+Shift+O ja importa tudo de vez
//import javax.swing.*; // Isso importa toda a biblioteca

public class Janela extends JFrame  {
	JButton bOK, bLimpa;
	JTextField Ta, Tb, Tc, TDelta, Tx1, Tx2;
	JLabel La,Lb, Lc, LDelta, Lx1, Lx2;
	
	Janela(){
		
		// variavel para listener =================================================================
		Ouvinte o;
		o = new Ouvinte ();
		
		// Layout da Janela =================================================================
		this.setLayout(null);
		
		this.setSize(400,250);
		this.setTitle("Equação");
		this.setLocation(100,100);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Text Label A =================================================================
		La = new JLabel("A:");
		La.setSize(20, 20);
		La.setLocation(25, 20);
		this.add(La);
		
		Ta = new JTextField("");
		Ta.setSize(80, 20);
		Ta.setLocation(50, 20);
		Ta.addMouseListener(o);
		this.add(Ta);
		
		//Text Label  Delta =================================================================
		LDelta = new JLabel("Delta:");
		LDelta.setSize(45, 20);
		LDelta.setLocation(250, 20);
		this.add(LDelta);
		
		TDelta = new JTextField("");
		TDelta.setSize(80, 20);
		TDelta.setLocation(290, 20);
		TDelta.addMouseListener(o);
		this.add(TDelta);
		
		//Text Label  B =================================================================
		Lb = new JLabel("B:");
		Lb.setSize(80, 20);
		Lb.setLocation(25, 65);
		this.add(Lb);

		Tb = new JTextField("");
		Tb.setSize(80, 20);
		Tb.setLocation(50, 65);
		Tb.addMouseListener(o);
		this.add(Tb);
		
		//Text Label  C =================================================================
		Lc = new JLabel("C:");
		Lc.setSize(80,20);
		Lc.setLocation(25,110);
		this.add(Lc);
		
		Tc = new JTextField("");
		Tc.setSize(80, 20);
		Tc.setLocation(50, 110);
		Tc.addMouseListener(o);
		this.add(Tc);
		
		//TextLabel X1 =================================================================
		Lx1 = new JLabel("X1:");
		Lx1.setSize(25, 20);
		Lx1.setLocation(250, 65);
		this.add(Lx1);
								
		Tx1 = new JTextField("");
		Tx1.setSize(80, 20);
		Tx1.setLocation(290, 65);
		this.add(Tx1);
				
		//TextLabel X2 =================================================================
		Lx2 = new JLabel("X2:");
		Lx2.setSize(25, 20);
		Lx2.setLocation(250, 110);
		this.add(Lx2);
								
		Tx2 = new JTextField("");
		Tx2.setSize(80, 20);
		Tx2.setLocation(290, 110);
		this.add(Tx2);
		
		// Botao OK =================================================================
		bOK = new JButton("OK");
		bOK.setSize(100,30);
		bOK.setLocation(25,150);
		bOK.setBackground(Color.green);
		bOK.addMouseListener(o); // ouvinte
		this.add(bOK);
		
		// Botao limpa =================================================================
		bLimpa = new JButton("Limpar");
		bLimpa.setSize(100,30);
		bLimpa.setLocation(260,150);
		bLimpa.setBackground(Color.yellow);
		bLimpa.addMouseListener(o); // ouvinte
		this.add(bLimpa);
		
		this.show();
		
		

	}
	// Classe Ouvinte =================================================================
	// Classe interna, definida dentro de outr classe principal 
	public class Ouvinte implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == bLimpa) {
				Ta.setText("");
				Tb.setText("");
				Tc.setText("");
				TDelta.setText("");
				Tx1.setText("");
				Tx2.setText("");
			}
			if(e.getSource() == bOK){
				int a, b, c, delta;
				double x1, x2;
				DecimalFormat fx1, fx2;
				
				
				a = Integer.parseInt(Ta.getText()); // Esse metodo parsInt da classe Integer ele transforma
				b = Integer.parseInt(Tb.getText()); // String em Inteiro
				c = Integer.parseInt(Tc.getText());
				
				delta = ((b*b)-(4*a*c));
				
				TDelta.setText(Integer.toString(delta));
				x1 = (-b + Math.sqrt(delta)) / (2*a); // Esse metodo devolve double
				x2 = (-b - Math.sqrt(delta)) / (2*a); // por isso nao pode usar float
				
				fx1 = new DecimalFormat("###.##");
				Tx1.setText(fx1.format(x1));
				
				fx2 = new DecimalFormat("###.##");
				Tx2.setText(fx2.format(x2));
				
				//Tx1.setText(Double.toString(x1));
				//Tx2.setText(Double.toString(x2));
				
			}
			
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == bOK){
				// Descomente para brincadeira do botao pulando
				//if (bOK.getY()==200) bOK.setLocation(50,150); 
				//else bOK.setLocation(50,200);
				
			}
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}
}
