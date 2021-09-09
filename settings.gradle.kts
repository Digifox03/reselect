rootProject.name = "reselect"
include("reselect")

pluginManagement {
    val loomVersion: String by settings
    val kotlinVersion: String by settings

    repositories {
        maven {
            name = "Fabric"
            url = uri("https://maven.fabricmc.net/")
        }
        gradlePluginPortal()
    }
    plugins {
        id("fabric-loom") version loomVersion
        kotlin("jvm") version kotlinVersion
    }
}