plugins {
    id("com.android.application") version "7.0.0" apply false
    id("org.jetbrains.kotlin.android") version "1.5.31" apply false
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
