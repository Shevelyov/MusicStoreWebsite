package com.musicstorewebsite.service.impl;

import com.musicstorewebsite.dao.UserStatisticsDao;
import com.musicstorewebsite.model.UserStatistics;
import com.musicstorewebsite.service.UserStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sheve on 11/29/2016.
 */
@Service
public class UserStatisticsServiceImpl implements UserStatisticsService{

    @Autowired

    private UserStatisticsDao userStatisticsDao;

    public UserStatistics getUserStatisticsByCustomerAndProduct(int customerId, int productId) {
        return userStatisticsDao.getUserStatisticsByCustomerAndProduct(customerId, productId);
    }

    public void saveUserStatistics(UserStatistics userStatistics) {
        userStatisticsDao.saveUserStatistics(userStatistics);
    }

    public List<UserStatistics> getAllUserStatistics() {
        return userStatisticsDao.getUserStatistics();
    }
}
