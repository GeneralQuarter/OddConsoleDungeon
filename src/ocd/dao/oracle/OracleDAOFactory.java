package ocd.dao.oracle;

import ocd.OCDConsole;
import ocd.dao.DAOFactory;
import ocd.dao.interfaces.*;
import ocd.dao.oracle.dao.*;

import java.sql.*;

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
                OCDConsole.printlnSuccess("Successfully connected to the database!");
                return con;
            } catch (ClassNotFoundException e) {
                OCDConsole.printlnError("Where is your Oracle JDBC Driver?");
            } catch (SQLException e) {
                OCDConsole.printlnError("Connection to database failed: " + e.getMessage());
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
            OCDConsole.printlnError("Error closing the connection: " + e.getMessage());
        }
    }

    public static void closeStatement(Statement stm) {
        try {
            if(stm != null) {
                stm.close();
            }
        } catch (SQLException e) {
            OCDConsole.printlnError("Error closing statement");
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            OCDConsole.printlnError("Error closing resultSet");
        }
    }
}
