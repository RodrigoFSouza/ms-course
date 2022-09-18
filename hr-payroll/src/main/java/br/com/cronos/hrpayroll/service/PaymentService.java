package br.com.cronos.hrpayroll.service;

import br.com.cronos.hrpayroll.clients.WorkerFeignClient;
import br.com.cronos.hrpayroll.entities.Payment;
import br.com.cronos.hrpayroll.entities.Worker;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    private WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(UUID workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
