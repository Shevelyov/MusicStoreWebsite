package com.musicstorewebsite.dao;

import com.musicstorewebsite.model.UserStatistics;

import java.util.List;

/**
 * Created by sheve on 11/29/2016.
 */
public interface UserStatisticsDao {

    UserStatistics getUserStatisticsByCustomerAndProduct(int customerId, int productId);

    void saveUserStatistics(UserStatistics userStatistics);

    List<UserStatistics> getUserStatistics();

}
