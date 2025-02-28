
//import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

public class MagazineImp {
    public static void main(String[] args) {
        final int maxNumOfMagazine = 100;

        // define the array og magazine
        Magazine[] allMagazine = new Magazine[maxNumOfMagazine];// create the array of magazine
        int choice = 0;

        // create the menu using a switch case

        do {
            choice = Integer.parseInt(JOptionPane.showInputDialog(
                    "Enter on of the following choice\n1.Add Magazine\n2.Search Magazine\n3.Print All Magazine\n4.Delete magazine\n5.Exit Magazine"));
            switch (choice) {
                case 1:
                    allMagazine[Magazine.getNumOfMagazine()] = createMagazine();
                    break;
                case 2:
                    String searchkey = JOptionPane.showInputDialog("Enter the magazine title you are looking for ");
                    int found = searchMagazine(allMagazine, searchkey);
                    if (found > -1)
                        JOptionPane.showMessageDialog(null, "The magazine found " + allMagazine[found].toString());
                    else
                        JOptionPane.showMessageDialog(null, "The magazine not found");
                    break;
                case 3:
                    printMagazine(allMagazine);
                    break;
                case 4:
                    removeMagazine(allMagazine);
                    break;
                case 5:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Incorrect choice! Try again");
            }

        } while (choice >= 1 && choice <= 5);
        printMagazine(allMagazine);
    } // main method

    // remove magazine method
    public static void removeMagazine(Magazine[] allMagazines) {
        printMagazine(allMagazines);
        String magazineToRemove = JOptionPane.showInputDialog("Enter the magazine title to delate");
        int index = searchMagazine(allMagazines, magazineToRemove);
        if (index > -1) {
            for (int i = index; i < Magazine.getNumOfMagazine(); i++) {
                allMagazines[i] = allMagazines[i + 1];
            }
            allMagazines[Magazine.getNumOfMagazine()] = null;
            Magazine.updateNumOfMagazine();
        } else {
            JOptionPane.showMessageDialog(null, "Error! No magazine found");
        }
    }

    // search a magazine
    public static int searchMagazine(Magazine[] allMagazine, String title) {
        int searchIndex = -1;
        for (int i = 0; i < Magazine.getNumOfMagazine(); i++) {
            if ((allMagazine[i].getTitle()).equalsIgnoreCase(title)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    // create a magazine and return it.
    public static Magazine createMagazine() {
        // get user inputs and set it for the title
        Magazine aMagazine = new Magazine();
        try {
            String title = JOptionPane.showInputDialog("Enter the magazine title");
            aMagazine.setTitle(title);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        // get the user input for cost and set it
        try {
            double cost = Double.parseDouble(JOptionPane.showInputDialog("Enter the the price of the magazine"));
            aMagazine.setCost(cost);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error! cost must be a number");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        // get the user input for stock and set it.

        try {
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Enter the the stock of the magazine"));
            aMagazine.setCost(stock);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error! stock must be a number");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return aMagazine;

    }// end of create magazine

    public static void printMagazine(Magazine[] allMagazine) {
        double totalCost = 0;
        int numOfMagazine = Magazine.getNumOfMagazine();
        String output = "XYZ BookStore\nMagazine Title | MagazineCost | Magazine Stock\n";
        for (int i = 0; i < Magazine.getNumOfMagazine(); i++) {
            totalCost += allMagazine[i].getCost();
            output += allMagazine[i].toString() + "\n";
        }

        output += "The total number of Magazine " + Magazine.getNumOfMagazine();
        output += "The average cost of the magazines " + (totalCost / numOfMagazine);
        JOptionPane.showMessageDialog(null, output);
    }

}// end class

// for (int i = 0; i < numOfMagazine; i++) {