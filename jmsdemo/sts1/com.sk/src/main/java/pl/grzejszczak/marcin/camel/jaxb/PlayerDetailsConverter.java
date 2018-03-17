package pl.grzejszczak.marcin.camel.jaxb;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.activemq.util.ByteArrayInputStream;
import org.springframework.stereotype.Component;

import pl.grzejszczak.marcin.camel.jaxb.generated.PlayerDetails;

@Component("PlayerDetailsConverter")
public class PlayerDetailsConverter<T extends PlayerDetails> {

	private final JAXBContext jaxbContext;
	private final Marshaller jaxbMarshaller;
	private final Unmarshaller jaxbUnmarshaller;

	public PlayerDetailsConverter() throws JAXBException {
		jaxbContext = JAXBContext.newInstance(PlayerDetails.class);
		jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	}

	public String marshal(PlayerDetails object) {
		OutputStream stream = new ByteArrayOutputStream();
		try {
			jaxbMarshaller.marshal(object, stream);
		} catch (JAXBException e) {
			System.err.println("Exception occured while marshalling" + e);
		}
		return stream.toString();
	}

	public PlayerDetails unmarshal(String objectAsString) {
		try {
			return (PlayerDetails) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(objectAsString.getBytes()));
		} catch (JAXBException e) {
			System.err.println("Exception occured while marshalling" + e);
		}
		return null;
	}

}