package com.dao;

import com.vo.Message;
import com.vo.Person;

import java.util.List;

public interface IMessageDAO {
    public void insert(Message message) throws Exception;
    public void update(Message message) throws Exception;
    public void delete(int messageID) throws  Exception;
    public Message queryByID(int messageID) throws Exception;
    public List<Message> qureyAll() throws Exception;
    public List<Message> qureyByLike(String key) throws Exception;
}
