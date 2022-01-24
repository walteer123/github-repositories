package version

object Libs {

    private const val retrofitVersion = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"

    private const val coreKtxVersion = "1.7.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val appCompatVersion = "1.4.0"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    private const val materialVersion = "1.4.0"
    const val material = "com.google.android.material:material:$materialVersion"

    private const val constraintLayoutVersion = "2.1.2"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"

    private const val jUnitVersion = "4.13.2"
    const val jUnit = "junit:junit:$jUnitVersion"
    
    private const val koinVersion = "3.1.5"
    const val koinAndroid = "io.insert-koin:koin-android:$koinVersion"
    const val koinTest = "io.insert-koin:koin-test:$koinVersion"

    private const val navVersion = "2.3.5"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navVersion"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navVersion"

    private const val pagingVersion = "3.1.0"
    const val pagingRuntime = "androidx.paging:paging-runtime:$pagingVersion"

    const val okHttp3LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:3.8.0"

    const val mockitoCore = "org.mockito:mockito-core:4.2.0"

    const val testRules = "androidx.test:rules:1.1.0"

    const val coil = "io.coil-kt:coil:1.4.0"
    const val gson = "com.google.code.gson:gson:2.8.9"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:2.8.1"

    const val roomRuntime = "androidx.room:room-runtime:2.4.1"
    const val roomKtx = "androidx.room:room-ktx:2.4.1"
    const val roomPaging = "androidx.room:room-paging:2.4.1"
    const val roomCompiler = "androidx.room:room-compiler:2.4.1"

    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0"
    const val turbine = "app.cash.turbine:turbine:0.7.0"

}
