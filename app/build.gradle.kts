plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.uriecoral.onlineshop"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.uriecoral.onlineshop"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("com.github.bumptech.glide:glide:4.16.0") //for efficient loading images and smooth scrolling
    implementation("com.google.code.gson:gson:2.9.1") //java library for converting the java into json reps.
    implementation("com.airbnb.android:lottie:6.2.0") //for using lottie files like images, gif or so on
    implementation("com.google.firebase:firebase-database:20.3.0") //to utilize the Firebase db
    implementation("androidx.recyclerview:recyclerview:1.3.0") //display large sets of data like img and raw files
    implementation ("androidx.cardview:cardview:1.0.0") //it's 4sides widget controlling shadow, corner radius elevation etc.

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}