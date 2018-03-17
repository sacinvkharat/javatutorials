package pl.grzejszczak.marcin.camel.manual.jms;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;

import pl.grzejszczak.marcin.camel.jaxb.generated.PlayerDetails;

public class FinalListenerImpl implements MessageListener {

	@Autowired
	private MessageConverter messageConverter;

	public void onMessage(Message message) {
		if (!(message instanceof BytesMessage)) {
			System.out.println("");
			return;
		}

		PlayerDetails playerDetails = null;
		try {
			playerDetails = (PlayerDetails) messageConverter.fromMessage(message);

			if (playerDetails.getTeamName() != null) {
				System.out.println("Message already enriched! Shutting down the system");
			} else {
				System.out.println("The message should have been enriched but wasn't");
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e);
		} finally {
			System.exit(0);
		}

	}

}
