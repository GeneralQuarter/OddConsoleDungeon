package ocd.dao.interfaces;

import ocd.dao.entities.Adventurer;
import ocd.dao.entities.Monster;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public interface MonsterDAO {

    Monster getCurrentMonsterOfAdventurer(Adventurer adventurer);

}
