import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {
  public void paintComponent(Graphics g){
    g.drawString("€ ", 5, 15);
    g.drawString(" => $    ", 35, 15);
  }
}
