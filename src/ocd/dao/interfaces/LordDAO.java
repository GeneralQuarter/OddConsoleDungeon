package ocd.dao.interfaces;

import ocd.dao.entities.Adventurer;
import ocd.dao.entities.Lord;


/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public interface LordDAO {

    boolean createLord(String login, String pass1, String pass2);
    Lord connectUser(String login, String password);
    boolean switchAdventurer(Lord lord, int adventurerID);
    Lord find(int lordID);
}
