package com.dao.Impl;

import com.dao.IMessageDAO;
import com.db.ConnectionManager;
import com.vo.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAOImpl implements IMessageDAO {

    @Override
    public void insert(Message message) throws Exception {
        String sql = "INSERT INTO message(title,writer,content,writeDate)values(?,?,?,?)";
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,message.getTitle());
            pstmt.setString(2,message.getWriter());
            pstmt.setString(3, message.getContent());
            pstmt.setDate(4,(Date)message.getWriteDate());
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throw new Exception("增加操作出现问题! ! !");
        }finally {
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
    }  //增加帖子

    @Override
    public void update(Message message) throws Exception {
        String sql = "UPDATE message set title = ? wirter = ?,content = ? WHERE messageID = ?";
        Connection con   = null;
        PreparedStatement pstmt  = null;
        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,message.getTitle());
            pstmt.setString(2,message.getWriter());
            pstmt.setString(3,message.getContent());
            pstmt.setInt(4,message.getMessageID());
            pstmt.executeUpdate() ;
        }catch(Exception e){
            throw new Exception("更新操作出现错误！！！！");
        }finally{
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
    }

    @Override
    public void delete(int messageID) throws Exception {
        String sql = "delete from message where messageID = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,messageID);
            pstmt.executeUpdate();
        }catch(Exception e){
            throw new Exception("删除操作中出现错误!!!");
        }finally{
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
    }   //删除帖子

    @Override
    public Message queryByID(int messageID) throws Exception {
        Message message = null;
        String sql = "SELECT messageID,title,writer,content,writeDate from message where messageid = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,messageID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                message = new Message();
                message.setMessageID(rs.getInt(1));
                message.setTitle(rs.getString(2));
                message.setWriter(rs.getString(3));
                message.setContent(rs.getString(4));
                message.setWriteDate(rs.getDate(5));
            }
        }catch(Exception e){
            throw new Exception("查找操作出现问题");
        }finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
        return message;
    }   //查找帖子

    @Override
    public List<Message> qureyAll() throws Exception {
        List<Message> all = new ArrayList<Message>() ;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        String sql = "SELECT * FROM message";
        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            res = pstmt.executeQuery();
            while(res.next()){
                Message message = new Message();
                message.setMessageID(res.getInt(1));
                message.setTitle(res.getString(2));
                message.setContent(res.getString(3));
                message.setWriter(res.getString(4));
                message.setWriteDate(res.getDate(5));
                all.add(message);
            }
        }catch(Exception e){
            throw new Exception("查找所有帖子操作出现问题");
        }finally{
            ConnectionManager.closeResultSet(res);
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
        return all;
    }   //查找所有帖子

    @Override
    public List<Message> qureyByLike(String key) throws Exception {
        List<Message> all = new ArrayList<Message>();
        String sql = "select * from message where title like ? or writer like ? or content like ?";
        Connection con = null;
        PreparedStatement pstmt= null;
        ResultSet res = null;
        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,"%"+key+"%");
            pstmt.setString(2,"%"+key+"%");
            pstmt.setString(3,"%"+key+"%");
            res = pstmt.executeQuery();
            while(res.next()){
                Message message = new Message();
                message.setMessageID(res.getInt(1));
                message.setTitle(res.getString(2));
                message.setContent(res.getString(3));
                message.setWriter(res.getString(4));
                message.setWriteDate(res.getDate(5));
                all.add(message);
            }
        }catch (Exception e){
            throw new Exception("模糊查询出现错误");
        }finally{
            ConnectionManager.closeResultSet(res);
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
        return all;
    }
}
