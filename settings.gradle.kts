pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "clean_architecture"
include(":app")
include(":data")
include(":domain")
include(":feature_1")
include(":feature_2")
include(":core:navigation")
include(":core:di")
include(":features")
include(":features:feature_first")
include(":features:feature_first_api")
include(":features:feature_second")
include(":features:feature_second_api")
