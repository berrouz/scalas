package org.shev4ik.interview.docker_k8s.level1_basics

object DK001_DockerBasics {

  // ---- Domain types ----

  sealed trait Instruction
  case class From(image: String, tag: String = "latest", alias: Option[String] = None) extends Instruction
  case class Run(command: String) extends Instruction
  case class Copy(src: String, dest: String) extends Instruction
  case class Add(src: String, dest: String) extends Instruction
  case class Cmd(command: List[String]) extends Instruction
  case class Entrypoint(command: List[String]) extends Instruction
  case class Expose(port: Int) extends Instruction
  case class Env(key: String, value: String) extends Instruction
  case class Workdir(path: String) extends Instruction
  case class Label(key: String, value: String) extends Instruction

  case class DockerLayer(instruction: Instruction, sizeBytes: Long, cached: Boolean = false)
  case class DockerImage(name: String, tag: String, layers: List[DockerLayer])

  // ---- Exercise 1 ----
  // TODO: Calculate the total image size in bytes by summing all layer sizes.
  // Example: layers with sizes [100, 200, 300] => 600
  def totalImageSize(image: DockerImage): Long = ???

  // ---- Exercise 2 ----
  // TODO: Count the number of layers in a Dockerfile instruction list.
  // Each instruction becomes one layer. Return the total count.
  // Example: List(From("openjdk","11"), Run("apt-get update"), Copy(".",".")) => 3
  def countLayers(instructions: List[Instruction]): Int = ???

  // ---- Exercise 3 ----
  // TODO: Detect if a Dockerfile uses multi-stage build.
  // A multi-stage build has more than one FROM instruction.
  // Return true if there are 2+ FROM instructions.
  // Example: List(From("sbt","1.9",Some("builder")), Run("sbt assembly"), From("openjdk","11"), Copy("--from=builder ...","app.jar")) => true
  def isMultiStage(instructions: List[Instruction]): Boolean = ???

  // ---- Exercise 4 ----
  // TODO: Optimize layer ordering for better caching.
  // Reorder instructions so that COPY/ADD instructions come last (they change most often),
  // while preserving relative order within each group. FROM must always stay first.
  // Groups (in order): FROM, ENV, RUN, WORKDIR, EXPOSE, LABEL, ENTRYPOINT, CMD, COPY/ADD
  // Return the reordered instruction list.
  def optimizeLayerOrder(instructions: List[Instruction]): List[Instruction] = ???

  // ---- Exercise 5 ----
  // TODO: Calculate the effective image size after multi-stage build.
  // In a multi-stage build, only layers from the LAST stage contribute to the final image.
  // Split instructions at each FROM; take the last group and sum its layer sizes.
  // Use `layerSize` function to estimate: RUN=50MB, COPY=10MB, others=0.
  // Return size in bytes.
  def layerSize(instruction: Instruction): Long = instruction match {
    case _: Run  => 50 * 1024 * 1024L
    case _: Copy => 10 * 1024 * 1024L
    case _: Add  => 10 * 1024 * 1024L
    case _       => 0L
  }

  def multiStageEffectiveSize(instructions: List[Instruction]): Long = ???

  // ---- Exercise 6 ----
  // TODO: Merge consecutive RUN instructions into a single RUN instruction.
  // This reduces the number of layers. Combine commands with " && ".
  // Non-RUN instructions remain unchanged and break the merging sequence.
  // Example: List(Run("apt-get update"), Run("apt-get install -y curl"), Copy(".","."))
  //       => List(Run("apt-get update && apt-get install -y curl"), Copy(".","."))
  def mergeRunInstructions(instructions: List[Instruction]): List[Instruction] = ???

  // ---- Exercise 7 ----
  // TODO: Validate a Dockerfile instruction list. Return a list of error strings.
  // Rules:
  // - First instruction must be FROM (error: "First instruction must be FROM")
  // - Cannot have CMD and ENTRYPOINT both present (error: "Cannot have both CMD and ENTRYPOINT")
  // - EXPOSE port must be 1-65535 (error: "Invalid port: <port>")
  // - No duplicate ENV keys (error: "Duplicate ENV key: <key>")
  // Return empty list if valid.
  def validateDockerfile(instructions: List[Instruction]): List[String] = ???

