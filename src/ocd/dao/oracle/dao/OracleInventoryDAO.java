package ocd.dao.oracle.dao;

import ocd.dao.interfaces.InventoryDAO;
import ocd.dao.entities.Entity;
import ocd.dao.entities.Inventory;
import ocd.dao.entities.Item;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class OracleInventoryDAO implements InventoryDAO{

    @Override
    public Inventory getEquipment(Entity entity) {
        return null;
    }

    @Override
    public Inventory getInventory(Entity entity) {
        return null;
    }

    @Override
    public void moveItem(Inventory from, Inventory to, Item itemToMove) {

    }
}
