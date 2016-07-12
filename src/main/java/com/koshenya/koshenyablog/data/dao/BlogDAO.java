package com.koshenya.koshenyablog.data.dao;

import com.koshenya.koshenyablog.data.persistance.Comment;
import com.koshenya.koshenyablog.data.persistance.Image;
import com.koshenya.koshenyablog.data.persistance.Message;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

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
        List<Message> list = (List<Message>)sessionFactory.getCurrentSession()
                .createCriteria(Message.class)
                .addOrder(Order.desc("created"))
                .setCacheable(true)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
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
    public Comment getComment(int id) {
        Comment comment = (Comment)sessionFactory.getCurrentSession().get(Comment.class, id);
        return comment;
    }

    @Transactional
    public void saveComment(Comment comment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(comment);
        transaction.commit();
        session.close();

        //sessionFactory.getCache().evictCollectionRegions();
        sessionFactory.getCache().evict(comment.getMessage().getClass(), comment.getMessage().getId());
    }

    @Transactional
    public List<Image> getImages() {
        List<Image> list = (List<Image>)sessionFactory.getCurrentSession()
                .createCriteria(Image.class)
                .addOrder(Order.desc("created"))
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
