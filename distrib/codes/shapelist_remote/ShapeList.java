import java.rmi.*;
import java.util.Vector;

public interface ShapeList extends Remote {
  void newShape(GraphicalObject g) throws RemoteException;  	    
  Vector allShapes() throws RemoteException;
}
