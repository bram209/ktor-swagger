

plugins {
    id("java-gradle-plugin")
//    id("kotlin-gradle-plugin-api") version "1.3.41"
//    kotlin("gradle-plugin-api") version "1.3.41"
    kotlin("jvm")
    kotlin("kapt")
    `maven-publish`
}

gradlePlugin {
    plugins {
        create("simplePlugin") {
            id = "com.github.bram209.ktor-swagger-plugin"
            implementationClass = "KtorSwaggerPlugin"
        }

    }
}

dependencies {
    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin-api:1.3.41")
    compileOnly("com.google.auto.service:auto-service:1.0-rc4")
    compile(project(":kotlin-plugin"))
    kapt("com.google.auto.service:auto-service:1.0-rc4")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}
