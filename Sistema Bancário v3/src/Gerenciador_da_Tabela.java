import java.util.Enumeration;
import java.util.Hashtable;
public class Gerenciador_da_Tabela {
	Hashtable<String, Conta> tabela_contas = new Hashtable<String, Conta>();
	//Enumeration contas;
	String str, key;
	
	
  public void add_contas(Conta conta_nova)
  {
	  key = conta_nova.getConta(); 
	  tabela_contas.put(key, conta_nova);
  
  }
  
  public void remover_contas(String numero_conta)
  {
	 tabela_contas.remove(numero_conta);
  }
  
  public Conta buscar_contas(String numero_conta)
  {
	  return (Conta) tabela_contas.get(numero_conta);
  }
  
  Enumeration obter_tabela()
  {  
	   return tabela_contas.elements();  
	
  }
  
  
}


