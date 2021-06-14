Running `sbt clean compile` succeeds (it shouldn't). Making any change to `Tester.scala` (e.g. a whitespace change) and running `sbt compile` (incrementally) fails with the expected error. 
Desired behavior: a full compile should fail with the same error.
The same behavior obtains with warnings if I don't specify -Xfatal-warnings.

```
[danarmak@smilodon scala-testwarning-repro]$ sbt clean compile
[info] welcome to sbt 1.5.4 (Oracle Corporation Java 1.8.0_292)
[info] loading global plugins from /home/danarmak/.sbt/1.0/plugins
[info] loading project definition from /home/danarmak/test/scala-testwarning-repro/project
[info] loading settings for project scala-testwarning-repro from build.sbt ...
[info] set current project to testwarning (in build file:/home/danarmak/test/scala-testwarning-repro/)
[info] Executing in batch mode. For better performance use sbt's shell
[success] Total time: 0 s, completed Jun 14, 2021 7:19:33 PM
[info] compiling 2 Scala sources to /home/danarmak/test/scala-testwarning-repro/target/scala-2.12/classes ...
[success] Total time: 2 s, completed Jun 14, 2021 7:19:35 PM
[danarmak@smilodon scala-testwarning-repro]$ echo >> src/main/scala/testwarning/Tester.scala 
[danarmak@smilodon scala-testwarning-repro]$ sbt compile
[info] welcome to sbt 1.5.4 (Oracle Corporation Java 1.8.0_292)
[info] loading global plugins from /home/danarmak/.sbt/1.0/plugins
[info] loading project definition from /home/danarmak/test/scala-testwarning-repro/project
[info] loading settings for project scala-testwarning-repro from build.sbt ...
[info] set current project to testwarning (in build file:/home/danarmak/test/scala-testwarning-repro/)
[info] Executing in batch mode. For better performance use sbt's shell
[info] compiling 1 Scala source to /home/danarmak/test/scala-testwarning-repro/target/scala-2.12/classes ...
[error] /home/danarmak/test/scala-testwarning-repro/src/main/scala/testwarning/Tester.scala:6:13: fruitless type test: a value of type testwarning.Trait1 cannot also be a testwarning.Trait3
[error]     case z: Trait3 => "Also Trait3"
[error]             ^
[error] one error found
[error] (Compile / compileIncremental) Compilation failed
[error] Total time: 1 s, completed Jun 14, 2021 7:19:51 PM
```

