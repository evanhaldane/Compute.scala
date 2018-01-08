package com.thoughtworks.expressions

import org.scalatest._
import com.thoughtworks.feature.Factory
import shapeless.{Sized, Witness}
import shapeless.nat._

/**
  * @author 杨博 (Yang Bo)
  */
class ExpressionsSpec extends FreeSpec with Matchers {

  "fill" in {

    val hyperparameters: BuiltIns { type DebuggingInformation = Debugging.Name } = {
      Factory[BuiltIns].newInstance()
    }

    import hyperparameters._

    val x: float.Identifier = float.Identifier()
    val sourceCode = generateOpenCLKernelSourceCode("fill", Seq(x), Seq(x)).mkString
    println(sourceCode) // FIXME: replace println to a scalatest assertion

  }

  "id" in {

    val hyperparameters = Factory[BuiltIns].newInstance()

    import hyperparameters._

    val floatArray3d = ArrayBufferType(float, Seq(32, 32, 32))
    val x: floatArray3d.Identifier = floatArray3d.Identifier()

    val sourceCode = generateOpenCLKernelSourceCode("id", Seq(x), Seq(x.extract)).mkString

    println(sourceCode) // FIXME: replace println to a scalatest assertion

  }

}
