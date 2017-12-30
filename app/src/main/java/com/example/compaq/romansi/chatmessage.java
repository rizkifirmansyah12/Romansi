package com.example.compaq.romansi;

import java.util.Date;

/**
 * Created by Compaq on 29/12/2017.
 */

public class chatmessage {
  private String messageText;
    private String messageUser;
    private Long messageTime;

    public chatmessage(String messageText, String messageUser) {
        this.messageText = messageText;
        this.messageUser = messageUser;

        messageTime=new Date().getTime();
    }

    public chatmessage() {

    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public Long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Long messageTime) {
        this.messageTime = messageTime;
    }
}
