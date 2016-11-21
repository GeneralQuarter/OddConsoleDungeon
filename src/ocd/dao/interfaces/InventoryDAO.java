package ocd.dao.interfaces;

import ocd.dao.entities.Entity;
import ocd.dao.entities.Inventory;
import ocd.dao.entities.Item;

import java.util.List;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public interface InventoryDAO {

    List<Item> getEquipment(Entity entity);
    List<Item> getInventory(Entity entity);
    boolean equipItem(Entity entity, int itemID);
    boolean unequipItem(Entity entity, int itemID);
    boolean dropItem(Entity entity, int itemID);
    boolean moveItem(int inventoryIDFrom, int inventoryIDTo, int itemID);
}
