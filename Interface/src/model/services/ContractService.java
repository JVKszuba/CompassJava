package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {

        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months) {

        Double basicQuota = contract.getTotalValue() / months;
        LocalDate dueDate;
        Double interest, fee;

        for (int i = 1; i <= months; i++) {

            dueDate = contract.getDate().plusMonths(i);

            interest = paymentService.interest(basicQuota, i);
            fee = paymentService.paymentFee(interest);

            contract.addInstallment(new Installment(dueDate, fee));
        }
    }
}
