package model;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class Lord {
    private int id;
    private String login;
    private boolean blocked;

    public Lord(int id, String login, boolean blocked) {
        this.id = id;
        this.login = login;
        this.blocked = blocked;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public boolean isBlocked() {
        return blocked;
    }
}
