import com.android.build.api.dsl.ApplicationExtension
import com.wipro.movie.AndroidConfig
import com.wipro.movie.BuildPlugins
import com.wipro.movie.BuildTypeDebug
import com.wipro.movie.BuildTypeRelease
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

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(BuildPlugins.ANDROID_APPLICATION)
                apply(BuildPlugins.KOTLIN_ANDROID)
                apply(BuildPlugins.NAVIGATION_SAFEARGS)
                apply(BuildPlugins.KOTLINX_SERIALIZATION)
            }
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                configureFlavors(this)
                defaultConfig.applicationId = AndroidConfig.APP_ID
                defaultConfig.targetSdk = AndroidConfig.TARGET_SDK
                defaultConfig.versionCode = AndroidConfig.VERSION_CODE
                defaultConfig.versionName = AndroidConfig.VERSION_NAME
                buildTypes {
                    BuildTypeDebug.create(this, signingConfigs)
                    BuildTypeRelease.create(this, signingConfigs)
                }
                packaging {
                    resources.excludes.add("META-INF/AL2.0")
                    resources.excludes.add("META-INF/LGPL2.1")
                    resources.excludes.add("META-INF/LICENSE.md")
                    resources.excludes.add("META-INF/LICENSE-notice.md")
                }
                namespace = AndroidConfig.NAMESPACE
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("detektPlugins", libs.findBundle("detekt").get())
                add("testImplementation", kotlin("test"))
                add("testImplementation", project(":core:testing"))
                add("androidTestImplementation", kotlin("test"))
                add("androidTestImplementation", project(":core:testing"))
            }
            kotlin {
                jvmToolchain(JDK_VERSION)
            }
        }
    }
}
