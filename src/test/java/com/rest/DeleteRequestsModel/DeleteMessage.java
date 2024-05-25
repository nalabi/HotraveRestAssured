package com.rest.DeleteRequestsModel;

public class DeleteMessage {
    public int Id;

    public String Message;

    public void setId(int id) {
        Id = id;
    }

    public void setMessage(String message) {
        this.Message = message;
    }

    public int getId() {
        return Id;
    }
}
