package pl.edu.pb.soap.model;

import java.util.Date;

/**
 * Created by Mateusz on 01.06.2017.
 */
public class AddItemResult {
    int messageId;
    String resultMessage;
    Date publishTime;

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}
