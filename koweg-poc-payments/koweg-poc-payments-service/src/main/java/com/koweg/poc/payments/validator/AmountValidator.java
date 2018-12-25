/**
 *
 */
package com.koweg.poc.payments.validator;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author larinde
 *
 */
public class AmountValidator implements ConstraintValidator<TransferAmount, BigDecimal> {

    private final BigDecimal minAmount = BigDecimal.valueOf(30.00);

    private final BigDecimal maxAmount = BigDecimal.valueOf(30_000_000.00);

    @Override
    public void initialize(TransferAmount constraintAnnotation) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        if(value.compareTo(minAmount)>=0 || value.compareTo(maxAmount)<=0){
            return true;
        }else{
            StringBuilder messageBuilder = new StringBuilder(value.toPlainString());
            messageBuilder.append(value.compareTo(minAmount)>=0?" is less than minimum transfer amount ":" exceeds maximum transfer amount");
            context.buildConstraintViolationWithTemplate(messageBuilder.toString()).addConstraintViolation();
            return false;
        }
    }

}
