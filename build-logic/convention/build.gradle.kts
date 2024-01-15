plugins {
    `kotlin-dsl`
}

group = "com.wipro.movie.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.plugin)
    implementation(libs.ksp.gradle.plugin)
    implementation(libs.detekt.plugin)
    implementation(libs.javapoet.plugin)
    implementation(libs.navigation.safeargs.plugin)
    implementation(libs.kotlinx.kover.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "movie.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidHilt") {
            id = "movie.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "movie.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }

        register("androidLibrary") {
            id = "movie.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "movie.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("detekt") {
            id = "movie.detekt"
            implementationClass = "DetektConventionPlugin"
        }
        register("androidKoverLibrary") {
            id = "movie.android.library.kover"
            implementationClass = "AndroidLibraryKoverConventionPlugin"
        }
        register("androidKoverApplication") {
            id = "movie.android.application.kover"
            implementationClass = "AndroidApplicationKoverConventionPlugin"
        }
    }
}
