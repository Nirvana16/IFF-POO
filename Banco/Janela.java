import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class Janela extends JFrame
{
	JTabbedPane abas;
	JPanel painel1, painel2, painel3, painel4, painel5;
	JLabel lCliente, lConta, lSaque, lDeposito, lListaContas;
	JTextField tCliente;
	JButton bCliente;
	
	Janela()
	{
		this.setSize(600,400);
		this.setTitle("Banco do Campista");
		this.setResizable(false);//tamanho é fixo por causa do false
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		abas = new JTabbedPane();
		abas.setSize(550,400);
		abas.setLocation(0,10);
		
		painel1 = new JPanel();
		painel1.setLayout(null);
		
		painel2 = new JPanel();
		painel2.setLayout(null);
		
		painel3 = new JPanel();
		painel3.setLayout(null);
		
		painel4 = new JPanel();
		painel4.setLayout(null);
		
		painel5 = new JPanel();
		painel5.setLayout(null);
		
		
		lCliente = new JLabel("Cliente");
		lCliente.setSize(100,30);
		lCliente.setLocation(10,30);		
		painel1.add(lCliente);
		
		lConta = new JLabel("Conta");
		lConta.setSize(100,30);
		lConta.setLocation(20,30);		
		painel2.add(lConta);
		
		lSaque = new JLabel("Saque");
		lSaque.setSize(100,30);
		lSaque.setLocation(20,30);		
		painel3.add(lSaque);
		
		lDeposito = new JLabel("Deposito");
		lDeposito.setSize(100,30);
		lDeposito.setLocation(20,30);
		painel4.add(lDeposito);
		
		lListaContas = new JLabel("Listar Contas");
		lListaContas.setSize(100,30);
		lListaContas.setLocation(20,30);
		painel5.add(lListaContas);
		
		abas.addTab("Cadastrar Cliente", painel1);
		abas.addTab("Cadastrar Conta", painel2);
		abas.addTab("Sacar", painel3);
		abas.addTab("Depositar", painel4);
		abas.addTab("Listar Contas", painel5);
		
		this.add(abas);		
		
		this.show();
	}
}
