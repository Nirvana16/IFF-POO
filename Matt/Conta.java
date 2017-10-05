public class Conta
{

	String nome, numConta; 
	float saldo;
	
	Conta(String n, String nC )
	{
		saldo = 0;
		nome = n;
		numConta = nC;
	}
	Conta()
	{
		
	}
	
	float verSaldo()
	{
		return saldo;
	}
		
	void sacar( float valor )
	{
		saldo = saldo - valor;
	}
	
	void depositar( float valor )
	{
		saldo = saldo + valor;
	}


	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getNumeroConta() 
	{
		return numConta;
	}

	public void setNumeroConta(String numConta) 
	{
		this.numConta = numConta;
	}
	
	
}