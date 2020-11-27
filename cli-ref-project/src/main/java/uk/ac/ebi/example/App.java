package uk.ac.ebi.example;

import static java.lang.System.out;

import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.ExitCode;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * A skeleton for a typical Command Line entry point.
 * 
 * See the picoclient documentation for details. 
 * 
 */
@Command ( 
	name = "runme", description = "Command Line Example.", 
	exitCodeOnVersionHelp = ExitCode.USAGE, // else, it's 0 and you can't know about this event
	exitCodeOnUsageHelp = ExitCode.USAGE, // ditto
	mixinStandardHelpOptions = true
)
public class App implements Callable<Integer>
{
	/**
	 * If you set this to true, main() will not invoke {@link System#exit(int)}. This is useful in unit tests.
	 */
	public static final String NO_EXIT_PROP = "uk.ac.ebi.debug.no_jvm_exit"; 
			
	private static int exitCode = 0;
	
	private Logger log = LogManager.getLogger ();

	@Option ( names = { "-n", "--name" }, description = "Try passing me your name" )
	private String name = "Dude";
	
	@Parameters ( description = "The command parameters" )
	private String[] params = new String [ 0 ];
	
	@Override
  public Integer call() throws Exception
	{
		out.println ( "Hello, " + name + "!" );
		out.println ( "These are the params you sent me: " );
		for ( String param: params ) 
			out.print ( param + "\t" );
		out.println ();

		log.info ( "all went fine!" );
		return 0;
  }

	
	public static void main ( String... args )
	{
		try
		{
			var cmd = new CommandLine ( new App () );
			exitCode = cmd.execute ( args );
		}
		catch ( Throwable ex ) 
		{
			ex.printStackTrace ( System.err );
			exitCode = 1;
		}
		finally 
		{
			if ( !"true".equals ( System.getProperty ( NO_EXIT_PROP ) ) )
				System.exit ( exitCode );
		}
	}

	
	/**
	 * This can be used when {@link #NO_EXIT_PROP} is "true" and you're invoking the main() method from 
	 * a JUnit test. It tells you the OS exit code that the JVM would return upon exit.
	 */
	public static int getExitCode () {
		return exitCode;
	}

}
