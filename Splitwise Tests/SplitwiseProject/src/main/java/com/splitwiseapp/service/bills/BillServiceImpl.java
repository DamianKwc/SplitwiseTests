package com.splitwiseapp.service.bills;

import com.splitwiseapp.entity.BillEntity;
import com.splitwiseapp.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillServiceImpl implements BillService {

    private BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillRepository theBillRepository) {
        billRepository = theBillRepository;
    }

    @Override
    public List<BillEntity> findAll() {
        return billRepository.findAll();
    }
}
