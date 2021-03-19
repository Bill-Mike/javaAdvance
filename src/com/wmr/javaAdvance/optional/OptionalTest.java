package com.wmr.javaAdvance.optional;

import javax.xml.bind.annotation.XmlInlineBinaryData;

public class OptionalTest {
    public static void main(String[] args) {
        IMessage msg = null;
        System.out.println(msg.getContent());
    }
}

interface IMessage{
    public String getContent();
}

class MessageImpl implements IMessage{
    private IMessage iMessage;
    public MessageImpl(IMessage iMessage){
        this.iMessage = iMessage;
    }
    @Override
    public String getContent() {
        return this.iMessage.getContent();
    }
}
