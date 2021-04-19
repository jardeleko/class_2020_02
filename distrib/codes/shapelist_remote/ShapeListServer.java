import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class ShapeListServer {
  public static void main(String args[]){
    try {
      ShapeList aShapeList = new ShapeListServant();
      ShapeList stub =
        (ShapeList) UnicastRemoteObject.exportObject(aShapeList, 0);

      Registry r = LocateRegistry.createRegistry(1099);
      r.rebind("ShapeList", aShapeList);
      System.out.println("Servidor ShapeList pronto");
    }
    catch(Exception e) {
      System.out.println("ShapeList server main " + e.getMessage());
    }
  }
}
