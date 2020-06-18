import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springBootVersion : String by extra

plugins {
    kotlin("jvm") apply false
    kotlin("plugin.spring") apply false
    id("io.spring.dependency-management") apply false
}

allprojects {
    group = "io.payfree.server"
    // version = versionDetails().version
    version = System.getenv("SHORT_SHA") ?: "dev"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
    }

    dependencies {
        "implementation"(platform( "org.jetbrains.kotlin:kotlin-bom"))
        "implementation"("org.jetbrains.kotlin:kotlin-reflect")
        "implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        "implementation"(platform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))
        "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin")
    }
}
