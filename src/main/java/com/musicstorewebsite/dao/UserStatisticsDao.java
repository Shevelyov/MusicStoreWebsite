package com.musicstorewebsite.dao;

import com.musicstorewebsite.model.UserStatistics;

/**
 * Created by sheve on 11/29/2016.
 */
public interface UserStatisticsDao {

    UserStatistics getUserStatisticsByCustomerAndProduct(int customerId, int productId);

}
