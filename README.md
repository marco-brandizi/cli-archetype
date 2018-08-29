Allows you to define a project that produces the binary for a command-line based application, using the 
Assembly plug-in.

Use this command to generate your project from this archetype (doesn't require any pre-download):

```bash
  	
		mvn archetype:generate \
		  -DgroupId=org.test.group \
		  -DartifactId=test-cli \
		  -DarchetypeGroupId=uk.ac.ebi.maven \
		  -DarchetypeArtifactId=cli-archetype \
		  -DarchetypeVersion=<see pom.xml>
```

**YOU HAVE TO SETUP OUR REPOSITORY**
		
The `-DarchetypeRepository` don't work anymore with recent versions of the Maven archetype plugin,
So, in order for the command above to work, you've to setup our repository:
		  
https://raw.githubusercontent.com/EBIBioSamples/EBIBioSamples.github.io/maven-repo
		  
in your Maven environment. 
Details [here](https://maven.apache.org/archetype/maven-archetype-plugin/archetype-repository.html).
