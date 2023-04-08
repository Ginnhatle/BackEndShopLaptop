package com.datn.app.core.service;

import com.datn.app.core.dto.PaymentDTO;
import com.datn.app.core.entity.Payment;
import com.datn.app.core.service.base.ServiceCore;

public interface PaymentService extends ServiceCore<Payment, Long> {
    Payment addPayment(PaymentDTO paymentDTO);

}
