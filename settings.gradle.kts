pluginManagement {
    repositories {
        maven ("https://maven.aliyun.com/repository/google" )
        maven ("https://maven.aliyun.com/repository/gradle-plugin" )
        maven ("https://maven.aliyun.com/repository/public" )
        maven ("https://maven.aliyun.com/repository/jcenter" )
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven ("https://maven.aliyun.com/repository/google" )
        maven ("https://maven.aliyun.com/repository/gradle-plugin" )
        maven ("https://maven.aliyun.com/repository/public" )
        maven ("https://maven.aliyun.com/repository/jcenter" )
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidOpenGLDemo"
include(":app")
 