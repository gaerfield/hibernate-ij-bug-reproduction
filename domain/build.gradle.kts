plugins {
    kotlin("plugin.jpa")
}

dependencies {
    implementation(project(":common-persistence"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("com.h2database:h2")
}