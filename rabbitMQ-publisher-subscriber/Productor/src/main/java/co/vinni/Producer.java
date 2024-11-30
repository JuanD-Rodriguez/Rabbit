package co.vinni;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);
    private static final String QUEUE_NAME = "message_queue";  // Nombre de la cola
    private static final String SERVER = "127.0.0.1";  // Dirección del servidor RabbitMQ


    public static void sendMessage(String message, String messageType) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(SERVER);  // Conexión al servidor RabbitMQ
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {

            // Declarar la cola sin soporte para mensajes prioritarios
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            // Crear las propiedades del mensaje con encabezados
            Map<String, Object> headers = new HashMap<>();
            headers.put("messageType", messageType);  // Agregar el tipo de mensaje a los encabezados

            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    .headers(headers)
                    .build();

            // Publicar el mensaje con las propiedades
            channel.basicPublish("", QUEUE_NAME, properties, message.getBytes("UTF-8"));

            System.out.println(" [x] Enviado: '" + message + "' con tipo '" + messageType + "'");
        }
    }
}