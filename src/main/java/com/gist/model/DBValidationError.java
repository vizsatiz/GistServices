package com.gist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kh1888 on 07/10/17.
 */
public class DBValidationError {

    private List<DBFieldValidationError> fieldErrors = new ArrayList<>();

    public DBValidationError() {

    }

    public void addFieldError(String path, String message) {
        DBFieldValidationError error = new DBFieldValidationError(path, message);
        fieldErrors.add(error);
    }

    public List<DBFieldValidationError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<DBFieldValidationError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
