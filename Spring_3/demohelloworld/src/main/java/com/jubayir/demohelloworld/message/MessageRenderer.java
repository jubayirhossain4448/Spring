package com.jubayir.demohelloworld.message;

public interface MessageRenderer {
    public MessageProvider render();
    public void setMessageProvider(MessageProvider provider);
    public MessageProvider getMssageProvider();
}
