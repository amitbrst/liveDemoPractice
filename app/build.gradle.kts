plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")

}

android {
    namespace = "com.pretty.myprettyliveapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pretty.myprettyliveapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            buildConfigField ("String", "MIDTRANS_API", "\"https://app.sandbox.midtrans.com/snap/v1\"")
        }

        release {
            buildConfigField ("String", "MIDTRANS_API", "\"https://app.sandbox.midtrans.com/snap/v1\"")
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            buildConfigField("boolean", "DEBUG", "false")

        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.4")

    val lifecycle_version = "2.6.2"
    // - - ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // - - LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    // - - Retrofit2
    val retrofit_version = "2.9.0"
    val logging_version = "4.3.1"
    implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofit_version")
    //noinspection GradleDependency
    implementation ("com.squareup.okhttp3:okhttp:$logging_version")
    implementation ("com.squareup.okhttp3:logging-interceptor:$logging_version")

}