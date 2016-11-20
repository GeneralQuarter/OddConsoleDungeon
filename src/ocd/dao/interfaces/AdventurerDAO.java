package ocd.dao.interfaces;

import ocd.dao.entities.Adventurer;
import ocd.dao.entities.Item;
import ocd.dao.entities.Lord;

import java.util.List;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public interface AdventurerDAO {

    void buyItem(Adventurer adventurer, Item item);
    void sellItem(Adventurer adventurer, Item item);
    void nextFight(Adventurer adventurer);
    void flee(Adventurer adventurer);
    List<Adventurer> getAdventurersOfLord(Lord lord);
    Adventurer createAdventurer(Lord lord, String name);
    Adventurer find(int id);

}
