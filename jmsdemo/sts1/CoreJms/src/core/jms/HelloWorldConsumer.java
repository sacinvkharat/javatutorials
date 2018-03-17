package core.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloWorldConsumer {

	public static void main(String[] args) throws JMSException {
		// TODO Auto-generated method stub
		ActiveMQConnectionFactory connectionFactory =new ActiveMQConnectionFactory();
		Connection connection = connectionFactory.createConnection();
		
		System.out.println(connection);
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue  destination = session.createQueue("Helloworld.TestTQ");
		MessageConsumer consumer = session.createConsumer(destination);
		Message message = consumer.receive();
		if(message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			System.out.println(textMessage.getText());
		}
		
		
		session.close();
		connection.close();
		

	}

}
