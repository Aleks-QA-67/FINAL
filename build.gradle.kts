plugins {
    java
    id("io.qameta.allure") version "2.12.0" apply false
}

allprojects {
    group = "com.smartshop.finalproject"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

// Общая задача smoke
tasks.register("smokeAll") {
    group = "verification"
    description = "Run all smoke tests (API + UI)"
    dependsOn(":api-tests:smokeApi", ":ui-tests:smokeUi")
}