package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	@Before
	static void addDefaults() {
	    renderArgs.put("conciergeTitle", Play.configuration.getProperty("concierge.title"));
	    renderArgs.put("conciergeBaseline", Play.configuration.getProperty("concierge.baseline"));
	}
	
	public static void index() {
        render();
    }
}