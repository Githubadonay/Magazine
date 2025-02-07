import javax.swing.JOptionPane;

public class MagazineImp {
    public static void main(String[] args) {
        
        Magazine m1 = new Magazine("Sport Illustrated ", 15);
        JOptionPane.showMessageDialog(null,  m1.toString());

        Magazine m2 = new Magazine("Animals", 20, 5);
        JOptionPane.showMessageDialog(null,  m2.toString());
        
        Magazine m3 = new Magazine();
        String  title = JOptionPane.showInputDialog("Enter the tile");
        double  cost = Double.parseDouble(JOptionPane.showInputDialog("Enter the cost"));
        int numInStock = Integer.parseInt(JOptionPane.showInputDialog("Enter the Number of stocks"));

        m3.setTitle(title);
        m3.setCost(cost);
        m3.setNumInStock(numInStock);

       
        JOptionPane.showMessageDialog(null,  m3.toString());

    }
    
}
