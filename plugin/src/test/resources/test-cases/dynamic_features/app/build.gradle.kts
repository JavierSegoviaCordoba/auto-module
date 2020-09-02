import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    id("androidx.navigation.safeargs.kotlin")
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

android {
    dynamicFeatures = with(autoModules.features) { mutableSetOf(users.path, userDetail.path) }

    defaultConfig {
        applicationId = "com.javiersc.dynamicFeatures"
        minSdkVersion(21)
        targetSdkVersion(30)
        compileSdkVersion(30)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures.viewBinding = true

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug")
    }
}

dependencies {
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.navigationDynamic)
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUI)
    api(Dependencies.playCore)
}
