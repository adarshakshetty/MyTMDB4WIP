import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import com.wipro.movie.utils.VersionUtils.isNonStable

plugins {
    alias(libs.plugins.ktlint)
    alias(libs.plugins.versions)
    alias(libs.plugins.hilt).apply(false)
    alias(libs.plugins.kotlin.serialization).apply(false)
    alias(libs.plugins.ksp).apply(false)
    alias(libs.plugins.kotlin.jvm).apply(false)
    alias(libs.plugins.kotlinx.kover).apply(false)
    alias(libs.plugins.module.graph.assertion).apply(true)
    id("movie.detekt").apply(false)
    id("jvm-ecosystem")
}

allprojects {
    plugins.apply("movie.detekt")
    plugins.apply("org.jlleitschuh.gradle.ktlint")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}

moduleGraphAssert {
    maxHeight = 4
}
