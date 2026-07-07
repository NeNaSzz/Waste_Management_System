
/**
 * Write a description of class GeneralWasteItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GeneralWasteItem extends WasteItem
{
    public GeneralWasteItem(String userID, String userName, String itemName, double weight)
    {
        super(userID, userName, itemName, weight);
    }

    // overriding the abstract 
    public double determinePrice()
    {
        return getWeight() * 0.5;
    }

    public String getCategory()
    {
        return "General";
    }
}