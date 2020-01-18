package com.learn.springCloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author rajes
 * date    Apr 6, 20172:58:52 PM
 *
 */
@RestController
@ConfigurationProperties(prefix="myPrefix") //getters and setters are required while we are using @congiurationproperties. If you use @value, the getters and setters are not required.
public class ClientConfigController {
	
	private static final Logger log = LoggerFactory.getLogger(ClientConfigController.class);
	
	private String name; // this field names should match with the names in the Git property. {https://github.com/rajeshmahadevan/ConfigData/blob/master/ConfigServer/configuration.properties}
	private String description;
	
	
	
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	@RequestMapping(method=RequestMethod.GET,value="/fetchConfig")
	public String getConfigDetails()
	{
		log.info("ClientConfig app is calling the ServerConfig app");
		log.info("Printing the config from the serverConfig app");
		log.info("name= " +name  + "  Desc= "+description);
		return "AppName= " +name  + "  Desc= "+description;
	}

}
