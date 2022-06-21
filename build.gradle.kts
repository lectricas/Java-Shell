plugins {
    java
    application
}

application {
    mainClass.set("parser.Bash")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:20.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("org.antlr:antlr4-runtime:4.10.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}