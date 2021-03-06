package info.sperber.rest;


import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;


public class HelloWorldApplication extends Application{
	@Override public Restlet createInboundRoot()
	{
		Router router = new Router(getContext());
		router.attach("/hello/{id}", HelloWorldResource.class);
		return router;
	}
}
