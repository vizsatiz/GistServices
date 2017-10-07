package com.gist.model;

/**
 * Created by kh1888 on 07/10/17.
 */
public class DBFieldValidationError {

    private String fieldName;

    private String errorMessage;

    public DBFieldValidationError(String field, String message) {
        this.fieldName = field;
        this.errorMessage = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
