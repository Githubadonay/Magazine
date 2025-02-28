public class Magazine {
    // instance variables
    private String title;
    private double cost;
    private int numInStock;
    // static varible 
    private static int numOfMagazine;

    // Constructors
    // makes the code flexible
    Magazine() {
        this.title = "";
        this.cost = 0;
        this.numInStock = 0;
        numOfMagazine++;
    }

    Magazine(String title, double cost) {
        this.title = title;
        this.cost = cost;
        numOfMagazine++;
    }

    Magazine(String title, double cost, int numInStock) {
        this.title = title;
        this.cost = cost;
        this.numInStock = numInStock;
    }

    // Accessors
    public String getTitle() {
        return this.title;
    }

    public double getCost() {
        return this.cost;
    }

    public int getNumInStco() {
        return this.numInStock;
    }
    public static int getNumOfMagazine(){
        return numOfMagazine;
    }

    // Mutator

    public void setTitle(String title) {
        if (!title.equals(""))
            this.title = title;
        else
            throw new IllegalArgumentException("the magazine title can not be empty");
    }

    public void setCost(double cost) {
        if (cost > 0)
            this.cost = cost;
        else
            throw new IllegalArgumentException("the price can't be negative");
    }

    public void setNumInStock(int numInStock) {
        if (numInStock > 0)
            this.numInStock = numInStock;
        else
            throw new IllegalArgumentException("The Stock can't be negative");
    }

    public static void updateNumOfMagazine(){
        numOfMagazine--;
    }

    // toString Method
    public String toString() {
        return "Title " + this.getTitle() +
                "\n" + "Cost " + this.getCost() +
                "\n" + "Stock " + this.getNumInStco();
    }

}