package dao.interfaces;

import model.Entity;
import model.Inventory;
import model.Item;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public interface InventoryDAO {

    Inventory getEquipment(Entity entity);
    Inventory getInventory(Entity entity);
    void moveItem(Inventory from, Inventory to, Item itemToMove);
}
