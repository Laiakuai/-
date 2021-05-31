package com.dao.Impl;

import com.dao.IPersonDAO;
import com.db.ConnectionManager;
import com.vo.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PersonDAOImpl implements IPersonDAO {
    @Override
    public boolean login(Person person) throws Exception {
        boolean flag = false;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT name FROM person where id = ? and password = ?";
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,person.getId());
            pstmt.setString(2,person.getPassword());
            rs = pstmt.executeQuery();
            if (rs.next()){
                flag = true;
                person.setName(rs.getString(1));
            }
        } catch (Exception throwables) {
            throw new Exception("操作出现问题!!");
        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
        return flag;
    }
}
