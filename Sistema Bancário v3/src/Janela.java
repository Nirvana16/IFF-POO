import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.EventObject;



public class Janela extends JFrame {

	private JPanel Tela, Tela1, Tela2, Tela3, Tela4;
	//cadastro
	public JTextField tF_Nome, tf_saldo, tF_Conta;
	public JButton btn_ccadastrar, btn_ccancelar;
	private JLabel lb_Nome, lb_Senha, lbl_SaldoInicial, lbl_Conta;
	public JPasswordField pF_senha;
	//movimentar conta
	public JTextField tF_movimentar_conta, tf_movimentar_valor;
	public JButton btn_movimentar_Buscar, btn_movimentar_Sacar,	btn_movimentar_Cancela, btn_movimentar_Depositar ;
	private JLabel lblValor,lb_Conta, lblNewLabel;
	//Remover Conta
	public JTextField tF_Remover_conta;
	private JLabel	lb_RConta;
	public JButton 	btn_Remover_Buscar,	btn_rRemover, btn_remover_Cancelar;
	//Relatorio
	public JButton btn_relatorio_Listar;
	public  JTextArea TA_TabelaContas;
	Gerenciador_da_Tabela gerenciador = new Gerenciador_da_Tabela();

	
	public Janela() {
		
		Container janela;
		janela=this.getContentPane(); 
		janela.setLayout(null); 
		this.setTitle("Sistema Bancário");
		setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		this.setSize(400,400);
		this.setResizable(false); 
		

		Tela = new JPanel();
		Tela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 577, 421);
		setContentPane(Tela);
		Tela.setLayout(null);
		
		Tela1 = new JPanel();
		Tela2 = new JPanel();
		Tela3 = new JPanel();
		Tela4 = new JPanel();
		 
		JTabbedPane Abas = new JTabbedPane(JTabbedPane.TOP);
		Abas.setBounds(12, 24, 544, 361);
		Tela.add(Abas, BorderLayout.NORTH);
	
		//Aba Cadastro
		
		Abas.addTab("Cadastro", null, Tela1, null);
		Tela1.setLayout(null);
		
		tF_Conta = new JTextField();
		tF_Conta.setBounds(128, 120, 95, 28);
		tF_Conta.setColumns(10);
		Tela1.add(tF_Conta);
		
		lbl_Conta = new JLabel("Conta  ");
		lbl_Conta.setBounds(67, 126, 49, 16);
		Tela1.add(lbl_Conta);
		
		tF_Nome = new JTextField();
		tF_Nome.setBounds(128, 43, 307, 28);
		tF_Nome.setColumns(10);
		Tela1.add(tF_Nome);
		
		lbl_SaldoInicial = new JLabel("Nome:  ");
		lbl_SaldoInicial.setBounds(67, 49, 49, 16);
		Tela1.add(lbl_SaldoInicial);
		
		lb_Nome = new JLabel("Saldo Inicial:  ");
		lb_Nome.setBounds(240, 89, 88, 16);
		Tela1.add(lb_Nome);
	
		tf_saldo = new JTextField();
		tf_saldo.setColumns(10);
		tf_saldo.setBounds(333, 83, 102, 28);
		Tela1.add(tf_saldo);

		lb_Senha = new JLabel("Senha:  ");
		lb_Senha.setBounds(69, 89, 58, 16);
		Tela1.add(lb_Senha);
	
		pF_senha = new JPasswordField();
		pF_senha.setBounds(128, 83, 95, 28);
		Tela1.add(pF_senha);

		btn_ccadastrar = new JButton("Cadastrar");
		btn_ccadastrar.setBounds(146, 192, 117, 29);
		btn_ccadastrar.addMouseListener(new Ouvinte());
		Tela1.add(btn_ccadastrar);
		
		btn_ccancelar = new JButton("Cancelar");
		btn_ccancelar.setBounds(259, 192, 117, 29);
		btn_ccancelar.addMouseListener(new Ouvinte());
		Tela1.add(btn_ccancelar);
		
		//Movimentar Conta
		
		Abas.addTab("Movimentar Conta", null, Tela2, null);
		Tela2.setLayout(null);
			
		JLabel lb_Conta = new JLabel("Conta");
		lb_Conta.setBounds(165, 18, 52, 19);
		Tela2.add(lb_Conta);
			
		tF_movimentar_conta = new JTextField();
		tF_movimentar_conta.setBounds(240, 17, 135, 19);
		tF_movimentar_conta.setColumns(10);
		Tela2.add(tF_movimentar_conta);
			
		btn_movimentar_Buscar = new JButton("Buscar");
		btn_movimentar_Buscar.setBounds(165, 52, 97, 25);
		btn_movimentar_Buscar.addMouseListener(new Ouvinte());
		Tela2.add(btn_movimentar_Buscar);
			
