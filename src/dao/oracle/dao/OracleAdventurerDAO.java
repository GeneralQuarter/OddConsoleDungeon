package dao.oracle.dao;

import dao.interfaces.AdventurerDAO;
import dao.oracle.OracleDAOFactory;
import model.Adventurer;
import model.Item;
import model.Lord;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class OracleAdventurerDAO implements AdventurerDAO {
    private Connection con;

    public OracleAdventurerDAO() {
        con = OracleDAOFactory.getConnection();
    }

    private void closeStatement(Statement stm) {
        try {
            if(stm != null) {
                stm.close();
            }
        } catch (SQLException e) {
            System.err.println("Failed closing statement");
            e.printStackTrace();
        }
    }

    private void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println("Failed closing resultSet");
            e.printStackTrace();
        }
    }

    @Override
    public void buyItem(Adventurer adventurer, Item item) {
        CallableStatement stm = null;
        try {
            stm = con.prepareCall("{call buyItem(?, ?)}");
            stm.setInt(1, adventurer.getId());
            stm.setInt(2, item.getItemID());
            stm.execute();
        } catch (SQLException e) {
            System.err.println("Error calling buyItem");
            e.printStackTrace();
        } finally {
            closeStatement(stm);
        }
    }

    @Override
    public void sellItem(Adventurer adventurer, Item item) {
        CallableStatement stm = null;
        try {
            stm = con.prepareCall("{call sellItem(?, ?)}");
            stm.setInt(1, adventurer.getId());
            stm.setInt(2, item.getItemID());
            stm.execute();
        } catch (SQLException e) {
            System.err.println("Error calling sellItem");
            e.printStackTrace();
        } finally {
            closeStatement(stm);
        }
    }

    @Override
    public void nextFight(Adventurer adventurer) {
        CallableStatement stm = null;
        try {
            stm = con.prepareCall("{call nextFight(?)}");
            stm.setInt(1, adventurer.getId());
            stm.execute();
        } catch (SQLException e) {
            System.err.println("Error calling nextFight");
            e.printStackTrace();
        } finally {
            closeStatement(stm);
        }
    }

    @Override
    public void flee(Adventurer adventurer) {
        CallableStatement stm = null;
        try {
            stm = con.prepareCall("{call flee(?)}");
            stm.setInt(1, adventurer.getId());
            stm.execute();
        } catch (SQLException e) {
            System.err.println("Error calling flee");
            e.printStackTrace();
        } finally {
            closeStatement(stm);
        }
    }

    @Override
    public List<Adventurer> getAdventurersOfLord(Lord lord) {
        CallableStatement stm = null;
        ResultSet rs = null;
        List<Adventurer> results = new ArrayList<>();
        try {
            stm = con.prepareCall("{call getAdventurerOfLord(?)}");
            stm.setInt(1, lord.getId());
            boolean hasResults = stm.execute();
            while (hasResults) {
                rs = stm.getResultSet();
                while (rs.next()) {
                    results.add(new Adventurer(
                            rs.getInt("adventurerID"),
                            rs.getString("name"),
                            rs.getInt("entityID"),
                            rs.getInt("dungeonID"),
                            rs.getInt("shopID"),
                            rs.getString("status")
                    ));
                }
                hasResults = stm.getMoreResults();
            }
        } catch (SQLException e) {
            System.err.println("Error calling getAdventurerOfLord");
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeStatement(stm);
        }
        return results;
    }

    @Override
    public Adventurer createAdventurer(Lord lord, String name) {
        CallableStatement cStm = null;
        Adventurer result = null;
        try {
            cStm = con.prepareCall("{? = call createAdventurer(?, ?)}");
            cStm.registerOutParameter(1, Types.INTEGER);
            cStm.setInt(2, lord.getId());
            cStm.setString(3, name);
            cStm.execute();
            int returnId = cStm.getInt(1);
            result = find(returnId);
        } catch (SQLException e) {
            System.err.println("Error calling createAdventurer");
            e.printStackTrace();
        } finally {
            closeStatement(cStm);
        }
        return result;
    }

    @Override
    public Adventurer getCurrentAdventurer(Lord lord) {

        return null;
    }

    @Override
    public Adventurer find(int id) {
        PreparedStatement pStm = null;
        ResultSet rs = null;
        Adventurer result;
        try {
            pStm = con.prepareStatement("SELECT * FROM Adventurer WHERE adventurerID = ?");
            pStm.setInt(1, id);
            rs = pStm.executeQuery();
            if (rs.next()) {
                result = new Adventurer(
                        rs.getInt("adventurerID"),
                        rs.getString("name"),
                        rs.getInt("entityID"),
                        rs.getInt("dungeonID"),
                        rs.getInt("shopID"),
                        ""
                );
                return result;
            }
        } catch (SQLException e) {
            closeResultSet(rs);
            closeStatement(pStm);
        }
        return null;
    }
}
