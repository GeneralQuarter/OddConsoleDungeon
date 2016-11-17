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
    private static String connectionUrl;
    private static String username;
    private static String password;
    private static Connection con;

    public OracleDAOFactory() {
        OCDProperties ocdProp = new OCDProperties();
        connectionUrl = ocdProp.getProperty("connection");
        username = ocdProp.getProperty("username");
        password = ocdProp.getProperty("password");
        con = getConnection();
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

    @Override
    public void actionsOnClose() {
        closeConnection();
    }

    public static Connection getConnection() {
        if(con == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@" + connectionUrl, username, password);
                return con;
            } catch (ClassNotFoundException e) {
                System.err.println("Where is your Oracle JDBC Driver?");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Connection Failed! Check output console");
                e.printStackTrace();
            }
            return null;
        } else {
            return con;
        }
    }

    public static void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing the connection");
            e.printStackTrace();
        }
    }
}
