name := "NekonoteForSchool"

version := "1.0-SNAPSHOT"


net.virtualvoid.sbt.graph.Plugin.graphSettings

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  filters,
  "com.sun.mail" % "javax.mail" % "1.5.2",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "com.amazonaws" % "aws-java-sdk" % "1.8.9.1",
  "com.itextpdf" % "itextpdf" % "5.5.3",
  "com.itextpdf" % "itext-asian" % "5.2.0",
  "org.fluentd" % "fluent-logger" % "0.3.1",
  "org.apache.commons" % "commons-lang3" % "3.3.2",
  "jp.webpay" % "webpay" % "2.2.2"
)

play.Project.playJavaSettings

mappings in Universal ++= {
  val dataDirectory = baseDirectory(_ / "data").value
  val dataDirectoryLen = dataDirectory.getCanonicalPath.length
  (dataDirectory ** "*").get.map { f: File =>
    f -> ("data/" + f.getCanonicalPath.substring(dataDirectoryLen))
  }
}