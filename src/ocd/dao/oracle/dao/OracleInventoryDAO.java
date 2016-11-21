package ocd.dao.oracle.dao;

import ocd.dao.interfaces.InventoryDAO;
import ocd.dao.entities.Entity;
import ocd.dao.entities.Inventory;
import ocd.dao.entities.Item;

import java.util.List;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class OracleInventoryDAO implements InventoryDAO{

    @Override
    public List<Item> getEquipment(Entity entity) {
        return null;
    }

    @Override
    public List<Item> getInventory(Entity entity) {
        return null;
    }

    @Override
    public void moveItem(Inventory from, Inventory to, Item itemToMove) {

    }
}
