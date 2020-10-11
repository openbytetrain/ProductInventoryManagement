apply("../gradle/kotlin.gradle")

dependencies {
    "api"(platform(project(":platform")))

    if (!project.hasProperty("gae")) {
        val jhipster_dependencies_version: String by project
        "implementation"(platform("io.github.jhipster:jhipster-dependencies:$jhipster_dependencies_version"))
    }

    "implementation"("org.springframework.boot:spring-boot-starter-mail")
    "implementation"("org.springframework.boot:spring-boot-starter-logging")
    "implementation"("org.springframework.boot:spring-boot-starter-actuator")
    "implementation"("org.springframework.boot:spring-boot-starter-aop")
    "implementation"("org.springframework.boot:spring-boot-starter-data-mongodb")

    "api"("org.mapstruct:mapstruct")
}
