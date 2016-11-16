package dao.interfaces;

import model.Adventurer;
import model.Lord;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public interface LordDAO {

    void createLord(String login, String pass1, String pass2);
    Lord connectUser(String login, String password);
    Adventurer getCurrentAdventurer(Lord lord);
    void switchAdventurer(Lord lord, Adventurer adventurer);
}
