package core.jms;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloWorldProducer {

	public static void main(String[] args) throws JMSException {
		// TODO Auto-generated method stub
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		Connection connection = connectionFactory.createConnection();
		System.out.println(connection);
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue destination = session.createQueue("Helloworld.TestTQ");
		MessageProducer messageProducer = session.createProducer(destination);
		messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		TextMessage textMessage = session.createTextMessage("Hi,this is my first example of queue");
		messageProducer.send(textMessage);
		session.close();
		connection.close();
	}

}
