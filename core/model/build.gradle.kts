plugins {
    id("movie.android.library")
}

android {
    namespace = "com.wipro.movie.core.model"
}

dependencies {
    implementation(libs.coroutines)
}
