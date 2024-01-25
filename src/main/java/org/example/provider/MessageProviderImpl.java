package org.example.provider;

public class MessageProviderImpl implements IMessageProvider{
    @Override
    public String getMessage() {
        return "hello world!";
    }
}
