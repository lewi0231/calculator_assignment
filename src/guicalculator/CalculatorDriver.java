package guicalculator;


import javax.swing.*;

/*
 * Driver Class for the Calculator
 *
 * @author 
 */
public class CalculatorDriver {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      try {
         for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())){
               UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
         e.printStackTrace();
      }

      JFrame frame = new JFrame("Simple Calculator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      CalculatorPanel panel = new CalculatorPanel();
      frame.getContentPane().add(panel);
   
      frame.pack();
      frame.setResizable(false);
      frame.setLocation(800, 300);
      frame.setVisible(true);
   }
}
