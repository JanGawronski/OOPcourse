package agh.ics.oop.model

interface WorldMap {
    fun place(animal: Animal)
    fun isOccupied(position: Vector2d): Boolean
    fun objectAt(position: Vector2d): Animal?
    fun getAnimals(): Collection<Animal>
    fun canMoveTo(position: Vector2d): Boolean
}