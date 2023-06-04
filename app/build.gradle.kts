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

        testInstrumentationRunner = "com.example.androidappbasic.features.core.CustomTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.runner)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // dagger implementation
    implementation(libs.dagger)
    implementation(libs.dagger.android)
    implementation(libs.dagger.test)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    kapt(libs.dagger.compiler)
    kapt(libs.dagger.processor)
    kaptTest(libs.dagger.processor)

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


    // test
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.android)
    testImplementation( libs.kotlinx.coroutines.test)
    kaptTest (libs.dagger.test)
    kaptAndroidTest( libs.dagger.android.testing)
}