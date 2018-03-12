package info.sperber.jpa;

import java.sql.*;

/**
 * Created by fabian on 3/8/18.
 */
public class Database {


    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/vorlesung?user=vorlesung&password=vorlesung");



    }

}
