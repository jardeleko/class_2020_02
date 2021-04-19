import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.Scanner;

public class ShapeListClient {
  public static void main(String args[]) {
    try {
      ShapeList aShapeList = (ShapeList) Naming.lookup("//68.183.118.94/ShapeList");
      System.out.println("Servidor encontrado");

      Scanner s = new Scanner(System.in);

      while (true) {
        System.out.print("Digite a opcao: ");
        String option = s.nextLine();

        if (option.equals("lista")){
          Vector shapes = aShapeList.allShapes();

          for(int i = 0; i < shapes.size(); i++){
            GraphicalObject g = (GraphicalObject) shapes.elementAt(i);
            g.print();
          }
        }
        else if (option.equals("adiciona")) {
          System.out.print("Digite o tipo do shape: ");
          String shapeType = s.nextLine();

          GraphicalObject g = new GraphicalObject(shapeType,
              new Rectangle(50 ,50 ,300 ,400), Color.red, Color.blue, false);
          System.out.println("Objeto grafico criado");

          aShapeList.newShape(g);
          System.out.println("Shape armazenado");
        }
        else if (option.equals("encerra")) {
          break;
        }
        else {
          throw new IllegalArgumentException("Opcao invalida!");
        }
      }

      s.close();
    }
    catch(RemoteException e) {
      System.out.println("allShapes: " + e.getMessage());
    }
    catch(Exception e) {
      System.out.println("Exception: " + e.getMessage());
    }
  }
}
