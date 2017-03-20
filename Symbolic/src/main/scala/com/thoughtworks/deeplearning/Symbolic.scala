package com.thoughtworks.deeplearning

import com.qifun.statelessFuture.Future
import com.thoughtworks.deeplearning.Layer.Tape

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
object Symbolic {
  object Layers {

    final case class Literal[Data0](value0: Data0) extends Layer with Tape {
      override type Data = Data0
      override type Delta = Any
      override type Input = Tape
      override type Output = Tape.Aux[Data, Delta]

      override def value: Data = value0

      override def forward(input: Input) = Future(this)

      override def isTrainable: Boolean = false

      override def forceBackward(delta: Delta) = Future(())

      override def close(): Unit = {}

      override def duplicate() = this
    }
  }
}
