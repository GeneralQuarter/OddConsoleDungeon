package dao.interfaces;

import model.Adventurer;
import model.Monster;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public interface MonsterDAO {

    Monster getCurrentMonsterOfAdventurer(Adventurer adventurer);

}
