import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

group = "com.ajdev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}


dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
    // Koin core para proyectos que no son Android
    implementation("io.insert-koin:koin-core:4.0.3")
    implementation("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")
    implementation("org.xerial:sqlite-jdbc:3.41.2.2")

    implementation("org.jetbrains.compose.ui:ui:1.5.0")
    implementation("org.jetbrains.compose.material:material:1.5.0")
    implementation("org.jetbrains.compose.material:material-icons-extended:1.5.0")
    implementation("org.jetbrains.compose.foundation:foundation:1.5.0")
    implementation("cafe.adriel.voyager:voyager-navigator:1.1.0-beta02")

    implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")

    implementation(project.dependencies.platform("io.github.jan-tennert.supabase:bom:1.3.2"))
    implementation("io.github.jan-tennert.supabase:postgrest-kt")
    implementation("io.github.jan-tennert.supabase:realtime-kt")
    implementation("io.github.jan-tennert.supabase:gotrue-kt")

}

compose.desktop {
    application {
        mainClass = "com.ajdev.artic.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "artic"
            packageVersion = "1.0.0"
        }
    }
}
