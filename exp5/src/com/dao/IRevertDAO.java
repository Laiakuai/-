package com.dao;

import com.vo.Message;
import com.vo.Revert;

import java.util.List;
public interface IRevertDAO {
    public List<Revert> queryBymessageID(int id) throws Exception;
    public void insertBymessageID(Revert revert) throws Exception;
    public void deleteByRevertID(int revertID) throws Exception;
    public void deleteByMessageID(int messageID)throws Exception;
}
