package ocd.dao.interfaces;

import ocd.dao.entities.Entity;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public interface EntityDAO {

    boolean changeStatus(Entity entity, String status);
    Entity find(int entityId);

}
