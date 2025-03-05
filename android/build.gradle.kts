allprojects {
    repositories {
        google()
        jcenter()
        // mavenLocal()
        mavenCentral()
        // 阿里云 Maven 仓库
        maven {
//            url = uri("https://maven.aliyun.com/repository/google")
//            url = uri("https://maven.aliyun.com/repository/jcenter")
            url = uri("https://jitpack.io")
        }

    }
}

val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}
subprojects {
    project.evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
