import version.Libs

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.walter.githubrepositories"
        minSdk = 21
        targetSdk = 31
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(Libs.coreKtx)
    implementation(Libs.appCompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)
    implementation(Libs.retrofit)
    implementation(Libs.koinAndroid)
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)
    implementation(Libs.pagingRuntime)
    implementation(Libs.okHttp3LoggingInterceptor)

    implementation(Libs.coil)
    implementation(Libs.gson)
    implementation(Libs.retrofitGsonConverter)

    implementation(Libs.roomRuntime)
    implementation(Libs.roomKtx)
    implementation(Libs.roomPaging)

    kapt(Libs.roomCompiler)

    testImplementation(Libs.jUnit)
    testImplementation(Libs.koinTest)
    testImplementation(Libs.mockitoCore)
    testImplementation(Libs.coroutinesTest)
    testImplementation(Libs.turbine)
}