plugins {
    java
    id("io.qameta.allure")
}

dependencies {
    implementation(project(":common"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.codeborne:selenide:7.5.0")
    implementation("io.qameta.allure:allure-selenide:2.27.0")
    implementation("io.qameta.allure:allure-junit5:2.27.0")
    implementation("org.assertj:assertj-core:3.27.7")
}

tasks.register<Test>("smokeUi") {
    useJUnitPlatform {
        includeTags("smokeUi")
    }
    testClassesDirs = sourceSets["test"].output.classesDirs
    classpath = sourceSets["test"].runtimeClasspath
}