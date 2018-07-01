package club.cheapok.n26.constraint.validator;

import club.cheapok.n26.constraint.AcceptedRange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AcceptedRangeValidator implements ConstraintValidator<AcceptedRange, Long> {
    private long range;

    public void initialize(final AcceptedRange constraint) {
        this.range = constraint.seconds() * 1000;
    }

    public boolean isValid(final Long timestamp, final ConstraintValidatorContext context) {
        final long currentTimeMillis = System.currentTimeMillis();
        return timestamp <= currentTimeMillis &&
                currentTimeMillis - timestamp < range;
    }
}
