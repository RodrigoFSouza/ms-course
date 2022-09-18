package br.com.cronos.hrpayroll.service;

import br.com.cronos.hrpayroll.entities.Payment;
import br.com.cronos.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;
    private final RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(UUID workerId, int days) {
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id", "" + workerId);
        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariable);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
