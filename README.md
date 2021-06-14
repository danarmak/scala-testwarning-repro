Running `sbt clean compile` succeeds (it shouldn't). Making any change to `Tester.scala` (e.g. a whitespace change) and running `sbt compile` (incrementally) fails with the expected error. 
Desired behavior: a full compile should fail with the same error.
The same behavior obtains with warnings if I don't specify -Xfatal-warnings.
This happens with scala 2.13.6 and 2.12.4 both.

```
[danarmak@smilodon scala-testwarning-repro]$ sbt clean compile
[info] welcome to sbt 1.5.4 (Oracle Corporation Java 1.8.0_292)
[info] loading global plugins from /home/danarmak/.sbt/1.0/plugins
[info] loading project definition from /home/danarmak/test/scala-testwarning-repro/project
[info] loading settings for project scala-testwarning-repro from build.sbt ...
[info] set current project to testwarning (in build file:/home/danarmak/test/scala-testwarning-repro/)
[info] Executing in batch mode. For better performance use sbt's shell
[success] Total time: 0 s, completed Jun 14, 2021 7:24:37 PM
[info] compiling 2 Scala sources to /home/danarmak/test/scala-testwarning-repro/target/scala-2.13/classes ...
[success] Total time: 2 s, completed Jun 14, 2021 7:24:39 PM
[danarmak@smilodon scala-testwarning-repro]$ echo >> src/main/scala/testwarning/Tester.scala 
[danarmak@smilodon scala-testwarning-repro]$ sbt compile
[info] welcome to sbt 1.5.4 (Oracle Corporation Java 1.8.0_292)
[info] loading global plugins from /home/danarmak/.sbt/1.0/plugins
[info] loading project definition from /home/danarmak/test/scala-testwarning-repro/project
[info] loading settings for project scala-testwarning-repro from build.sbt ...
[info] set current project to testwarning (in build file:/home/danarmak/test/scala-testwarning-repro/)
[info] Executing in batch mode. For better performance use sbt's shell
[info] compiling 1 Scala source to /home/danarmak/test/scala-testwarning-repro/target/scala-2.13/classes ...
[error] /home/danarmak/test/scala-testwarning-repro/src/main/scala/testwarning/Tester.scala:5:13: fruitless type test: a value of type testwarning.Trait1 cannot also be a testwarning.Trait2
[error]     case y: Trait2 => "Also Trait2"
[error]             ^
[error] one error found
[error] (Compile / compileIncremental) Compilation failed
[error] Total time: 1 s, completed Jun 14, 2021 7:24:57 PM
```

