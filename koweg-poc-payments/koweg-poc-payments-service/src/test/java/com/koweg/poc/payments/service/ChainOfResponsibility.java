package com.koweg.poc.payments.service;

import com.koweg.poc.payments.rest.representation.Payment;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.CreditCardValidator;

import java.math.BigDecimal;
import java.util.Date;

public class ChainOfResponsibility {

    public static void main(String[] args){
        Action<Payment, Decision> nextAction = null;
        ValidatePANAction initAction = new ValidatePANAction(nextAction);

        Result decision = (Result) initAction.execute(new Payment(3l, BigDecimal.valueOf(3000791.53), new Date(),  "USD"));
        System.out.println("decision - " + decision.getState().name());

    }


    public interface Decision{
        public Action next();
    }

    @EqualsAndHashCode
    @Getter
    public static class Result implements Decision{
        private final Action action;
        private final ActionState state;

        public Result(Action action, ActionState state) {
            this.action = action;
            this.state = state;
        }

        public ActionState getState() {
            return state;
        }

        public Action getAction() {
            return action;
        }

        @Override
        public Action next() {
            return action;
        }
    }

    public interface Action<I, O>{
        public O execute(I i);
    }

    public enum ActionState{
        COMPLETED, FAILED, NEXT_ACTION;
    }

    public static class ValidatePANAction implements Action<Payment, Decision>{

        private final Action<Payment, Decision> action;

        ValidatePANAction(Action<Payment, Decision> action) {
            this.action = action;
        }

        @Override
        public Decision execute(Payment payment) {
            CreditCardValidator validator = new CreditCardValidator();
            if (validator.isValid("4380740276346569"))
                return new Result(action, ActionState.NEXT_ACTION);
            return  new Result(action, ActionState.FAILED);
        }
    }

    public static class ValidateCardLimitAction implements  Action<Payment, Decision>{

        private final Action<Payment, Decision> action;

        ValidateCardLimitAction(Action<Payment, Decision> action) {
            this.action = action;
        }

        @Override
        public Decision execute(Payment payment) {
            return null;
        }
    }

}
