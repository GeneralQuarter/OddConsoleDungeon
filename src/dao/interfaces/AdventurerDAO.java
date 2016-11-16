package dao.interfaces;

import model.Adventurer;
import model.Item;
import model.Lord;

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
    List<Adventurer> getAdventurerOfLord(Lord lord);
    Adventurer createAdventurer(Lord lord, String name);
    Adventurer getCurrentAdventurer(Lord lord);

}
