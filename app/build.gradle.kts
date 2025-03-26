plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.apollographql.apollo)
}

android {
    namespace = "com.example.aspenperform"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.aspenperform"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //graphql
    implementation(libs.apollo.runtime)
    implementation(libs.apollo.normalized.cache.sqlite)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

apollo {
    service("graphql") {
        srcDir("src/main/graphql")
        packageName.set("com.example.aspenperform")
        introspection {
            endpointUrl.set("https://countries.trevorblades.com/graphql")
        }
    }
    //./gradlew downloadApolloSchema --endpoint=https://countries.trevorblades.com/graphql --schema=app/src/main/graphql/schema.json// gentype
}