package com.vehicle.vehicle.domain;

import java.io.Serializable;

public class Response implements Serializable {
    private static final long serialVersionUID = 5051959002247961754L;
    private String message;

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
