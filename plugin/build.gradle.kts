plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.6"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
}

dependencies {
    // Includes all the modules
    implementation(project(":common"))
    implementation(project(":v1_19"))
    implementation(project(":v1_20"))
    implementation(project(":v1_21"))

    // compileOnly because paper provides it at runtime and it should not get included in the jar
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
}

// Generating the plugin.yml
bukkit {
    name = "Paper-Template"
    main = "dev.consti.template.Main"
    version = project.version.toString()
    apiVersion = "1.19" 
    authors = listOf("72-S")
    description = "A multi-version compatible Paper plugin"
}

// Some shadowJar configurations to shade all modules in a jar
tasks.shadowJar {
    archiveBaseName.set("Paper-Template")
    archiveClassifier.set("")
    archiveVersion.set(project.version.toString())

    dependencies {
        include(project(":common"))
        include(project(":v1_19"))
        include(project(":v1_20"))
        include(project(":v1_21"))
    }

}

