import javax.swing.JOptionPane;

public class MagazineImp {
    public static void main(String[] args) {

        double total = 0;

        Magazine m1 = new Magazine("Sport Illustrated ", 15);
        total += m1.getCost();
        JOptionPane.showMessageDialog(null, m1.toString());

        Magazine m2 = new Magazine("Animals", 20, 5);
        total += m2.getCost();
        JOptionPane.showMessageDialog(null, m2.toString());

        Magazine m3 = new Magazine();

        // get title from user input and set it
        try {
            String title = JOptionPane.showInputDialog("Enter the tile");
            m3.setTitle(title);
        } catch (IllegalArgumentException er) {
            JOptionPane.showMessageDialog(null, er.getMessage());
        }

        // get user input from price and set it
        try {
            double cost = Double.parseDouble(JOptionPane.showInputDialog("Enter the cost"));
            m3.setCost(cost);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "the cost must be a number");
        } catch (IllegalArgumentException er) {
            JOptionPane.showMessageDialog(null, er.getMessage());
        }
    
        // get user input from stock and set it
        try {
            int numInStock = Integer.parseInt(JOptionPane.showInputDialog("Enter the Number of stocks"));
            m3.setNumInStock(numInStock);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "the stock must be a number");
        } catch (IllegalArgumentException er) {
            JOptionPane.showMessageDialog(null, er.getMessage());
        }
        total += m3.getCost();
        JOptionPane.showMessageDialog(null, m3.toString());
        JOptionPane.showMessageDialog(null, "The avarage cost over all the magazine $ " + (total / 3));

    }

}
