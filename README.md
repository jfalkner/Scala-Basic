# Basic Scala Project

Just the basics here to support the code, tests, coverage and deployable JAR. Fork this to start your own repo.

```
# Run the latest code
sbt clean run

# Do a full new compile, test and coverage report
sbt clean coverage test coverageReport
```

Above are it. The second task will produce reports that support code review and continuous integration. Examples are saved in the `example_artifacts` directory.

- Example output from `sbt clean coverage test coverageReport`
- Test report in HTML and JUnit XML.
- Coverage report in HTML, scoverage and clover.

See also loading and running this in IntelliJ. You'll then be able to run the code with a right-click "Run" on Main.scala.

# Make a deploy

If you are in a production environment, you'll probably want to distribute a JAR. 

```
# make a deployable JAR
sbt pack

# Run the JAR via JDK. No need for SBT anymore
java -jar target/*/libs/example*.jar

# Run with more memory or other JVM options
java -Xmx2G -jar target/*/libs/example*.jar
```
