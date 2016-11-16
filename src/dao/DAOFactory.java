package dao;

import dao.interfaces.AdventurerDAO;
import dao.interfaces.EntityDAO;
import dao.interfaces.ItemDAO;
import dao.interfaces.LordDAO;

import java.sql.Connection;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public abstract class DAOFactory {
    public static final int ORACLE = 1;

    public abstract AdventurerDAO getAdventurerDAO();
    public abstract ItemDAO getItemDAO();
    public abstract EntityDAO getEntityDAO();
    public abstract LordDAO getLordDAO();

    public abstract Connection createConnection();
}
