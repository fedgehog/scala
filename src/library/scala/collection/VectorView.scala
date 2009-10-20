/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2003-2009, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

// $Id$


package scala.collection

import TraversableView.NoBuilder
import generic._

/** A non-strict projection of an iterable.
 *
 * @author Sean McDirmid
 * @author Martin Odersky
 * @version 2.8
 * @since   2.8
 */
trait VectorView[+A, +Coll] extends VectorViewLike[A, Coll, VectorView[A, Coll]]

object VectorView {
  type Coll = TraversableView[_, C] forSome {type C <: Traversable[_]}
  implicit def builderFactory[A]: BuilderFactory[A, VectorView[A, Vector[_]], Coll] = new BuilderFactory[A, VectorView[A, Vector[_]], Coll] { def apply(from: Coll) = new NoBuilder }
  implicit def arrBuilderFactory[A]: BuilderFactory[A, VectorView[A, Array[A]], TraversableView[_, Array[_]]] = new BuilderFactory[A, VectorView[A, Array[A]], TraversableView[_, Array[_]]] { def apply(from: TraversableView[_, Array[_]]) = new NoBuilder }
}