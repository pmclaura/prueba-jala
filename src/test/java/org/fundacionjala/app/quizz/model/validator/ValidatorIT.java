package org.fundacionjala.app.quizz.model.validator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorIT {

    @Test
    public void testDateValidator() {
        List<String> errors = new ArrayList<>();
        Validator dateValidator = ValidatorType.DATE.getValidator();

        dateValidator.validate("24/12/2021", null, errors);

        Assert.assertEquals(DateValidator.class, dateValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void testDateValidatorFailed() {
        List<String> errors = new ArrayList<>();
        Validator dateValidator = ValidatorType.DATE.getValidator();

        dateValidator.validate("24/21", null, errors);
        System.out.println(errors);
        Assert.assertEquals(DateValidator.class, dateValidator.getClass());
        Assert.assertFalse(errors.isEmpty());
    }

    @Test
    public void testMinLenghtValidator() {
        List<String> errors = new ArrayList<>();
        Validator minValidator = ValidatorType.MIN_LENGTH.getValidator();

        minValidator.validate("proof of", "5", errors);
        System.out.println(errors);
        Assert.assertEquals(MinLengthValidator.class , minValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void testMaxLenghtValidatorFail() {
        List<String> errors = new ArrayList<>();
        Validator maxValidator = ValidatorType.MAX_LENGTH.getValidator();

        maxValidator.validate("proof of", "5", errors);
        System.out.println(errors);
        Assert.assertEquals(MaxLengthValidator.class , maxValidator.getClass());
        Assert.assertFalse(errors.isEmpty());
    }

    @Test
    public void testUpperCaseValidatorFail() {
        List<String> errors = new ArrayList<>();
        Validator upper = ValidatorType.UPPER_CASE.getValidator();

        upper.validate("proof of", null, errors);
        System.out.println(errors);
        Assert.assertEquals(UpperCaseValidator.class , upper.getClass());
        Assert.assertFalse(errors.isEmpty());
    }

    @Test
    public void testUpperCaseValidator() {
        List<String> errors = new ArrayList<>();
        Validator upper = ValidatorType.UPPER_CASE.getValidator();

        upper.validate("OK", null, errors);
        Assert.assertEquals(UpperCaseValidator.class , upper.getClass());
        Assert.assertTrue(errors.isEmpty());
    }


}
