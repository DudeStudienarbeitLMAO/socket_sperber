package info.sperber.rest;


import com.fasterxml.jackson.annotation.JsonProperty;


public class World
{
	@JsonProperty("message")
	String message;

	public World() {
		this("DEFAULT");
	}

	public World(String message) {
		super();
		this.message = message;
	}
}
