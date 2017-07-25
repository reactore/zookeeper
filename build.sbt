name := "zk-config-server"

version := "1.0"

scalaVersion := "2.11.8"

//libraryDependencies += "org.apache.curator" % "curator-framework" % "2.7.0"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"
libraryDependencies += "org.apache.zookeeper" % "zookeeper" % "3.4.9"