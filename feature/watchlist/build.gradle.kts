plugins {
    id("movie.android.feature")
}

android {
    namespace = "com.wipro.movie.feature.watchlist"
}

dependencies {
    implementation(libs.androidx.paging)
}
