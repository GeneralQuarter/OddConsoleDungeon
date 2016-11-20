package ocd.dao.oracle.dao;

import jdk.nashorn.internal.codegen.CompilerConstants;
import ocd.OCDConsole;
import ocd.dao.interfaces.ItemDAO;
import ocd.dao.entities.Adventurer;
import ocd.dao.entities.Item;
import ocd.dao.oracle.OracleDAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class OracleItemDAO implements ItemDAO {
    private Connection con;

    public OracleItemDAO() {
        con = OracleDAOFactory.getConnection();
    }

    @Override
    public List<Item> consultShop(Adventurer adventurer) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Item> results = new ArrayList<>();
        try {
            stm = con.prepareStatement("SELECT * FROM TABLE(consultShop(?))");
            stm.setInt(1, adventurer.getId());
            rs = stm.executeQuery();
            while (rs.next()) {
                results.add(new Item(
                        rs.getInt("itemID"),
                        rs.getInt("typeID"),
                        rs.getString("itemName"),
                        rs.getString("typeName"),
                        rs.getDouble("price"),
                        rs.getDouble("roomsToEquip"),
                        rs.getInt("bonusHealth"),
                        rs.getInt("bonusDefense"),
                        rs.getInt("bonusAttack"),
                        rs.getInt("bonusCritical")
                ));
            }
        } catch (SQLException e) {
            OCDConsole.printlnError(e.getMessage());
        } finally {
            OracleDAOFactory.closeResultSet(rs);
            OracleDAOFactory.closeStatement(stm);
        }
        return results;
    }

    @Override
    public List<Item> consultLoot(Adventurer adventurer) {
        return null;
    }
}
