import dao.DAOFactory;
import dao.interfaces.AdventurerDAO;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class OCD {
    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.ORACLE);
        daoFactory.actionsOnClose();
    }
}
