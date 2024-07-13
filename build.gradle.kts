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
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}