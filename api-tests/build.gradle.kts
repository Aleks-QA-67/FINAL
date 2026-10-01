plugins {
    java
    id("io.qameta.allure")
}

dependencies {
    implementation(project(":common"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("io.rest-assured:rest-assured:5.5.6")
    testImplementation("io.qameta.allure:allure-rest-assured:2.27.0")
    testImplementation("io.qameta.allure:allure-junit5:2.27.0")
    testImplementation("org.assertj:assertj-core:3.27.7")
}

tasks.register<Test>("smokeApi") {
    useJUnitPlatform {
        includeTags("smokeApi")
    }
    testClassesDirs = sourceSets["test"].output.classesDirs
    classpath = sourceSets["test"].runtimeClasspath
}