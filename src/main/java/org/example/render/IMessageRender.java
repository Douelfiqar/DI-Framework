package org.example.render;

import org.example.provider.IMessageProvider;

public interface IMessageRender {
    public void render();
    public void setMessageProvider(IMessageProvider provider);
}
