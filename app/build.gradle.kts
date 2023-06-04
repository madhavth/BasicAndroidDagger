@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinKapt)
}

android {
    namespace = "com.example.androidappbasic"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.androidappbasic"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // dagger implementation
    implementation(libs.dagger)
    implementation(libs.dagger.android)
    implementation(libs.dagger.test)
    kapt(libs.dagger.compiler)
    kapt(libs.dagger.processor)

    // retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.moshi)
    implementation(libs.logging.interceptor)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.okhttp)
    implementation(libs.okhttp.urlconnection)
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    // lifecycle scopes and services
    kapt(libs.androidx.lifecycle.compiler)

    // lifecycle viewmodel ktx
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    implementation(libs.androidx.lifecycle.viewmodel)

    implementation(libs.androidx.lifecycle.service)

    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation(libs.androidx.lifecycle.process)

    // optional - Test helpers for LiveData
    testImplementation(libs.androidx.core.testing)

    // optional - Test helpers for Lifecycle runtime
    testImplementation(libs.androidx.lifecycle.runtime.testing)

    // activity lifecycle scope
    implementation(libs.androidx.lifecycle.runtime.ktx)
}