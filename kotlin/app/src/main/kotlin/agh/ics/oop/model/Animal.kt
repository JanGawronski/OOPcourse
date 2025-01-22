package agh.ics.oop.model

class Animal(private var position: Vector2d = Vector2d(2, 2))  {
    private var orientation = MapDirection.NORTH

    fun getPosition(): Vector2d = position

    fun getOrientation(): MapDirection = orientation

    override fun toString(): String = when (orientation) {
            MapDirection.NORTH -> "^"
            MapDirection.EAST -> ">"
            MapDirection.SOUTH -> "v"
            MapDirection.WEST -> "<"
    }

    fun itAt(position: Vector2d): Boolean = this.position == position

    fun move(direction : MoveDirection, worldMap : WorldMap) {
        when (direction) {
            MoveDirection.FORWARD -> {
                val potentialPosition = position + orientation.toUnitVector()
                if (worldMap.canMoveTo(potentialPosition))
                    position = potentialPosition
            }
            MoveDirection.BACKWARD -> {
                val potentialPosition = position - orientation.toUnitVector()
                if (worldMap.canMoveTo(potentialPosition))
                    position = potentialPosition
            }
            MoveDirection.LEFT -> orientation = orientation.previous()
            MoveDirection.RIGHT -> orientation = orientation.next()
        }
    }

    fun setPosition(position: Vector2d) {
        this.position = position
    }
 
}
