import java.text.DecimalFormat;

public abstract class WasteItem
{
    private String userID;
    private String userName;
    private String itemName;
    private double weight;

    protected static DecimalFormat df = new DecimalFormat("0.00");

    // constructor
    public WasteItem(String userID, String userName, String itemName, double weight)
    {
        this.userID = userID;
        this.userName = userName;
        this.itemName = itemName;
        this.weight = weight;
    }

    // setter methods (ENCAPSULATION)
    public void setUserID(String userID) { this.userID = userID; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setWeight(double weight) { this.weight = weight; }

    // getter methods (ENCAPSULATION)
    public String getUserID() { return userID; }
    public String getUserName() { return userName; }
    public String getItemName() { return itemName; }
    public double getWeight() { return weight; }

    // abstract methods - every subclass MUST provide its own version (ABSTRACTION)
    public abstract double determinePrice();
    public abstract String getCategory();

     public String toString()
    {
        return String.format("%-12s%-15s%-15s%-12s%-12.2f%-10s",
                userID, userName, itemName, getCategory(), weight, df.format(determinePrice()));
    }
}