package dao;

import dao.interfaces.*;

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
    public abstract InventoryDAO getInventoryDAO();
    public abstract MonsterDAO getMonsterDAO();
}
