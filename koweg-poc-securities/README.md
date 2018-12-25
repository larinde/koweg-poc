#-- parent
mvn archetype:generate -DgroupId=com.koweg.poc -DartifactId=koweg-poc-securities -Dversion=1.0.0-SNAPSHOT -DpackageName=com.koweg.poc -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=pom-root -DarchetypeVersion=1.1 -DinteractiveMode=false

#-- API
----------------------
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DartifactId=accounting-rest-api  -DgroupId=com.koweg.poc.securities -Dversion=1.0.0-SNAPSHOT -Dpackage=com.koweg.poc.securities

