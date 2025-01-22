package agh.ics.oop.model

class BouncyMap(private val height: Int, private val width: Int) : WorldMap {
    private val animals: HashMap<Vector2d, Animal> = HashMap()

    override fun place(animal: Animal) {
        if (!canMoveTo(animal.getPosition()))
                throw IllegalArgumentException("Cannot place animal at ${animal.getPosition()}")

        animals.filterValues { it != animal }

        if (!isOccupied(animal.getPosition())) {
            animals[animal.getPosition()] = animal
            return
        }

        val newPosition =
                animals.randomFreePosition(Vector2d(width, height))
                        ?: animals.randomPosition() ?: return
        animals[newPosition] = animal
        animal.setPosition(newPosition)
    }

    override fun isOccupied(position: Vector2d): Boolean = animals.containsKey(position)

    override fun objectAt(position: Vector2d): Animal? = animals[position]

    override fun getAnimals(): Set<Animal> = animals.values.toSet()

    override fun canMoveTo(position: Vector2d): Boolean =
            position >= Vector2d(0, 0) && position <= Vector2d(width - 1, height - 1)
}
