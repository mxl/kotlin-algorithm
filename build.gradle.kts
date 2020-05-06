plugins {
    kotlin("multiplatform") version "1.3.72"
}

group = "pro.ledin"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations {
            val main by getting {
                defaultSourceSet {
                    dependencies {
                        implementation(kotlin("stdlib-jdk8"))
                    }
                }
            }
            val test by getting {
                dependencies {
                    implementation(kotlin("test-junit"))
                }
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }

    targets.all {
        compilations.all {
            kotlinOptions {
                allWarningsAsErrors = true
            }
        }
    }
}

tasks.withType<Test> {
    this.testLogging {
        this.showStandardStreams = true
    }
}