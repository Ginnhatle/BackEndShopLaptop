package com.datn.app.endpoint;

import com.datn.app.core.dto.PaymentDTO;
import com.datn.app.core.entity.Payment;
import com.datn.app.core.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Payment")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/find-all")
    public List<Payment> findAll() {
        return paymentService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody PaymentDTO paymentDTO) {
//        Payment savedUser = paymentService.doInsert(payment);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        return ResponseEntity.ok(paymentService.addPayment(paymentDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.doUpdateById(payment, id));
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<?> findAllPage(@PathVariable int page,@PathVariable int size){
        return ResponseEntity.ok(paymentService.findAll(page,size));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getId(@PathVariable Long id){
        return ResponseEntity.ok(paymentService.doFindById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(paymentService.doDeleteById(id));
    }
}
