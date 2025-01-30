// build.gradle.kts

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" // Ganti dengan versi yang sesuai
}

android {
    // Konfigurasi Android Anda
    composeOptions {
        kotlinCompilerExtensionVersion = "2.0.0" // Ganti dengan versi yang sesuai
    }
}


android {
    namespace = "com.example.catfacts"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.catfacts"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}




dependencies {
    // Menggunakan BOM untuk Compose
    implementation(platform("androidx.compose:compose-bom:2024.01.00"))

    // Dependensi Compose
    implementation("androidx.compose.ui:ui") // UI
    implementation("androidx.compose.material3:material3") // Material Design 3
    implementation("androidx.compose.ui:ui-tooling-preview") // UI Tooling Preview
    implementation("androidx.compose.ui:ui-test-manifest") // UI Test Manifest

    // Dependensi Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0") // Lifecycle
    implementation("androidx.activity:activity-compose:1.7.0") // Activity Compose

    // Dependensi Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Converter Gson
    // Tambahkan dependensi lain sesuai kebutuhan
}