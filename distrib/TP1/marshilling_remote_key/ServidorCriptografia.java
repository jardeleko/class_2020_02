//import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;

public class ServidorCriptografia{
	public ServidorCriptografia(){
		try{
			Criptografia obj = new CriptografiaImpl();
			Naming.rebind("//localhost/criptoService", obj);
		}
		catch (Exception e){
			System.out.println("Erro: "+e);
		}
	}

	public static void main(String[] args){
		new ServidorCriptografia();
	}
}
