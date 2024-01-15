import com.wipro.movie.extensions.buildConfigStringField
import com.wipro.movie.extensions.getLocalProperty

plugins {
    id("movie.android.library")
    id("movie.android.hilt")
}

android {
    namespace = "com.wipro.movie.core.network"

    buildTypes.forEach {
        kotlin.runCatching {
            it.buildConfigStringField(
                com.wipro.movie.BuildConstants.CONFIG_NAME_API_BASE_URL,
                com.wipro.movie.BuildConstants.CONFIG_VALUE_API_BASE_URL,
            )
            it.buildConfigStringField(
                com.wipro.movie.BuildConstants.CONFIG_NAME_API_KEY,
                getLocalProperty(com.wipro.movie.BuildConstants.PROPERTY_NAME_API_KEY),
            )
        }.onFailure {
            throw InvalidUserDataException(com.wipro.movie.BuildConstants.MESSAGE_API_KEY_EXCEPTION)
        }
    }

    buildFeatures.buildConfig = true
}

dependencies {
    implementation(project(":core:common"))
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.kotlinx.serialization.converter)
}
