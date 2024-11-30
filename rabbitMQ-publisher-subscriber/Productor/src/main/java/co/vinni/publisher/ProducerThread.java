package co.vinni.publisher;

import co.vinni.Producer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProducerThread implements Runnable {
    private final String message;
    private final String messageType;

    public ProducerThread(String message, String messageType) {
        this.message = message;
        this.messageType = messageType;
    }

    @Override
    public void run() {
        try {
            // Llamar al método que envía el mensaje
            Producer.sendMessage(message, messageType);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}