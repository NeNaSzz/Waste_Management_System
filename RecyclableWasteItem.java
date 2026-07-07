
/**
 * Write a description of class RecyclableWasteItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecyclableWasteItem extends WasteItem
{
    public RecyclableWasteItem(String userID, String userName, String itemName, double weight)
    {
        super(userID, userName, itemName, weight);
    }

    // overriding the abstract 
    public double determinePrice()
    {
        return getWeight() * 1.00;
    }

    @Override
    public String getCategory()
    {
        return "Recyclable";
    }
}