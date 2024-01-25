package org.example.render;

import org.example.provider.IMessageProvider;

public class MessageRenderImpl implements IMessageRender {
    private IMessageProvider messageProvider = null;
    @Override
    public void render() {

            if(messageProvider == null) {
                System.out.println("You must set iMessageProvider");
            }else{
                var message = messageProvider.getMessage();
                System.out.println(message);
            }

    }
    @Override
    public void setMessageProvider(IMessageProvider provider){
        this.messageProvider = provider;
    }
    public boolean isMessageProvider() {
        return (messageProvider != null);
    }
}
