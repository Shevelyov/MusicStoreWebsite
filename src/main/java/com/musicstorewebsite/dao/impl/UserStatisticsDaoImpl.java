package com.musicstorewebsite.dao.impl;

import com.musicstorewebsite.dao.UserStatisticsDao;
import com.musicstorewebsite.model.UserStatistics;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sheve on 11/29/2016.
 */
@Repository
@Transactional
public class UserStatisticsDaoImpl implements UserStatisticsDao{

    @Autowired
    private SessionFactory sessionFactory;

    public UserStatistics getUserStatisticsByCustomerAndProduct(int customerId, int productId) {
        UserStatistics userStatistics = null;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from UserStatistics u where u.customer.customerId = :customerId and u.product.productId = :productId";
        Query query = session.createQuery(hql)
                .setParameter("customerId", customerId)
                .setParameter("productId", productId);
        if(query.list() != null && query.list().size() > 0){
            userStatistics = (UserStatistics)query.list().get(0);
        }
        return userStatistics;
    }

    public void saveUserStatistics(UserStatistics userStatistics) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(userStatistics);
        session.flush();
    }

    public List<UserStatistics> getUserStatistics() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserStatistics");
        List<UserStatistics> userStatisticsList = query.list();
        return userStatisticsList;
    }
}
