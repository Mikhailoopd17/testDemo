package com.example.demo.Exception;

public class ErrorMessage {
    private int code;
    private String message;
    private String errorText;
    private String stackTrace;

    public ErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorMessage(int code, String message, String errorText) {
        this.code = code;
        this.message = message;
        this.errorText = errorText;
    }

    public ErrorMessage(int code, String message, String errorText, String stackTrace) {
        this.code = code;
        this.message = message;
        this.errorText = errorText;
        this.stackTrace = stackTrace;
    }

    public String getErrorText() {
        return this.errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
