package br.com.cronos.hrpayroll.controllers;

import br.com.cronos.hrpayroll.entities.Payment;
import br.com.cronos.hrpayroll.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable("workerId") UUID workerId,
                                              @PathVariable("days") int days) {
        Payment  payment = paymentService.getPayment(workerId, days);

        return ResponseEntity.ok(payment);

    }
}
