package com.musicstorewebsite.service;

import com.musicstorewebsite.model.UserStatistics;

/**
 * Created by sheve on 11/29/2016.
 */
public interface UserStatisticsService {

    UserStatistics getUserStatisticsByCustomerAndProduct(int customerId, int productId);
}
