import com.android.build.gradle.LibraryExtension
import com.wipro.movie.AndroidConfig
import com.wipro.movie.BuildPlugins
import com.wipro.movie.extensions.JDK_VERSION
import com.wipro.movie.extensions.configureFlavors
import com.wipro.movie.extensions.configureKotlinAndroid
import com.wipro.movie.extensions.kotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(BuildPlugins.ANDROID_LIBRARY)
                apply(BuildPlugins.KOTLIN_ANDROID)
                apply("movie.android.library.kover")
            }
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = AndroidConfig.TARGET_SDK
                configureFlavors(this)
                packaging {
                    resources.excludes.add("META-INF/LICENSE.md")
                    resources.excludes.add("META-INF/LICENSE-notice.md")
                }
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            configurations.configureEach {
                resolutionStrategy {
                    force(libs.findLibrary("junit.test").get())
                }
            }
            dependencies {
                add("testImplementation", kotlin("test"))
                add("testImplementation", project(":core:testing"))
                add("androidTestImplementation", kotlin("test"))
                add("androidTestImplementation", project(":core:testing"))
                add("detektPlugins", libs.findBundle("detekt").get())
            }
            kotlin {
                jvmToolchain(JDK_VERSION)
            }
        }
    }
}
