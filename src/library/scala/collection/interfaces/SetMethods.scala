/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2003-2009, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

package scala.collection.interfaces

import scala.collection._
import generic._
import mutable.Buffer
import scala.reflect.ClassManifest
import annotation.unchecked.uncheckedVariance

trait AddableMethods[A, +This <: Addable[A, This]] {
  protected def repr: This
  def +(elem: A): This
  def + (elem1: A, elem2: A, elems: A*): This
  def ++ (elems: Traversable[A]): This
  def ++ (iter: Iterator[A]): This
}

trait SubtractableMethods[A, +This <: Subtractable[A, This]] {
  protected def repr: This
  def -(elem: A): This
  def -(elem1: A, elem2: A, elems: A*): This
  def --(elems: Traversable[A]): This
  def --(iter: Iterator[A]): This
}

trait SetMethods[A, +This <: SetTemplate[A, This] with Set[A]]
extends IterableMethods[A, This]
with AddableMethods[A, This]
with SubtractableMethods[A, This]
{
  // abstract
  def empty: This
  def contains(elem: A): Boolean
  def + (elem: A): This
  def - (elem: A): This

  // concrete
  def apply(elem: A): Boolean
  def intersect(that: Set[A]): This
  def &(that: Set[A]): This
  def union(that: Set[A]): This
  def | (that: Set[A]): This
  def diff(that: Set[A]): This
  def &~(that: Set[A]): This
  def subsetOf(that: Set[A]): Boolean
}