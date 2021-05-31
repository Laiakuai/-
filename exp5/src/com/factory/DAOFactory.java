package com.factory;

import com.dao.IMessageDAO;
import com.dao.IPersonDAO;
import com.dao.IRevertDAO;
import com.dao.Impl.MessageDAOImpl;
import com.dao.Impl.PersonDAOImpl;
import com.dao.Impl.RevertDAOImpl;

public class DAOFactory {
    public static IPersonDAO getPersonDAOInstance(){
        return new PersonDAOImpl();
    }
    public static IMessageDAO getmessageDAOInstance(){
        return new MessageDAOImpl();
    }
    public static IRevertDAO getRevertDAOInstance(){
        return new RevertDAOImpl();
    }
}
