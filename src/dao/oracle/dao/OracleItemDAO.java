package dao.oracle.dao;

import dao.interfaces.ItemDAO;
import model.Adventurer;
import model.Item;

import java.util.List;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class OracleItemDAO implements ItemDAO {

    @Override
    public List<Item> consultShop(Adventurer adventurer) {
        return null;
    }

    @Override
    public List<Item> consultLoot(Adventurer adventurer) {
        return null;
    }
}
