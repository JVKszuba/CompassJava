package model.services;

public class PaypalService implements OnlinePaymentService {

    @Override
    public Double paymentFee(Double amount) {

        double rate = (double) 2/100;

        return amount + (amount * rate);
    }

    @Override
    public Double interest(Double amount, Integer months) {

        double rate = (double) 1/100;

        return amount + (amount * (rate * months));
    }
}
