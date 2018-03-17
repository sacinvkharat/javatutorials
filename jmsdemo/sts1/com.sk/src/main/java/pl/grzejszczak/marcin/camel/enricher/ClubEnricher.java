package pl.grzejszczak.marcin.camel.enricher;

import org.springframework.stereotype.Component;

import pl.grzejszczak.marcin.camel.jaxb.generated.PlayerDetails;

@Component("ClubEnricher")
public class ClubEnricher<T extends PlayerDetails> {

	public void enrich(PlayerDetails inputObject) {
		System.out.println("Enriching player [{}] with club data" + new Object[] { inputObject.getSurname() });
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Exception while sleeping occured" + e);
		}
		inputObject.setTeamName("Borussia Dortmund");
	}

}