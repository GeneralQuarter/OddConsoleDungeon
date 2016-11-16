package dao.interfaces;

import model.Entity;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public interface EntityDAO {

    void changeStatus(Entity entity, String status);

}
