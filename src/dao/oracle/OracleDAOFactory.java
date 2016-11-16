package dao.oracle;

import dao.DAOFactory;
import dao.interfaces.*;
import dao.oracle.dao.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class OracleDAOFactory extends DAOFactory{
    public static String connectionUrl;
    public static String username;
    public static String password;

    public OracleDAOFactory(String connectionUrl, String username, String password) {
        OracleDAOFactory.connectionUrl = connectionUrl;
        OracleDAOFactory.username = username;
        OracleDAOFactory.password = password;
    }

    @Override
    public AdventurerDAO getAdventurerDAO() {
        return new OracleAdventurerDAO();
    }

    @Override
    public ItemDAO getItemDAO() {
        return new OracleItemDAO();
    }

    @Override
    public EntityDAO getEntityDAO() {
        return new OracleEntityDAO();
    }

    @Override
    public LordDAO getLordDAO() {
        return new OracleLordDAO();
    }

    @Override
    public InventoryDAO getInventoryDAO() {
        return new OracleInventoryDAO();
    }

    @Override
    public MonsterDAO getMonsterDAO() {
        return new OracleMonsterDAO();
    }

    public static Connection createConnection() {
        Connection con;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@" + OracleDAOFactory.connectionUrl, OracleDAOFactory.username, OracleDAOFactory.password);
            return con;
        } catch (ClassNotFoundException e) {
            System.err.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
        } catch(SQLException e) {
            System.err.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return null;
    }
}
