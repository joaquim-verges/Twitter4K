group = "com.joaquimverges.twitter4k"
version = "0.1"

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    val kotlinVersion = "1.5.0"
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.android.tools.build:gradle:7.0.0-beta03")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}