		btn_movimentar_Sacar = new JButton("Sacar");
		btn_movimentar_Sacar.setEnabled(false);
		btn_movimentar_Sacar.setBackground(new Color(224, 255, 255));
		btn_movimentar_Sacar.setForeground(Color.BLACK);
		btn_movimentar_Sacar.setBounds(170, 206, 117, 25);
		btn_movimentar_Sacar.addMouseListener(new Ouvinte());
		Tela2.add(btn_movimentar_Sacar);
			
		btn_movimentar_Depositar = new JButton("Depositar");
		btn_movimentar_Depositar.setEnabled(false);
		btn_movimentar_Depositar.setForeground(Color.BLACK);
		btn_movimentar_Depositar.setBackground(new Color(224, 255, 255));
		btn_movimentar_Depositar.setBounds(284, 206, 117, 25);
		btn_movimentar_Depositar.addMouseListener(new Ouvinte());
		Tela2.add(btn_movimentar_Depositar);
			
		tf_movimentar_valor = new JTextField();
		tf_movimentar_valor.setEnabled(false);
		tf_movimentar_valor.setColumns(10);
		tf_movimentar_valor.setBounds(240, 145, 135, 19);
		Tela2.add(tf_movimentar_valor);
			
		lblValor = new JLabel("Valor");
		lblValor.setEnabled(false);
		lblValor.setBounds(165, 146, 52, 19);
		Tela2.add(lblValor);

		btn_movimentar_Cancela = new JButton("Cancelar");
		btn_movimentar_Cancela.setBounds(274, 52, 97, 25);
		btn_movimentar_Cancela.addMouseListener(new Ouvinte()) ;
		Tela2.add(btn_movimentar_Cancela);
			

		
		//Remover Conta
		Abas.addTab("Remover Conta", Tela3);
		Tela3.setLayout(null);
		
		lb_RConta = new JLabel("Conta");
		lb_RConta.setBounds(112, 59, 52, 19);
		Tela3.add(lb_RConta);
		
		tF_Remover_conta = new JTextField();
		tF_Remover_conta.setBounds(176, 58, 135, 19);
		Tela3.add(tF_Remover_conta);
		tF_Remover_conta.setColumns(10);
		
		btn_Remover_Buscar = new JButton("Buscar");
		btn_Remover_Buscar.setBounds(347, 55, 117, 25);
		btn_Remover_Buscar.addMouseListener(new Ouvinte()) ;
		Tela3.add(btn_Remover_Buscar);
		
		btn_rRemover = new JButton("Remover");
		btn_rRemover.setEnabled(false);
		btn_rRemover.setBackground(new Color(224, 255, 255));
		btn_rRemover.setForeground(Color.BLACK);
		btn_rRemover.setBounds(146, 225, 117, 25);
		btn_rRemover.addMouseListener(new Ouvinte()) ;
		Tela3.add(btn_rRemover);
		
	    btn_remover_Cancelar = new JButton("Cancelar");
		btn_remover_Cancelar.setForeground(Color.BLACK);
		btn_remover_Cancelar.setBackground(new Color(224, 255, 255));
		btn_remover_Cancelar.setBounds(257, 225, 117, 25);
		btn_remover_Cancelar.addMouseListener(new Ouvinte()) ;
		Tela3.add(btn_remover_Cancelar);
				
		//Relatórios		
				
		
		Abas.addTab("Relatórios", null, Tela4, null);
		Tela4.setLayout(null);
		
		TA_TabelaContas= new JTextArea();
		TA_TabelaContas.setBounds(155, 64, 250, 208);
		Tela4.add(TA_TabelaContas);
		
