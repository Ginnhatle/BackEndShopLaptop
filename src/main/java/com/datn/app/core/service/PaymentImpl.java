package com.datn.app.core.service;

import com.datn.app.core.dto.PaymentDTO;
import com.datn.app.core.entity.Payment;
import com.datn.app.core.repo.PaymentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PaymentImpl implements PaymentService {
    private final PaymentRepo paymentRepo;

    @Override
    public Payment Save(Payment payment) {
        return paymentRepo.save(payment);
    }

    @Override
    public Payment doUpdateById(Payment payment, Long aLong) {
        Payment payment1 = paymentRepo.findById(aLong).get();
        payment1.setName(payment.getName());

        return paymentRepo.save(payment1);
    }

    @Override
    public Payment doDeleteById(Long aLong) {
        Payment payment = paymentRepo.findById(aLong).get();
        paymentRepo.delete(payment);
        return null;
    }

    @Override
    public Payment doFindById(Long aLong) {
        return paymentRepo.findById(aLong).orElse(null);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepo.findAll();
    }

    @Override
    public Page<Payment> findAll(Integer page, Integer size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return paymentRepo.findAll(pageable);
    }


    @Override
    public Payment addPayment(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setId(paymentDTO.getId());
        payment.setName(paymentDTO.getName());
        return paymentRepo.save(payment);
    }
}
