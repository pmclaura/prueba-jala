package org.fundacionjala.app.quizz.model.validator;

import java.util.List;

public class UpperCaseValidator implements Validator{
    private static final String ERROR_MESSAGE = "The letters must be upper case ";

    @Override
    public void validate(String value, String conditionValue, List<String> errors) {
        if (value.equals(value.toLowerCase())) {
            errors.add(ERROR_MESSAGE);
        }
    }
}
