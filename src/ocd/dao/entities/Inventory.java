package ocd.dao.entities;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class Inventory {
    private int id;
    private int slotQuantity;
    private String insertPolicy;

    public Inventory(int id, int slotQuantity, String insertPolicy) {
        this.id = id;
        this.slotQuantity = slotQuantity;
        this.insertPolicy = insertPolicy;
    }

    public int getId() {
        return id;
    }

    public int getSlotQuantity() {
        return slotQuantity;
    }

    public String getInsertPolicy() {
        return insertPolicy;
    }
}
