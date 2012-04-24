package controllers;

import play.*;
import play.mvc.*;
import models.Company;

@With(Secure.class)
@CRUD.For(Company.class)
public class Companies extends CRUD {

}
