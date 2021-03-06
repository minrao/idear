buildscript {
    repositories {
        maven { setUrl("http://dl.bintray.com/jetbrains/intellij-plugin-service") }
    }

    dependencies {
    	classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.21")
    }
}

plugins {
    id("org.jetbrains.intellij") version "0.2.18"
    id("org.jetbrains.kotlin.jvm") version "1.2.30"
}

intellij {
    pluginName = "idear"
    updateSinceUntilBuild = false
    setPlugins("acejump:3.3.5")
}

group = "org.openasr"
version = "1.3.3"

repositories {
    jcenter()
    maven { setUrl("https://oss.sonatype.org/content/repositories/releases/") }
    maven { setUrl("https://oss.sonatype.org/content/repositories/snapshots/") }
}

dependencies {
    compile("net.sourceforge.javaflacencoder:java-flac-encoder:0.3.7")
    compile("edu.cmu.sphinx:sphinx4-core:5prealpha-SNAPSHOT")
    compile("com.mashape.unirest:unirest-java:1.4.7")
    compile("org.codehaus.jettison:jettison:1.3.7")
    compile("de.dfki.mary:voice-cmu-slt-hsmm:5.2")
    compile("com.amazonaws:aws-java-sdk-cognitoidentity:1.11.160")
    compile("com.amazonaws:aws-java-sdk-lex:1.11.160")
    compile("com.amazonaws:aws-java-sdk-polly:1.11.160")
    compile("com.googlecode.soundlibs:jlayer:1.0.1-1")
    compile("com.google.cloud:google-cloud-speech:0.17.1-alpha")
    testCompile("junit:junit:4.12")
}