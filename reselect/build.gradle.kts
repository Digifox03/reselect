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
val archiveName: String by project

version = modVersion
group = mavenGroup

base {
    archivesName.set(archiveName)
}

dependencies {
    minecraft("com.mojang", "minecraft", minecraftVersion)
    mappings("net.fabricmc", "yarn", yarnMappings, classifier="v2")
    implementation("com.github.h0tk3y.betterParse", "better-parse", "0.4.2")
    modImplementation("net.fabricmc", "fabric-loader", loaderVersion)
    modImplementation("net.fabricmc", "fabric-language-kotlin", fabricKotlinVersion)
    modImplementation(fabricApi.module("fabric-resource-loader-v0", fabricVersion))
}

java {
    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}

tasks.withType<ProcessResources> {
    inputs.property("version", modVersion)
    filesMatching("fabric.mod.json") {
        expand("version" to modVersion)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(16)
}

tasks.withType<Jar> {
    from("../COPYING") {
        rename { "${it}_${this@Build_gradle.archiveName}" }
    }
    from("../COPYING.LESSER") {
        rename { "${it}_${this@Build_gradle.archiveName}" }
    }
}
