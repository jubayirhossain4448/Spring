package com.jubayir.demohelloworld.message;

public class StandardOutMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider = null;

    public MessageProvider render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
        return null;
    }

    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMssageProvider() {
        return null;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
