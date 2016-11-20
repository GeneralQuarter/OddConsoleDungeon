package ocd.dao.interfaces;

import ocd.dao.entities.Adventurer;
import ocd.dao.entities.Item;

import java.util.List;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public interface ItemDAO {

    List<Item> consultShop(Adventurer adventurer);
    List<Item> consultLoot(Adventurer adventurer);

}
