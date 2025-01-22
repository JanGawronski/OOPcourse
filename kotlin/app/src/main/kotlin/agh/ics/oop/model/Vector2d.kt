package agh.ics.oop.model

import kotlin.math.max
import kotlin.math.min

data class Vector2d(private val x: Int, private val y: Int) {
    fun getX(): Int = x

    fun getY(): Int = y

    override fun toString(): String = "($x, $y)"

    operator fun compareTo(other: Vector2d): Int = when {
            x == other.x && y == other.y -> 0
            x <= other.x && y <= other.y -> -1
            x >= other.x && y >= other.y -> 1
            else -> 0
        }

    operator fun plus(other: Vector2d): Vector2d = Vector2d(x + other.x, y + other.y)

    operator fun minus(other: Vector2d): Vector2d = Vector2d(x - other.x, y - other.y)

    fun upperRight(other: Vector2d): Vector2d = Vector2d(max(x, other.x), max(y, other.y))

    fun lowerLeft(other: Vector2d): Vector2d = Vector2d(min(x, other.x), min(y, other.y))

    fun opposite(): Vector2d = Vector2d(-x, -y);
    
    companion object {
        val NORTH_VECTOR = Vector2d(0, 1)
        val SOUTH_VECTOR = Vector2d(0, -1)
        val WEST_VECTOR = Vector2d(-1, 0)
        val EAST_VECTOR = Vector2d(1, 0)
    }
}

fun MapDirection.toUnitVector(): Vector2d = when (this) {
    MapDirection.NORTH -> Vector2d.NORTH_VECTOR
    MapDirection.SOUTH -> Vector2d.SOUTH_VECTOR
    MapDirection.WEST -> Vector2d.WEST_VECTOR
    MapDirection.EAST -> Vector2d.EAST_VECTOR
}