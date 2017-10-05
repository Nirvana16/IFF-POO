import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Janela extends JFrame 
{

	// -   -   - Declaração -   -   -
	
	JTabbedPane pane;
	JPanel criar;
	JTextField numCriarCaixa, nomeCriarCaixa, numSacCaixa, valorSacCaixa, numDepositCaixa, valorDepositCaixa,saldoDepositCaixa, saldoSacCaixa, nomeSacCaixa, nomeDepositCaixa;
	JLabel numCriarUser, nomeCriarUser, numSacUser, saldoDepostUser, saldoSacUser, numDepositUser, calorSacUser,  valorDepositUser, nomeSacUser, nomeDepositUser;
	JButton bSacar, bCriar, bDeposit, bListar, bContaDep, bContaSac;
	JTextArea areaListar;
	Gerenciador GContas;
	Conta conta;
	Enumeration<Conta> todasAsContas;
	
	// -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
	
	Janela()
	{
		
		Ouvinte ouvir = new Ouvinte();
		
		
		this.setBounds(450, 250, 600, 500);
		this.setTitle("JoniBank -  Porque você vale muito!");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(232, 232, 232)); 
		this.setLayout(null);
		
		JTabbedPane pane = new JTabbedPane();
		pane.setBackground(Color.LIGHT_GRAY);
		
		JPanel criar = new JPanel();
		JPanel sacar = new JPanel();
		JPanel depositar = new JPanel();
		JPanel listar = new JPanel();
		
		pane.add(criar, "Criar");
		pane.add(sacar, "Sacar");
		pane.add(depositar, "Depositar");
		pane.add(listar, "Listar");
		pane.setBounds(50, 50, 500, 300);
		add(pane);
		
		
		// -   -   - Criação -   -   -
		
		criar.setLayout(null); 
		criar.setBackground(Color.GRAY);
		
		numCriarUser = new JLabel("Numero: ");
		numCriarUser.setBounds(90, 50, 100, 20);
		numCriarUser.setFont(new Font("Arial",Font.ITALIC, 14));
		criar.add(numCriarUser);
		
		numCriarCaixa = new JTextField();
		numCriarCaixa.setBounds(160, 50, 250, 30);
		criar.add(numCriarCaixa);
		
		
		nomeCriarUser = new JLabel("Nome: ");
		nomeCriarUser.setBounds(110, 100, 100, 20);
		nomeCriarUser.setFont(new Font("Arial",Font.ITALIC, 14));
		criar.add(nomeCriarUser);
		
		nomeCriarCaixa = new JTextField();
		nomeCriarCaixa.setBounds(160, 100, 250, 30);
		criar.add(nomeCriarCaixa);
		
		bCriar = new JButton("OK");
		bCriar.setBounds(200, 200, 100, 30);
		bCriar.addMouseListener(ouvir);
		criar.add(bCriar);
		
		
		// -   -   - Saque -   -   -
		
		sacar.setLayout(null);
		sacar.setBackground(Color.GRAY);
		
		numSacUser = new JLabel("Numero: ");
		numSacUser.setBounds(90, 50, 100, 20);
		numSacUser.setFont(new Font("Arial",Font.ITALIC, 14));
		sacar.add(numSacUser);
		
		numSacCaixa = new JTextField();
		numSacCaixa.setBounds(160, 50, 250, 30);
		sacar.add(numSacCaixa);
		
		
		nomeSacUser = new JLabel("Nome: ");
		nomeSacUser.setBounds(110, 100, 100, 20);
		nomeSacUser.setFont(new Font("Arial",Font.ITALIC, 14));
		sacar.add(nomeSacUser);
		
		nomeSacCaixa = new JTextField();
		nomeSacCaixa.setBounds(160, 100, 100, 30);
		nomeSacCaixa.setEnabled(false);
		sacar.add(nomeSacCaixa);
		
		saldoSacUser = new JLabel("Saldo: ");
		saldoSacUser.setBounds(265, 100, 100, 20);
		saldoSacUser.setFont(new Font("Arial",Font.ITALIC, 14));
		sacar.add(saldoSacUser);
		
		saldoSacCaixa = new JTextField();
		saldoSacCaixa.setBounds(310, 100, 100, 30);
		saldoSacCaixa.setEnabled(false);
		sacar.add(saldoSacCaixa);
		
		calorSacUser = new JLabel("Valor: ");
		calorSacUser.setBounds(110, 150, 250, 30);
		calorSacUser.setFont(new Font("Arial",Font.ITALIC, 14));
		sacar.add(calorSacUser);
		
		valorSacCaixa = new JTextField();
		valorSacCaixa.setBounds(160, 150, 250, 30);
		sacar.add(valorSacCaixa);
		
		bSacar = new JButton("OK");
		bSacar.setBounds(180, 200, 100, 30);
		bSacar.addMouseListener(ouvir);
		sacar.add(bSacar);
		
		bContaSac = new JButton("CONTA");
		bContaSac.setBounds(300, 200, 100, 30);
		bContaSac.addMouseListener(ouvir);
		sacar.add(bContaSac);
		
		
		// -   -   - Depósito -   -   -
		
		depositar.setLayout(null);
		depositar.setBackground(Color.GRAY);
		
		numDepositUser = new JLabel("Numero: ");
		numDepositUser.setBounds(90, 50, 100, 20);
		numDepositUser.setFont(new Font("Arial",Font.ITALIC, 14));
		depositar.add(numDepositUser);
		
		numDepositCaixa = new JTextField();
		numDepositCaixa.setBounds(160, 50, 250, 30);
		depositar.add(numDepositCaixa);
		
		nomeDepositUser = new JLabel("Nome: ");
		nomeDepositUser.setBounds(110, 100, 100, 20);
		nomeDepositUser.setFont(new Font("Arial",Font.ITALIC, 14));
		depositar.add(nomeDepositUser);
		
		nomeDepositCaixa = new JTextField();
		nomeDepositCaixa.setBounds(160, 100, 100, 30);
		nomeDepositCaixa.setEnabled(false);
		depositar.add(nomeDepositCaixa);
		
		saldoDepostUser = new JLabel("Saldo: ");
		saldoDepostUser.setBounds(265, 100, 100, 20);
		saldoDepostUser.setFont(new Font("Arial",Font.ITALIC, 14));
		depositar.add(saldoDepostUser);
		
		saldoDepositCaixa = new JTextField();
		saldoDepositCaixa.setBounds(310, 100, 100, 30);
		saldoDepositCaixa.setEnabled(false);
		depositar.add(saldoDepositCaixa);
		
		valorDepositUser = new JLabel("Valor: ");
		valorDepositUser.setBounds(110, 150, 250, 30);
		valorDepositUser.setFont(new Font("Arial",Font.ITALIC, 14));
		depositar.add(valorDepositUser);
		
		valorDepositCaixa = new JTextField();
		valorDepositCaixa.setBounds(160, 150, 250, 30);
		depositar.add(valorDepositCaixa);
		
		bDeposit = new JButton("OK");
		bDeposit.setBounds(180, 200, 100, 30);
		bDeposit.addMouseListener(ouvir);
		depositar.add(bDeposit);
		
		bContaDep = new JButton("CONTA");
		bContaDep.setBounds(300, 200, 100, 30);
		bContaDep.addMouseListener(ouvir);
		depositar.add(bContaDep);
		
		
		// -   -   - Listar -   -   -
		
		listar.setLayout(null);
		listar.setBackground(Color.GRAY);
		
		bListar = new JButton("OK");
		bListar.setBounds(405, 10, 75, 30);
		bListar.addMouseListener(ouvir);
		listar.add(bListar);
		
		areaListar = new JTextArea();
		areaListar.setBounds(20, 50, 460, 210);	
		listar.add(areaListar);
	}
	
	public class Ouvinte extends MouseAdapter
	{
		Gerenciador GContas = new Gerenciador();
		public void mouseClicked(MouseEvent e)
		{
			if(e.getSource() == bCriar)
			{
				conta = new Conta(nomeCriarCaixa.getText(), numCriarCaixa.getText());
				GContas.GuardaConta(conta);
				JOptionPane.showMessageDialog(null, "Cadastro realizado!");
				nomeCriarCaixa.setText("");
				numCriarCaixa.setText("");
			}
			
			if(e.getSource() == bContaSac)
			{
				conta = GContas.RetornaConta(numSacCaixa.getText());
				saldoSacCaixa.setText(Float.toString(conta.verSaldo()));
				nomeSacCaixa.setText(conta.getNome());
			}			
			
			if(e.getSource() == bSacar)
			{
				conta = GContas.RetornaConta(numSacCaixa.getText());
				if( Float.parseFloat(valorSacCaixa.getText()) > conta.verSaldo()){
					JOptionPane.showMessageDialog(null, "No Moni!");
				}
				else{
					conta.sacar(Float.parseFloat(valorSacCaixa.getText()));
					GContas.GuardaConta(conta);
					JOptionPane.showMessageDialog(null, "Saque realizado!");
					valorSacCaixa.setText("");
					numSacCaixa.setText("");
					saldoSacCaixa.setText("");
					nomeSacCaixa.setText("");
				}
			}
			
			if(e.getSource() == bContaDep)
			{
				conta = GContas.RetornaConta(numDepositCaixa.getText());
				saldoDepositCaixa.setText(Float.toString(conta.verSaldo()));
				nomeDepositCaixa.setText(conta.getNome());
			}	
			
			if(e.getSource() == bDeposit)
			{
				conta = GContas.RetornaConta(numDepositCaixa.getText());
				saldoDepositCaixa.setText(Float.toString(conta.verSaldo()));
				conta.depositar(Float.parseFloat(valorDepositCaixa.getText()));
				GContas.GuardaConta(conta);
				JOptionPane.showMessageDialog(null, "Depósito feito!");
				nomeDepositCaixa.setText("");
				saldoDepositCaixa.setText("");
				numDepositCaixa.setText("");
				valorDepositCaixa.setText("");
			}
			
			if(e.getSource() == bListar)
			{
				areaListar.setText("");
				 String lista = new String();
				Conta conta = new Conta();
				
				todasAsContas = GContas.RetornaTodasContas();
				

				 while(todasAsContas.hasMoreElements()) 
				 {
						conta = todasAsContas.nextElement();
						lista = (lista+"Nome: "+conta.getNome()+"     Numero: "+conta.getNumeroConta()+"     Saldo: "+conta.verSaldo()+"\n----------------------------------------------------------------------------------------------------------------------\n");
				 }
				areaListar.setText(lista);
			}
		}	
	}	
}
