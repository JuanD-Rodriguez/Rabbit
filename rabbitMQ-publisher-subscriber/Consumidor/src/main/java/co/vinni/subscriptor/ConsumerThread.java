package co.vinni.subscriptor;

import co.vinni.Receiver;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerThread implements Runnable {

    @Override
    public void run() {
        try {
            // Llamar al método que inicia el consumidor
            Receiver.startWorker();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
