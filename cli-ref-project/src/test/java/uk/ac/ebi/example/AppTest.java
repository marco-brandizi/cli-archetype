package uk.ac.ebi.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import picocli.CommandLine.ExitCode;

/**
 * Unit test for the example CLI {@link App}.
 */
public class AppTest
{
	private Logger log = LogManager.getLogger ();

	@BeforeClass
	public static void setNoExitOption ()
	{
		// Prevents the CLI from invoking System.exit()
		System.setProperty ( App.NO_EXIT_PROP, "true" );
	}	
	
	
	@Test
	public void testApp()
	{
		// Capture the output into memory
		PrintStream outBkp = System.out;
		ByteArrayOutputStream outBuf = new ByteArrayOutputStream ();
		System.setOut ( new PrintStream ( outBuf ) );
		
		var name = "Mr Bean";
		
		App.main ( "--name", name, "a", "b", "c" );

		System.setOut ( outBkp ); // restore the original output
		
		log.debug ( "CLI output:\n{}", outBuf.toString () );
		assertTrue ( "Can't find --name option in the output!", outBuf.toString ().contains ( "Hello, " + name ) );
		assertTrue ( "Can't find params in the output!", outBuf.toString ().contains ( "a\tb\tc" ) );
		
		assertEquals ( "Bad exit code!", 0, App.getExitCode () );
	}

	@Test
	public void testHelpOption()
	{
		// Capture the output into memory
		PrintStream outBkp = System.out;
		ByteArrayOutputStream outBuf = new ByteArrayOutputStream ();
		System.setOut ( new PrintStream ( outBuf ) );

		App.main (  "--help" );
		
		System.setOut ( outBkp );  // restore the original output

		log.debug ( "CLI output:\n{}", outBuf.toString () );
		assertTrue ( "Can't find CLI output!", outBuf.toString ().contains ( "Command Line Example" ) );
		assertEquals ( "Bad exit code!", ExitCode.USAGE, App.getExitCode () );
	}

}
