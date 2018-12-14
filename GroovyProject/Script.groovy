import test.IHello;
import java.awt.Dimension;
import javax.swing.JFrame;
 
public class Hello extends JFrame implements IHello {
	public void tela() {
		this.setTitle("Groovy Frame!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(new Dimension(400, 400));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
   public void ola(){
      System.out.println("Ola Mundo Java!");
   }
}
