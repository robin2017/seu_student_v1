package service;

import dao.LoginerDaoImpl;
import dao.StudentDaoImpl;

/**
 * Created by robin on 2016/10/23.
 */
public class LoginService {
    //因为接口不能用static，因此此处只能用new
    public static boolean isValid(String user,String password){
        return new LoginerDaoImpl().isValid(user,password);
    }
    public static void main(String[] args){
        System.out.println(isValid("robin","121518"));
    }
}
