import javax.swing.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class ClienteCriptografia{
	public static void main(String[] args){
		String resp = "";
		String tmp;
		int op = JOptionPane.showConfirmDialog(null, "Sim = Criptografia" + 
			"\nNão = Descriptografia", "Escolha uma opção", 0);

		try{
			Criptografia cripto = (Criptografia) Naming.lookup("//localhost/" +
			 "criptoService");
			if(op == 0){
				tmp = JOptionPane.showInputDialog("Entre com o TEXTO. Sem acento");
				resp = cripto.criptografar(tmp);
			}
			else {
				tmp = JOptionPane.showInputDialog("Entre com o TEXTO. sem acento");
				resp = cripto.descriptografar(tmp);
			}	
		} 
		catch(MalformedURLException murle){
			System.out.println();
			System.out.println("MalformedURLException");
			System.out.println(murle);
		}
		catch(RemoteException re){
			System.out.println();
			System.out.println("RemoteException");
			System.out.println(re);
		}
		catch(NotBoundException nbe){
			System.out.println();
			System.out.println("NotBoundException");
			System.out.println(nbe);
		}
		catch(java.lang.ArithmeticException ae){
			System.out.println();
			System.out.println("java.lang.ArithmeticException");
			System.out.println(ae);
		}
		catch(java.lang.StringIndexOutOfBoundsException str){
			System.out.println();
			System.out.println("java.lang.StringIndexOutOfBoundsException");
			System.out.println(str);
		}
		catch(java.lang.ArrayIndexOutOfBoundsException arr){
			System.out.println();
			System.out.println("java.lang.ArrayIndexOutOfBoundsException");
			System.out.println(arr);
		}

		JTextArea outputArea = new JTextArea();
		outputArea.setText(resp);
		JOptionPane.showMessageDialog(null, outputArea, "Texto Criptografado", JOptionPane.INFORMATION_MESSAGE);
	}
}