		btn_relatorio_Listar = new JButton("Listar");
		btn_relatorio_Listar.setBounds(214, 22, 117, 29);
		btn_relatorio_Listar.addMouseListener(new Ouvinte());
		Tela4.add(btn_relatorio_Listar);	
		
	}
	
	class Ouvinte extends MouseAdapter
	{
	public void mouseClicked(MouseEvent evt )
	{
		Enumeration<Conta> tds_contas = null;
		Conta conta_nova, conta_existente;
		String n = null;
	    float saldo;
	    String numero_conta,nome,valor_desejado;
  
		try
		{
				
			//Cadastro
			if (evt.getSource()== btn_ccancelar)
				{
					tF_Conta.setText("");
					tF_Nome.setText("");
					tf_saldo.setText("");
					pF_senha.setText("");
					
				}
			if (evt.getSource()== btn_ccadastrar)
			{
				numero_conta = tF_Conta.getText();
				nome = tF_Nome.getText();
				//senha = pF_senha.getText();
				saldo= Float.parseFloat(tf_saldo.getText());
				
				//Buscar o número da conta p/ verifica se não está duplicada
				conta_existente = gerenciador.buscar_contas(numero_conta);
				if (conta_existente==null) 
				{
					conta_nova = new Conta(numero_conta,nome,saldo);
					gerenciador.add_contas(conta_nova);
					if(conta_nova != null)
						{
							JOptionPane.showMessageDialog(null,"Número da Conta: "+numero_conta+"\nNome: "+nome+"\n Seu saldo é: R$ " +saldo,"Conta " +numero_conta,JOptionPane.INFORMATION_MESSAGE);
							tF_Nome.setText("");
							tf_saldo.setText("");
							tF_Conta.setText("");
							pF_senha.setText("");
						}
					}
				else
					JOptionPane.showMessageDialog(null,"Número da Conta já existe\n Insira outra conta","Erro!", JOptionPane.INFORMATION_MESSAGE);
				
				tF_Nome.setText("");
				tf_saldo.setText("");
				tF_Conta.setText("");
				pF_senha.setText("");
			}
	
			//Movimentar
				if (evt.getSource()== btn_movimentar_Buscar)
				{
					numero_conta = tF_movimentar_conta.getText();
					conta_existente = gerenciador.buscar_contas(numero_conta);
					JOptionPane.showMessageDialog(null,"Número da Conta: "+conta_existente.getConta()+"\nNome: "+conta_existente.getNome()+"\n Seu saldo é: R$ " +conta_existente.getSaldo_inicial(),"Conta Encontrada!", JOptionPane.INFORMATION_MESSAGE);
					if (conta_existente!=null) 
					{
						btn_movimentar_Sacar.setEnabled(true);
						btn_movimentar_Depositar.setEnabled(true);
						tf_movimentar_valor.setEnabled(true);
						lblValor.setEnabled(true);
					
					}
					else
						JOptionPane.showMessageDialog(null,"Conta inexistente ou Campo conta vazios!","Erro!", JOptionPane.INFORMATION_MESSAGE);
				}
					
				if (evt.getSource()== btn_movimentar_Sacar)
						{
							numero_conta = tF_movimentar_conta.getText();
							conta_existente = gerenciador.buscar_contas(numero_conta);
							valor_desejado = tf_movimentar_valor.getText();
							if (conta_existente!=null)// && (valor_desejado!= null))
				    		{
				    			conta_existente.sacar(Float.parseFloat(valor_desejado));
				    			JOptionPane.showMessageDialog(null,"Número da Conta: "+conta_existente.getConta()+"\nNome: "+conta_existente.getNome()+"\n Seu saldo é: R$ " +conta_existente.getSaldo_inicial(),"Sucesso!!", JOptionPane.INFORMATION_MESSAGE);
				    			tf_movimentar_valor.setText("");
				    			btn_movimentar_Sacar.setEnabled(false);
								btn_movimentar_Depositar.setEnabled(false);
								tf_movimentar_valor.setEnabled(false);
								lblValor.setEnabled(false);
				    			
				    		}
				    		else
								JOptionPane.showMessageDialog(null,"Insira o valor desejado","Erro!", JOptionPane.INFORMATION_MESSAGE);
						
							btn_movimentar_Sacar.setEnabled(false);
							btn_movimentar_Depositar.setEnabled(false);
							tf_movimentar_valor.setEnabled(false);
							lblValor.setEnabled(false);
							tf_movimentar_valor.setText("");
							tF_movimentar_conta.setText("");
						}	
					
					
						
				  if (evt.getSource()== btn_movimentar_Depositar)
				    	{
				    		numero_conta = tF_movimentar_conta.getText();
				    		valor_desejado = tf_movimentar_valor.getText();
				    		conta_existente = gerenciador.buscar_contas(numero_conta);
				    		if (valor_desejado!= null)
				    		{
				    			conta_existente.depositar(Float.parseFloat(valor_desejado));
				    			JOptionPane.showMessageDialog(null,"Número da Conta: "+conta_existente.getConta()+"\nNome: "+conta_existente.getNome()+"\n Seu saldo é: R$ " +conta_existente.getSaldo_inicial(),"Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				    			tf_movimentar_valor.setText("");
				    			btn_movimentar_Sacar.setEnabled(false);
								btn_movimentar_Depositar.setEnabled(false);
								tf_movimentar_valor.setEnabled(false);
								lblValor.setEnabled(false);
				    	
			    		}
			    		else
							JOptionPane.showMessageDialog(null,"Insira o valor desejado","Erro!", JOptionPane.INFORMATION_MESSAGE);

						btn_movimentar_Sacar.setEnabled(false);
						btn_movimentar_Depositar.setEnabled(false);
						tf_movimentar_valor.setEnabled(false);
						lblValor.setEnabled(false);
						tf_movimentar_valor.setText("");
						tF_movimentar_conta.setText("");
				    	
					}
					if (evt.getSource()== btn_movimentar_Cancela)
				{
					tF_movimentar_conta.setText("");
					tf_movimentar_valor.setText("");
					
				}
			//Remover
			 if (evt.getSource()== btn_remover_Cancelar)
				{
					tF_Remover_conta.setText("");
				}
				
				if (evt.getSource()== btn_Remover_Buscar)
			    	{
			    		numero_conta = tF_Remover_conta.getText();
			    		conta_existente = gerenciador.buscar_contas(numero_conta);
			    		JOptionPane.showMessageDialog(null,"Número da Conta: "+conta_existente.getConta()+"\nNome: "+conta_existente.getNome()+"\n Seu saldo é: R$ " +conta_existente.getSaldo_inicial(),"Sucesso", JOptionPane.INFORMATION_MESSAGE);
			    		if (conta_existente!= null)
			    		{
			    			btn_rRemover.setEnabled(true);
			    		}
			    		else
			    			JOptionPane.showMessageDialog(null,"Conta inexistente ou Campo conta vazios!!","Erro!", JOptionPane.INFORMATION_MESSAGE);
					}
		
			  if (evt.getSource()== btn_rRemover)
			  	{
				  numero_conta = tF_Remover_conta.getText();
				  gerenciador.remover_contas(numero_conta);
				  
				  if (gerenciador.buscar_contas(numero_conta) == null)
				   {					  
					  JOptionPane.showMessageDialog(null,"Operação efetuada com sucesso","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
					  btn_rRemover.setEnabled(false);
					  tF_Remover_conta.setText("");
				   }
				  else
					  JOptionPane.showMessageDialog(null,"Tente Novamente!","Erro!",JOptionPane.INFORMATION_MESSAGE);
	
				  btn_rRemover.setEnabled(false);
				  tF_Remover_conta.setText("");
					 
			  	}


			//relatório
		
			  if (evt.getSource()== btn_relatorio_Listar)
			  {
				TA_TabelaContas.setEnabled(true);
				tds_contas = gerenciador.obter_tabela();
				TA_TabelaContas.setText("  Conta	Cliente	Saldo\n");
				TA_TabelaContas.setFont(new Font("Monospaced", Font.PLAIN+Font.BOLD + Font.ITALIC, 20));
				 
				 while(tds_contas.hasMoreElements()) 
				  {		
				       conta_existente = (Conta) tds_contas.nextElement();
				       if (conta_existente.getConta() !=null)
				    	   n="1";
				       else
				    	   n="0";
				  }
				 
				tds_contas = gerenciador.obter_tabela();
				if (n=="1")
				 {
					 while(tds_contas.hasMoreElements()) 
					  {		
					       conta_existente = (Conta) tds_contas.nextElement();
					       TA_TabelaContas.setFont(new Font("Times", Font.PLAIN, 15));
					       TA_TabelaContas.append("   "+conta_existente.getConta());
					       TA_TabelaContas.append("	"+conta_existente.getNome());
					       TA_TabelaContas.append("	R$"+conta_existente.getSaldo_inicial());
					       TA_TabelaContas.append("	\n");
					       }
					 JOptionPane.showMessageDialog(null,"Dados Encontrados!!","Sucesso!", JOptionPane.INFORMATION_MESSAGE);
					 
				 }

				   else
				    	   JOptionPane.showMessageDialog(null,"Não há contas cadastradas!!","Erro!", JOptionPane.INFORMATION_MESSAGE);
			  }}		
				
		
			catch(RuntimeException e)
			{
		    	JOptionPane.showMessageDialog(null,"Caught Runtime Exception " +e+"\n Campos vazios ou dados inválidos!! ","Erro!",JOptionPane.WARNING_MESSAGE);
		    	tF_Nome.setText("");
				tf_saldo.setText("");
				tF_Conta.setText("");
				pF_senha.setText("");
				tF_movimentar_conta.setText("");
				tf_movimentar_valor.setText("");
				tF_Remover_conta.setText("");
				TA_TabelaContas.setText("");
				tf_movimentar_valor.setText("");
    			btn_movimentar_Sacar.setEnabled(false);
				btn_movimentar_Depositar.setEnabled(false);
				tf_movimentar_valor.setEnabled(false);
				lblValor.setEnabled(false);
				btn_movimentar_Sacar.setEnabled(false);
				btn_movimentar_Depositar.setEnabled(false);
				tf_movimentar_valor.setEnabled(false);
				lblValor.setEnabled(false);
				tf_movimentar_valor.setText("");
				tF_movimentar_conta.setText("");
				
				
		      }

		
}}}