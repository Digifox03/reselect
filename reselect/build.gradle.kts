plugins {
    id("fabric-loom")
    kotlin("jvm")
}

val modVersion: String by project
val mavenGroup: String by project
val minecraftVersion: String by project
val yarnMappings: String by project
val loaderVersion: String by project
val fabricVersion: String by project
val fabricKotlinVersion: String by project
val betterParseVersion: String by project
val archiveName: String by project

version = modVersion
group = mavenGroup

base {
    archivesName.set(archiveName)
}

dependencies {
    minecraft("com.mojang", "minecraft", minecraftVersion)
    mappings("net.fabricmc", "yarn", yarnMappings, classifier="v2")
    include(implementation("com.github.h0tk3y.betterParse", "better-parse-jvm", betterParseVersion))
    modImplementation("net.fabricmc", "fabric-loader", loaderVersion)
    modImplementation("net.fabricmc", "fabric-language-kotlin", fabricKotlinVersion)
    modImplementation(fabricApi.module("fabric-resource-loader-v0", fabricVersion))
}

java {
    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<ProcessResources> {
    inputs.property("version", modVersion)
    inputs.property("fabric_kotlin_version", fabricKotlinVersion)
    inputs.property("java_version", 17)
    filesMatching("fabric.mod.json") {
        expand(
            "version" to modVersion,
            "fabric_kotlin_version" to fabricKotlinVersion,
            "java_version" to 17
        )
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(17)
}

tasks.withType<Jar> {
    from("../COPYING") {
        rename { "${it}_${this@Build_gradle.archiveName}" }
    }
    from("../COPYING.LESSER") {
        rename { "${it}_${this@Build_gradle.archiveName}" }
    }
}
