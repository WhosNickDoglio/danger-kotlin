import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  kotlin("jvm")
  alias(libs.plugins.mavenPublish)
  alias(libs.plugins.shadowJar)
}

dependencies {
  api(libs.kotlin.main.kts)

  implementation(libs.kotlin.stdlib.jdk8)
  implementation(libs.kotlin.script.runtime)
  implementation(libs.kotlinx.coroutines.core)
}

tasks.named<ShadowJar>("shadowJar") { archiveBaseName = "danger-kotlin-kts" }

kotlin { compilerOptions { jvmTarget = JvmTarget.JVM_1_8 } }

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}
