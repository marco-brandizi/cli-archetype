package uk.ac.ebi.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	private static Logger log = LoggerFactory.getLogger ( App.class );

	@Test
	public void testApp()
	{
		assertTrue( true );
		log.debug ( "should have worked!" );
	}
}
