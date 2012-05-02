package controllers;

import play.*;
import play.mvc.*;
import models.AirCargo;

@With(Secure.class)
@CRUD.For(AirCargo.class)
public class AirCargoes extends CRUD {

}
