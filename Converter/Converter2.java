import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.NumberFormat;
import java.util.Locale;

public class Converter2 extends JFrame{

  private double taux = 1;
  private Boolean eur = true;

  public Converter2(){
    NumberFormat format = NumberFormat.getInstance();//On n'affiche que 2 chiffres après la virgule
    format.setMaximumFractionDigits(2);

    this.setTitle("Convertisseur");
    this.setSize(300, 170);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new GridLayout(3, 1));
    this.setResizable(false);


    JPanel haut = new JPanel();
    JPanel milieu = new JPanel();
    JPanel bas = new JPanel();



    JTextField textField = new JTextField("",40);
    JTextField textField2 = new JTextField("",40);
		textField.setColumns(10); //On lui donne un nombre de colonnes à afficher
    textField2.setColumns(10);


    textField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        textField2.setText(""+format.format(taux*(Double.parseDouble(textField.getText()))));
        eur = true;
      }
    });

    textField2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        textField.setText(""+format.format((1/taux)*(Double.parseDouble(textField2.getText()))));
        eur = false;
      }
    });


    haut.setLayout(new GridLayout(2, 3));
		haut.add(textField);
    haut.add(new Panneau€$());
    haut.add(textField2);
    haut.add(new PanneauVide());haut.add(new PanneauVide());haut.add(new PanneauVide());


    JTextField textField3 = new JTextField(""+taux,40);
    textField3.setColumns(10);


    textField3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setTaux(Double.parseDouble(textField3.getText()));
        if (eur)
          textField2.setText(""+format.format(taux*(Double.parseDouble(textField.getText()))));
        else
          textField.setText(""+format.format((1/taux)*(Double.parseDouble(textField2.getText()))));
      }
    });

    milieu.setLayout(new GridLayout(2, 3));

    milieu.add(new Panneau3());
    milieu.add(textField3);
    milieu.add(new Panneau2());
    milieu.add(new PanneauVide());milieu.add(new PanneauVide());milieu.add(new PanneauVide());



    /*JButton boutonQuitter = new JButton("Quitter");
    //Définition de l'action du bouton2
    boutonQuitter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        System.exit(0);
      }
    });*/

    JButton boutonQuitter = new JButton("Quitter");

      boutonQuitter.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            System.exit(0);
         }
      });

    bas.setLayout(new GridLayout(1, 1));
    bas.add(boutonQuitter);

    this.add(haut);
    this.add(milieu);
    this.add(bas);
    this.setVisible(true);
  }




  public JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JTextField textField = new JTextField();
		textField.setColumns(10); //On lui donne un nombre de colonnes à afficher

		panel.add(textField);

		return panel;
	}


  public double toDollars(double s) {
    return s*taux;
  }

  public double toEuros(double s) {
    return s/taux;
  }

  public void setTaux(double t) {
    taux = t;

  }









  public static void main(String[] args) {
    Converter2 c = new Converter2();
    double d = 1.0;
    //c.setTaux(1.15);
    System.out.println("1€ = " + c.toDollars(d)+" $");
    System.out.println("1$ = " + c.toEuros(d)+" €");
  }


}
