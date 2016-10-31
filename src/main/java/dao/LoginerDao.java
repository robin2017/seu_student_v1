package dao;

/**
 * Created by robin on 2016/10/23.
 */
public interface LoginerDao {
    public  boolean isValid(String name,String password);
    public  boolean register(String name,String password);
}
