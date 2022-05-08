//import com.google.protobuf.gradle.*
import org.apache.tools.ant.filters.ReplaceTokens
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposedVersion: String by project

// gRPC required
val protobuf_version: String by project
val grpc_version: String by project
val grpc_kotlin_version: String by project

plugins {
    application
    kotlin("jvm") version "1.6.21"
        id("org.jetbrains.kotlin.plugin.serialization") version "1.6.21"
//  gRPC required
//    id("com.google.protobuf") version "0.8.15"
    idea
}

group = "br.com.ume"
version = "0.0.1"

// gRPC required: exclude already created protos on build
//tasks {
//    withType<Copy> {
//        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//    }
//
//    copy {
//        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//    }
//}

application {
    mainClass.set("br.com.ume.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}


dependencies {
    implementation( project(":grpc") )

    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

    implementation("org.postgresql:postgresql:42.2.10")


    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

//  gRPC required
    implementation("io.grpc:grpc-kotlin-stub:$grpc_kotlin_version")
    implementation("io.grpc:grpc-protobuf:$grpc_version")
    implementation("com.google.protobuf:protobuf-kotlin:$protobuf_version")

    runtimeOnly("io.grpc:grpc-netty:$grpc_version")
}

// gRPC required
//sourceSets {
//    main {
//        proto {
//            srcDir("src/main/proto")
//        }
//    }
//}

// gRPC required
//protobuf {
//    protoc {
//        artifact = "com.google.protobuf:protoc:$protobuf_version"
//    }
//    plugins {
//        id("grpc") {
//            artifact = "io.grpc:protoc-gen-grpc-java:$grpc_version"
//        }
//        id("grpckt") {
//            artifact = "io.grpc:protoc-gen-grpc-kotlin:$grpc_kotlin_version:jdk7@jar"
//        }
//    }
//    generateProtoTasks {
//        all().forEach {
//            it.plugins {
//                id("grpc")
//                id("grpckt")
//            }
//            it.builtins {
//                id("kotlin")
//            }
//        }
//    }
//}
//
//// gRPC required
//idea {
//    module {
//        sourceDirs.plusAssign(file("${projectDir}/build/generated/source/proto/main/kotlin"))
//        sourceDirs.plusAssign(file("${projectDir}/build/generated/source/proto/main/grpckt"))
//    }
//}
//
