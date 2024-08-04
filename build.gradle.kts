plugins {
    kotlin("jvm") version "2.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    // Logging
    implementation("io.github.microutils:kotlin-logging:1.4.6")
    implementation("org.slf4j:slf4j-simple:1.7.25")

    // For tests in Examples
    implementation(kotlin("test"))

    // For tests in Tests
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.platform:junit-platform-launcher")
    testImplementation("org.junit.platform:junit-platform-engine")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}