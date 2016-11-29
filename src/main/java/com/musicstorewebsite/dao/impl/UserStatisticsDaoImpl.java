package com.musicstorewebsite.dao.impl;

import com.musicstorewebsite.dao.UserStatisticsDao;
import com.musicstorewebsite.model.UserStatistics;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sheve on 11/29/2016.
 */
@Repository
@Transactional
public class UserStatisticsDaoImpl implements UserStatisticsDao{

    @Autowired
    private SessionFactory sessionFactory;

    public UserStatistics getUserStatisticsByCustomerAndProduct(int customerId, int productId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from UserStatistics u where u.customer.customerId = :customerId and u.product.productId = :productId";
        Query query = session.createQuery(hql)
                .setParameter("customerId", customerId)
                .setParameter("productId", productId);
        return (UserStatistics)query.list().get(0);
    }

    public void saveUserStatistics(UserStatistics userStatistics) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(userStatistics);
        session.flush();
    }
}
