package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by robin on 2016/10/23.
 */
public class Loginer implements Serializable {
    private String user;
    private String password;

    public Loginer(){

    }
    public Loginer(ResultSet rs){
        try {
            this.user=rs.getString("user");
            this.password=rs.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
