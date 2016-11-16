package dao.oracle;

import dao.DAOFactory;
import dao.interfaces.AdventurerDAO;
import dao.interfaces.EntityDAO;
import dao.interfaces.ItemDAO;
import dao.interfaces.LordDAO;
import dao.oracle.dao.OracleAdventurerDAO;

import java.sql.Connection;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class OracleDAOFactory extends DAOFactory{

    @Override
    public AdventurerDAO getAdventurerDAO() {
        return new OracleAdventurerDAO();
    }

    @Override
    public ItemDAO getItemDAO() {
        return null;
    }

    @Override
    public EntityDAO getEntityDAO() {
        return null;
    }

    @Override
    public LordDAO getLordDAO() {
        return null;
    }

    @Override
    public Connection createConnection() {
        return null;
    }
}
