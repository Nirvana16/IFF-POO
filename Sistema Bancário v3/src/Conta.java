import javax.swing.JOptionPane;


public class Conta {
    private String conta;
    private String nome;
    private Float saldo;
    
    
    public Conta(String numero_conta, String nome, float saldo)
    {
    	this.saldo = saldo;
    	this.nome= nome;
    	this.conta = numero_conta;
    	
    }
    
    public String getConta()
    {
        return conta;
    }
   /* public void setConta( String numero_conta )
    {
        this.conta= numero_conta ;
    }*/
 
    
    public String getNome()
    {
         return nome;
    }
    /*  public void setNome( String nome )
    {
        this.nome = nome;
    } */ 
 
   
    public Float getSaldo_inicial()
    {
         return saldo;
    }
    /* public void setSaldo_inicial(String saldo_inicial)
    {
        this.saldo = saldo; 
        }*/ 

    
    public void depositar(float valor_desejado)
    	{
		saldo = saldo + valor_desejado;
		JOptionPane.showMessageDialog(null, "Seu novo Saldo eh: R$"+saldo,"Sucesso!",JOptionPane.INFORMATION_MESSAGE);
    	}
    
    public void sacar(float valor_desejado){
		
		if (( valor_desejado>0) && (valor_desejado<saldo))
			{
			saldo = saldo - valor_desejado;
			JOptionPane.showMessageDialog(null, "Seu novo Saldo eh: R$"+saldo,"Sucesso!",JOptionPane.INFORMATION_MESSAGE);
			}
		else
			JOptionPane.showMessageDialog(null, "Saldo Insuficiente","Erro",JOptionPane.INFORMATION_MESSAGE);
		}
	
	
   
}
