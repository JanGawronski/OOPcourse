package agh.ics.oop.model

fun Map<Vector2d, Any>.randomPosition(): Vector2d? = keys.randomOrNull()

fun Map<Vector2d, Any>.randomFreePosition(mapSize: Vector2d): Vector2d? =
        ((0 until mapSize.getX()).flatMap { x ->
                    (0 until mapSize.getY()).map { y -> Vector2d(x, y) }
                } - keys)
                .randomOrNull()
