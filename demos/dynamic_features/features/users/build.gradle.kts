import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.dynamic-feature")
    kotlin("android")
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

android {
    defaultConfig {
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug")
    }
}

dependencies {
    implementation(project(autoModules.app))

    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.navigationDynamic)
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUI)
}
