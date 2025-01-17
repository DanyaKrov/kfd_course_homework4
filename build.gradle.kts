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
    implementation ("org.jetbrains.kotlin:kotlin-reflect:2.0.0")
    implementation ("org.jetbrains.kotlin:kotlin-reflect:1.3.61")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
}