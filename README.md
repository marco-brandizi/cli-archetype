# The Command Line Archetype

This is a [Maven Archetype project][10], to create Maven project that produce command line packages.  

 
You can easily generate a new project (ie, Maven module) from a Bash-compatible shell,
by typing something like:


```bash  	
curl -L TODO | sh -s sampleGroupId sample-cli 1.0-SNAPSHOT
```

where, of course, the three parameters are the new artifact's coordinates.

This generates a new basic CLI project, which includes:

- an entry point class, which contains a `main()` implementation that parses the command line arguments by
  means of the [picocli library][20]. Examples showing how to define possible options and parse them with this
  library is shown.
  
- A unit test for the entry point, which you can customise according to your needs.

- Definitions based on the [Maven Assembly plug-in][30] to put a distribution zip together.
  This includes a Bash launching script (Windows not available yet). The `zip-deploy.sh` script helps you to 
  deploy the distro zip to some target directory. 
     
[10]: https://maven.apache.org/archetype/maven-archetype-plugin/index.html
[20]: https://picocli.info
[30]: http://maven.apache.org/plugins/maven-assembly-plugin