package agh.ics.oop.model

enum class MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    override fun toString(): String = when (this) {
        NORTH -> "Północ"
        EAST -> "Wschód"
        SOUTH -> "Południe"
        WEST -> "Zachód"
    }

    fun next(): MapDirection = values()[(ordinal + 1) % values().size]

    fun previous(): MapDirection = values()[(ordinal - 1 + values().size) % values().size]
}