  // ---- Exercise 8 ----
  // TODO: Calculate cache efficiency for a build.
  // Given an image with layers, compute what percentage of layers are cached.
  // Return as a Double between 0.0 and 1.0.
  // If there are no layers, return 0.0.
  // Example: 3 layers, 2 cached => 2.0/3.0 = 0.6667
  def cacheEfficiency(image: DockerImage): Double = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: totalImageSize
    val img1 = DockerImage("myapp", "1.0", List(
      DockerLayer(From("openjdk", "11"), 200000000),
      DockerLayer(Copy(".", "."), 5000000),
      DockerLayer(Run("sbt assembly"), 150000000)
    ))
    assert(totalImageSize(img1) == 355000000L)
    assert(totalImageSize(DockerImage("empty", "1.0", Nil)) == 0L)
    println("Exercise 1 passed: totalImageSize")

    // Exercise 2: countLayers
    val instrs = List(From("openjdk", "11"), Run("apt-get update"), Copy(".", "."), Cmd(List("java", "-jar", "app.jar")))
    assert(countLayers(instrs) == 4)
    assert(countLayers(Nil) == 0)
    println("Exercise 2 passed: countLayers")

    // Exercise 3: isMultiStage
    val singleStage = List(From("openjdk", "11"), Copy(".", "."))
    val multiStage = List(From("sbt", "1.9", Some("builder")), Run("sbt assembly"), From("openjdk", "11"), Copy(".", "."))
    assert(!isMultiStage(singleStage))
    assert(isMultiStage(multiStage))
    println("Exercise 3 passed: isMultiStage")

    // Exercise 4: optimizeLayerOrder
    val unoptimized = List(From("openjdk", "11"), Copy(".", "."), Run("apt-get update"), Env("APP_ENV", "prod"))
    val optimized = optimizeLayerOrder(unoptimized)
    assert(optimized.head == From("openjdk", "11"))
    assert(optimized.last == Copy(".", "."))
    println("Exercise 4 passed: optimizeLayerOrder")

    // Exercise 5: multiStageEffectiveSize
    val msInstrs = List(
      From("sbt", "1.9", Some("builder")), Run("sbt assembly"), Run("sbt test"),
      From("openjdk", "11"), Copy(".", ".")
    )
    assert(multiStageEffectiveSize(msInstrs) == 10 * 1024 * 1024L) // only the COPY in last stage
    println("Exercise 5 passed: multiStageEffectiveSize")

    // Exercise 6: mergeRunInstructions
    val unmerged = List(From("openjdk", "11"), Run("apt-get update"), Run("apt-get install -y curl"), Copy(".", "."), Run("chmod +x app"))
    val merged = mergeRunInstructions(unmerged)
    assert(merged == List(From("openjdk", "11"), Run("apt-get update && apt-get install -y curl"), Copy(".", "."), Run("chmod +x app")))
    println("Exercise 6 passed: mergeRunInstructions")

    // Exercise 7: validateDockerfile
    assert(validateDockerfile(List(From("openjdk", "11"), Run("echo hi"))).isEmpty)
    assert(validateDockerfile(List(Run("echo hi"))).contains("First instruction must be FROM"))
    assert(validateDockerfile(List(From("openjdk", "11"), Cmd(List("java")), Entrypoint(List("java")))).contains("Cannot have both CMD and ENTRYPOINT"))
    assert(validateDockerfile(List(From("openjdk", "11"), Expose(0))).contains("Invalid port: 0"))
    assert(validateDockerfile(List(From("openjdk", "11"), Env("A", "1"), Env("A", "2"))).contains("Duplicate ENV key: A"))
    println("Exercise 7 passed: validateDockerfile")

    // Exercise 8: cacheEfficiency
    val cachedImg = DockerImage("app", "1.0", List(
      DockerLayer(From("openjdk", "11"), 200000000, cached = true),
      DockerLayer(Run("apt-get update"), 50000000, cached = true),
      DockerLayer(Copy(".", "."), 5000000, cached = false)
    ))
    assert(math.abs(cacheEfficiency(cachedImg) - (2.0 / 3.0)) < 0.001)
    assert(cacheEfficiency(DockerImage("empty", "1.0", Nil)) == 0.0)
    println("Exercise 8 passed: cacheEfficiency")

    println("All DK001_DockerBasics exercises passed!")
  }
}
