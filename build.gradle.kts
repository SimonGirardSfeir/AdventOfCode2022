plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.9.2")
    testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks.test {
    useJUnitPlatform()
}