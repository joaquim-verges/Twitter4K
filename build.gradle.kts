group = "com.joaquim"
version = "1.0"

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.4.32")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.4.32")
        classpath("com.android.tools.build:gradle:4.1.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}