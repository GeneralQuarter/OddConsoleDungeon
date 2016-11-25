package ocd.dao.entities;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class Item {
    private int itemID;
    private int typeID;
    private String itemName;
    private String typeName;
    private double price;
    private double roomsToEquip;
    private int bonusHealth;
    private int bonusDefense;
    private int bonusAttack;
    private int bonusCritical;

    public Item(int itemID, int typeID, String itemName, String typeName, double price, double roomsToEquip, int bonusHealth, int bonusDefense, int bonusAttack, int bonusCritical) {
        this.itemID = itemID;
        this.typeID = typeID;
        this.itemName = itemName;
        this.typeName = typeName;
        this.price = price;
        this.roomsToEquip = roomsToEquip;
        this.bonusHealth = bonusHealth;
        this.bonusDefense = bonusDefense;
        this.bonusAttack = bonusAttack;
        this.bonusCritical = bonusCritical;
    }

    public int getItemID() {
        return itemID;
    }

    public int getTypeID() {
        return typeID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getTypeName() {
        return typeName;
    }

    public double getPrice() {
        return price;
    }

    public double getRoomsToEquip() {
        return roomsToEquip;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }

    public int getBonusDefense() {
        return bonusDefense;
    }

    public int getBonusAttack() {
        return bonusAttack;
    }

    public int getBonusCritical() {
        return bonusCritical;
    }

    public String toString() {
        String firstPart = "@|magenta,bold " + getItemID() + ":|@ " +
                "@|cyan,bold " + getItemName() + "|@ " +
                "(" + getTypeName() + ")" +
                "[@|green,bold " + getRoomsToEquip() + "|@]: ";
        String secondPart = "@|yellow,bold $" + getPrice() + "|@ " +
                "bonuses: (health = @|green,bold " + getBonusHealth() + "%|@, " +
                "defense = @|green,bold " + getBonusDefense() + "%|@, " +
                "attack = @|green,bold " + getBonusAttack() + "%|@, " +
                "critical = @|green,bold " + getBonusCritical() + "%|@)";
        String format = "%-100s %-200s%n";
        return String.format(format, firstPart, secondPart);

    }
}
