package com.dao.Impl;

import com.dao.IRevertDAO;
import com.db.ConnectionManager;
import com.vo.Revert;

import javax.xml.stream.events.DTD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RevertDAOImpl implements IRevertDAO {
    @Override
    public List<Revert> queryBymessageID(int MessageID) throws Exception {
        List<Revert> all = new ArrayList<Revert>();
        Connection con = null;
        ResultSet res = null;
        String sql = "select * from revert where messageID = ?";
        PreparedStatement pstmt = null;
        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,MessageID);
            res = pstmt.executeQuery();
            while(res.next()){
                Revert revert = new Revert();
                revert.setRevertID(res.getInt(1));
                revert.setMessageID(res.getInt(2));
                revert.setContent(res.getString(3));
                revert.setWriter(res.getString(4));
                revert.setWriteDate(res.getDate(5));
                all.add(revert);
            }
        }catch(Exception e){
            throw new Exception("查询回复出现问题");
        }finally{
            ConnectionManager.closeResultSet(res);
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
        return all;
    }

    @Override
    public void insertBymessageID(Revert revert) throws Exception {
        String sql = "insert into revert(messageID,content,writer,writeDate) values(?,?,?,?)";
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,revert.getMessageID());
            pstmt.setString(2,revert.getContent());
            pstmt.setString(3,revert.getWriter());
            pstmt.setDate(4,(Date)revert.getWriteDate());
            pstmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
    }

    @Override
    public void deleteByRevertID(int revertID) throws Exception {
        String sql = "delete from revert where revertID = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,revertID);
            pstmt.executeUpdate();
        }catch(Exception e){
            throw new Exception("删除回复出错");
        }finally{
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
    }

    @Override
    public void deleteByMessageID(int messageID) throws Exception {
        String sql = "delete from revert where messageID = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,messageID);
            pstmt.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
    }
}
