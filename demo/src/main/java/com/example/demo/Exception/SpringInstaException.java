package com.example.demo.Exception;

public class SpringInstaException extends RuntimeException{
    public SpringInstaException(String exMessage,Exception exception)
    {
        super(exMessage,exception);
    }

    public SpringInstaException(String exMessage)
    {
        super(exMessage);
    }
}
