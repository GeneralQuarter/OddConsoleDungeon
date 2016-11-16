package dao.oracle.dao;

import dao.interfaces.InventoryDAO;
import model.Entity;
import model.Inventory;
import model.Item;

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
