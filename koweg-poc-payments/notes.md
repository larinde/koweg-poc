#-- parent
mvn archetype:generate -DgroupId=com.koweg.poc -DartifactId=koweg-poc-payments -Dversion=1.0.0-SNAPSHOT -DpackageName=com.koweg.poc -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=pom-root -DarchetypeVersion=1.1 -DinteractiveMode=false

#-- API
----------------------
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DartifactId=koweg-poc-payment-api  -DgroupId=com.koweg.poc.payments -Dversion=1.0.0-SNAPSHOT -Dpackage=com.koweg.poc.payments

preacher
legion


https://start.spring.io/starter.zip?name=koweg-poc-service&groupId=com.koweg.poc&artifactId=koweg-poc-service&version=0.0.1-SNAPSHOT&description=koweg-poc-service&packageName=com.koweg.poc.payments&type=maven-project&packaging=jar&javaVersion=1.8&language=java&bootVersion=2.1.1.RELEASE&dependencies=cloud-eureka&dependencies=integration&dependencies=h2&dependencies=data-jpa&dependencies=web
