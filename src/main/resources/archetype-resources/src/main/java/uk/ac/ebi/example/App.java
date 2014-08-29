package uk.ac.ebi.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 * 
 */
public class App
{
	private static Logger log = LoggerFactory.getLogger ( App.class );
	
	public static void main ( String[] args )
	{
		System.out.println ( "Hello World!" );
		log.info ( "all went fine!" );
	}
}
