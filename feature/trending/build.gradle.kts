plugins {
    id("movie.android.feature")
}

android {
    namespace = "com.wipro.movie.feature.trending"
}

dependencies {
    implementation(libs.androidx.paging)
    implementation(libs.androidx.swiperefreshlayout)
}
