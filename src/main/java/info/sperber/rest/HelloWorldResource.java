package info.sperber.rest;


import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.*;


public class HelloWorldResource extends ServerResource
{
	@Get
	public Representation helloWorld() {
		World world = new World("Hallo welt :)");
		return new JacksonRepresentation<World>(world);
	}
	@Put
	public void update(Representation rep) throws Exception {
		if(getRequestAttributes().containsKey("id")) {
			System.out.println("id is " + getRequestAttributes().get("id"));
		}
		JacksonRepresentation<World> wr = new JacksonRepresentation<World>(rep,  World.class);
		try {
			World w = wr.getObject();
			System.out.println("world has message " + w.message);
		} catch (Exception e) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);
		}
	}
}
