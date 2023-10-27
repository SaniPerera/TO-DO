plugins {
	java
	id("org.springframework.boot") version "2.7.17"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	id ("org.openapi.generator" )version "6.6.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

task buildApiDoctype( org.openapitools.generator.gradle.plugin.tasks.GenerateTask) {
	generatorName("html2")
	inputSpec ("$rootDir/src/main/resource/api-schema.yaml").toString()
	outputDir  ("$buildFile/apidoc").toString()
}
