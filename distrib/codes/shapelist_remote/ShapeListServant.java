import java.rmi.RemoteException;
import java.util.Vector;

public class ShapeListServant implements ShapeList {
  private Vector theList;

  public ShapeListServant () throws RemoteException {
    theList = new Vector();
  }

  public void newShape(GraphicalObject g) throws RemoteException {
    theList.addElement(g);
  }

  public Vector allShapes() throws RemoteException {
    return theList;
  }
}
