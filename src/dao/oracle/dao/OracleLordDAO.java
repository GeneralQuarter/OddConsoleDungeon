package dao.oracle.dao;

import dao.interfaces.LordDAO;
import model.Adventurer;
import model.Lord;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class OracleLordDAO implements LordDAO{

    @Override
    public void createLord(String login, String pass1, String pass2) {

    }

    @Override
    public Lord connectUser(String login, String password) {
        return null;
    }

    @Override
    public void switchAdventurer(Lord lord, Adventurer adventurer) {

    }
}
