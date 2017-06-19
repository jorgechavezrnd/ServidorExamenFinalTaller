package com.balance.service;

import com.balance.model.EscalaresHistory;

/**
 * Created by jorge on 19/06/2017.
 */
public interface EscalaresHistoryService {
    void saveEscalaresHistory(EscalaresHistory escalaresHistory);
    Iterable<EscalaresHistory> listAllEscalaresHistorys();
    EscalaresHistory getEscalaresHistoryById(Integer id);
    void deleteEscalaresHistory(Integer id);
}
