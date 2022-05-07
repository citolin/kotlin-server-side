import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.google.protobuf.gradle.*
import org.jetbrains.kotlin.js.inline.clean.removeDuplicateImports

val protobuf_version: String by project
val grpc_version: String by project
val grpc_kotlin_version: String by project


plugins {
    kotlin("jvm") version "1.6.20"
    id("com.google.protobuf") version "0.8.15"
    idea
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks {
    withType<Copy> {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
}


dependencies {
    implementation("io.grpc:grpc-kotlin-stub:$grpc_kotlin_version")
    implementation("io.grpc:grpc-protobuf:$grpc_version")
    implementation("com.google.protobuf:protobuf-kotlin:$protobuf_version")

    runtimeOnly("io.grpc:grpc-netty:$grpc_version")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

sourceSets {
    main {
        proto {
            srcDir("src/main/proto")
        }
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobuf_version"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpc_version"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:$grpc_kotlin_version:jdk7@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
            it.builtins {
                id("kotlin")
            }
        }
    }
}


idea {
    module {
        sourceDirs.plusAssign(file("${projectDir}/build/generated/source/proto/main/kotlin"))
        sourceDirs.plusAssign(file("${projectDir}/build/generated/source/proto/main/grpckt"))
    }
}
