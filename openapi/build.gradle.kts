apply("../gradle/kotlin.gradle")

val sourceSets = project.the<SourceSetContainer>()
sourceSets.create("generated")

dependencies {
    "implementation"(project(":domain"))

    // import JHipster dependencies BOM
    if (!project.hasProperty("gae")) {
        val jhipster_dependencies_version: String by project
        "generatedImplementation"(platform("io.github.jhipster:jhipster-dependencies:$jhipster_dependencies_version"))
        "implementation"(platform("io.github.jhipster:jhipster-dependencies:$jhipster_dependencies_version"))
    }
    "generatedImplementation"("javax.annotation:javax.annotation-api")
    "generatedImplementation"("com.fasterxml.jackson.core:jackson-annotations")
    "generatedImplementation"("org.springframework.boot:spring-boot-starter-web")
    "generatedImplementation"("org.springframework.boot:spring-boot-starter-tomcat")
    val kotlin_version: String by project
    "generatedImplementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    "generatedImplementation"("org.jetbrains.kotlin:kotlin-reflect:$kotlin_version")

    "implementation"("org.springframework.boot:spring-boot-starter-web")
    "implementation"("org.springframework.boot:spring-boot-starter-tomcat")
    "implementation"("org.springframework.boot:spring-boot-starter-tomcat")

    "compile"(sourceSets.getByName("generated").output)
}
