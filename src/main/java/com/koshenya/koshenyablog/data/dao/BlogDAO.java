package com.koshenya.koshenyablog.data.dao;

import com.koshenya.koshenyablog.data.persistance.Image;
import com.koshenya.koshenyablog.data.persistance.Message;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Admin on 1/13/2016.
 */


public class BlogDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Transactional
    public List<Message> getMessages() {
        List<Message> list = (List<Message>)sessionFactory.getCurrentSession().createCriteria(Message.class).list();
        return list;
    }

    @Transactional
    public Message getMessage(int id) {
        Message message = (Message)sessionFactory.getCurrentSession().get(Message.class, id);
        return message;
    }

    @Transactional
    public void saveMessage(Message message) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(message);
        transaction.commit();
        session.close();
    }


    @Transactional
    public List<Image> getImages() {
        List<Image> list = (List<Image>)sessionFactory.getCurrentSession().createCriteria(Image.class)
                .addOrder(Order.asc("id"))
                .list();
        return list;
    }

    @Transactional
    public Image getImage(int id) {
        Image image = (Image)sessionFactory.getCurrentSession().get(Image.class, id);
        return image;
    }

    @Transactional
    public void saveImage(Image image) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(image);
        transaction.commit();
        session.close();
    }

    @Transactional
    public void deleteImages(List<Integer> ids) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("delete from Image where id in (:ids)");
            query.setParameterList("ids", ids);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
