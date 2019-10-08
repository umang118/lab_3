package com.example.lab_3;

public class ChatMessage {


    private boolean right, left;
    private String message;

    public ChatMessage() {
        this(false,false,"");
    }

    public ChatMessage(boolean right, boolean left, String message) {
        this.right = right;
        this.left = left;
        this.message = message;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
