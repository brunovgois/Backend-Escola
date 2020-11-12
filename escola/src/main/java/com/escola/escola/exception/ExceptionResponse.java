package com.escola.escola.exception;

import java.util.Date;

public class ExceptionResponse {

    public ExceptionResponse(Date timeStamp, String error, String message, int status, String path, String exception) {
        this.timeStamp = timeStamp;
        this.error = error;
        this.message = message;
        this.status = status;
        this.path = path;
    }

    private Date timeStamp;
    private String error;
    private String message;
    private int status;
    private String path;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
