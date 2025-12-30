import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.testImplementation
import org.jetbrains.kotlin.gradle.internal.types.error.ErrorModuleDescriptor.platform

val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.2.21"
    id("io.ktor.plugin") version "3.3.2"
}

group = "dev.folomkin"
version = "0.0.1"

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
//    implementation("io.ktor:ktor-server-netty")
//    implementation("ch.qos.logback:logback-classic:$logback_version")
//    implementation("io.ktor:ktor-server-core")
//    implementation("io.ktor:ktor-server-config-yaml")
//    testImplementation("io.ktor:ktor-server-test-host")
//    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

//    implementation("io.ktor:ktor-server-status-pages")


// Замените $ktor_version на актуальную версию Ktor [1].
    // Added new dependency
    implementation(libs.ktor.server.status.pages)
    // Existing dependencies
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)

    // Основные тесты Ktor (содержит функцию testApplication)
    testImplementation(libs.ktor.server.test.host)
    // Интеграция Kotlin с JUnit
    testImplementation(libs.kotlin.test.junit5)

    // Другие библиотеки
//    implementation(libs.exposed.core)
//    implementation(libs.postgresql)
}

tasks.test {
    useJUnitPlatform()
}