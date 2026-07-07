
/**
 * Write a description of class OrganicWasteItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrganicWasteItem extends WasteItem
{
    public OrganicWasteItem(String userID, String userName, String itemName, double weight)
    {
        super(userID, userName, itemName, weight);
    }

    // overriding the abstract method (POLYMORPHISM)
    @Override
    public double determinePrice()
    {
        return getWeight() * 0.75;
    }

    @Override
    public String getCategory()
    {
        return "Organic";
    }
}
