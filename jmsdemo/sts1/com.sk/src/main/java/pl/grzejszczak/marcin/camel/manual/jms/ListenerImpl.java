package pl.grzejszczak.marcin.camel.manual.jms;

import java.util.List;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import pl.grzejszczak.marcin.camel.enricher.ClubEnricher;
import pl.grzejszczak.marcin.camel.jaxb.PlayerDetailsConverter;
import pl.grzejszczak.marcin.camel.jaxb.generated.PlayerDetails;

@Component
public class ListenerImpl implements MessageListener {

	@Autowired
	private PlayerDetailsConverter<PlayerDetails> playerDetailsConverter;

	@Autowired
	private List<ClubEnricher<PlayerDetails>> listOfEnrichers;

	@Autowired
	private MessageConverter messageConverter;

	@Autowired
	@Qualifier("destinationPlayerSender")
	private PlayerDetailsSenderImpl<PlayerDetails> sender;

	//@Override
	public void onMessage(Message message) {
		if (!(message instanceof BytesMessage)) {
			return;
		}

		PlayerDetails playerDetails = null;
		try {
			playerDetails = (PlayerDetails) messageConverter.fromMessage(message);

			for (ClubEnricher<PlayerDetails> enrichable : listOfEnrichers) {
				enrichable.enrich(playerDetails);
			}
			sender.sendMessage(playerDetails);
		} catch (Exception e) {
		}

	}

}
