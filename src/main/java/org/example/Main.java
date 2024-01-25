package org.example;


import org.example.factory.DIFramework;
import org.example.render.IMessageRender;

public class Main {
    public static void main(String[] args) throws Exception {
        IMessageRender renderer = (IMessageRender) DIFramework.beanRegistry.get("renderer");
        renderer.render();
    }
}