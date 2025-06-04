plugins {
    id("java")
    id("org.springframework.boot") version "3.5.0"

}

group = "com.github"
version = "1.0"

tasks.compileJava {
    sourceCompatibility = "24"
    targetCompatibility = "24"
}

tasks.wrapper {
    gradleVersion = "8.14.1"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.5.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.5.0")

    runtimeOnly("org.postgresql:postgresql:42.7.6")

    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
}


