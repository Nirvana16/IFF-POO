import java.util.Enumeration;
import java.util.Hashtable;

public class Gerenciador {
	Hashtable GContas;
	
	
	Gerenciador(){
		GContas = new Hashtable();
	}
	
	void GuardaConta(Conta c){
		GContas.put( c.getNumeroConta(), c);
	}
	
	Conta RetornaConta(String numeroConta){
		Conta c;
		c = (Conta)GContas.get(numeroConta);
		return c;
	}
	
	 Enumeration RetornaTodasContas(){
		 Enumeration todasAsContas;
		 todasAsContas = GContas.elements();
		 return todasAsContas;
	}
}
