package com.jubayir.demohelloworld.message;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MessageSupportFactory {

    private static MessageSupportFactory instance = null;
    private Properties props = null;
    private MessageRenderer renderer = null;
    private MessageProvider provider = null;

    private MessageSupportFactory (){
        props = new Properties();

        try {
            props.load(new FileInputStream("ch2/src/conf/msf.properties"));

            // get the implementation classes
            String renderclass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");
            renderer = (MessageRenderer) Class.forName(renderclass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance(){
        return instance;
    }

    public MessageRenderer getMessageRenderer(){
        return renderer;
    }

    public MessageProvider getMessageProvider(){
        return provider;
    }
}
