package dao.interfaces;

import model.Adventurer;
import model.Item;

import java.util.List;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public interface ItemDAO {

    List<Item> consultShop(Adventurer adventurer);
    List<Item> consultLoot(Adventurer adventurer);

}
