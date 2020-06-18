rootProject.name = "hibernate-ij-bug-reproduction"

pluginManagement {
    val kotlinVersion : String by settings
    val springBootVersion : String by settings
    val springDependencyManagementVersion : String by settings

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        kotlin("jvm") version kotlinVersion apply false
        kotlin("plugin.spring") version kotlinVersion apply false
        kotlin("plugin.jpa") version kotlinVersion apply false

        id("org.springframework.boot") version springBootVersion apply false
        id("io.spring.dependency-management") version springDependencyManagementVersion apply false
    }
}

include("common-persistence","domain","starter")
