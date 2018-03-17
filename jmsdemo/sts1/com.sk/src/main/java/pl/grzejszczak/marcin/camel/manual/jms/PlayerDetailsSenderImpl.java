package pl.grzejszczak.marcin.camel.manual.jms;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import pl.grzejszczak.marcin.camel.jaxb.generated.PlayerDetails;

@Component
public class PlayerDetailsSenderImpl <T extends  PlayerDetails> {


 private javax.jms.Destination destination;

 @Autowired
 private JmsTemplate jmsTemplate;

 public void sendMessage(final PlayerDetails object) throws JMSException {
  jmsTemplate.convertAndSend(destination, object);
 }

 public javax.jms.Destination getDestination() {
  return destination;
 }

 public void setDestination(javax.jms.Destination destination) {
  this.destination = destination;
 }

}