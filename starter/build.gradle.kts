plugins {
    id("org.springframework.boot")
}

val swaggerVersion : String by rootProject.extra

val developmentOnly : Configuration by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
}

dependencies {
    implementation(project(":domain"))

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter")
}

springBoot {
    buildInfo()
}
