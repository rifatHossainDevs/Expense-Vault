plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    kotlin("kapt")
    alias(libs.plugins.safe.args)
}

android {
    namespace = "com.free.expense.manager.expensevault"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.free.expense.manager.expensevault"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Graph chart Library
    implementation(libs.mpandroidchart)

    //viewModel, Live Data
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)

    //sdp, ssp
    implementation(libs.sdp.android)
    implementation(libs.ssp.android)

    //room database
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
}