package dao;

import domain.Loginer;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by robin on 2016/10/23.
 */
public class LoginerDaoImpl implements LoginerDao {
    public  boolean isValid(String user, String password) {
        Loginer loginer=null;
        ResultSet rs=null;
        String sql="select * from logininfo where user='"+user+"'";
        DataBaseUtil.preOperation();


        try {
            rs=DataBaseUtil.stmt.executeQuery(sql);

            while(rs.next()){
                loginer=new Loginer(rs);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        DataBaseUtil.afterOperation();

        if(loginer==null)
            return false;
        return loginer.getPassword().equals(password);

    }

	
	public boolean register(String name, String password) {
		// TODO Auto-generated method stub
		 String sql="insert into logininfo values('"+name+"','"+password+"')";
	        DataBaseUtil.preOperation();
	        try {
				int rs=DataBaseUtil.stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;
	}
}
