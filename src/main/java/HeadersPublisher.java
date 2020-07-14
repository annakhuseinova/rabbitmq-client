import com.rabbitmq.client.*;
import com.rabbitmq.client.impl.AMQBasicProperties;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class HeadersPublisher {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        String message = "This is a message for a headers exchange";
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("item1", "mobile");
        headerMap.put("item2", "television");

        BasicProperties basicProperties = new BasicProperties() {
            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public String getContentEncoding() {
                return null;
            }

            @Override
            public Map<String, Object> getHeaders() {
                return headerMap;
            }

            @Override
            public Integer getDeliveryMode() {
                return null;
            }

            @Override
            public Integer getPriority() {
                return null;
            }

            @Override
            public String getCorrelationId() {
                return null;
            }

            @Override
            public String getReplyTo() {
                return null;
            }

            @Override
            public String getExpiration() {
                return null;
            }

            @Override
            public String getMessageId() {
                return null;
            }

            @Override
            public Date getTimestamp() {
                return null;
            }

            @Override
            public String getType() {
                return null;
            }

            @Override
            public String getUserId() {
                return null;
            }

            @Override
            public String getAppId() {
                return null;
            }
        };
        channel.basicPublish("Headers-Exchange", "", (AMQP.BasicProperties) basicProperties, message.getBytes());
    }
}
