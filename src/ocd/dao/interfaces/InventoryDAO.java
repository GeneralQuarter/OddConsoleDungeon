package ocd.dao.interfaces;

import ocd.dao.entities.Entity;
import ocd.dao.entities.Inventory;
import ocd.dao.entities.Item;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public interface InventoryDAO {

    Inventory getEquipment(Entity entity);
    Inventory getInventory(Entity entity);
    void moveItem(Inventory from, Inventory to, Item itemToMove);
}
