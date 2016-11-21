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

    boolean buyItem(Adventurer adventurer, int itemID);
    boolean sellItem(Adventurer adventurer, int itemID);
    void nextFight(Adventurer adventurer);
    void flee(Adventurer adventurer);
    List<Adventurer> getAdventurersOfLord(Lord lord);
    Adventurer createAdventurer(Lord lord, String name);
    Adventurer find(int id);

}
