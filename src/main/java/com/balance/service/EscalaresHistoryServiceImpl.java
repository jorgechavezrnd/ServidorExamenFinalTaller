package com.balance.service;

import com.balance.model.EscalaresHistory;
import com.balance.repository.EscalaresHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jorge on 19/06/2017.
 */
@Service
public class EscalaresHistoryServiceImpl implements EscalaresHistoryService {

    @Autowired
    EscalaresHistoryRepository escalaresHistoryRepository;

    @Override
    public void saveEscalaresHistory(EscalaresHistory escalaresHistory) {
        escalaresHistoryRepository.save(escalaresHistory);
    }

    @Override
    public Iterable<EscalaresHistory> listAllEscalaresHistorys() {
        return escalaresHistoryRepository.findAll();
    }

    @Override
    public EscalaresHistory getEscalaresHistoryById(Integer id) {
        return escalaresHistoryRepository.findOne(id);
    }

    @Override
    public void deleteEscalaresHistory(Integer id) {
        escalaresHistoryRepository.delete(id);
    }
}
