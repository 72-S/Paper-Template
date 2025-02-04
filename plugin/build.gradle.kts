plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.6"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
}

dependencies {
    implementation(project(":common"))
    implementation(project(":v1_19"))
    implementation(project(":v1_20"))
    implementation(project(":v1_21"))

    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
}

bukkit {
    name = "Paper-Template"
    main = "dev.consti.template.Main"
    version = project.version.toString()
    authors = listOf("72-S")
    description = "A multi-version compatible Paper plugin"
}


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

    // minimize()
}

