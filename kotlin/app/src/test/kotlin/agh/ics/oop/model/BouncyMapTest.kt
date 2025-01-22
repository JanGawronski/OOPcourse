package agh.ics.oop.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.assertions.throwables.shouldThrow

class BouncyMapTest : StringSpec({
    "should place animal on the map" {
        val map = BouncyMap(10, 10)
        val animal = Animal(Vector2d(2, 2))
        map.place(animal)
        map.isOccupied(Vector2d(2, 2)) shouldBe true
        map.objectAt(Vector2d(2, 2)) shouldBe animal
    }

    "should throw exception when placing animal out of bounds" {
        val map = BouncyMap(10, 10)
        val animal = Animal(Vector2d(11, 11))
        shouldThrow<IllegalArgumentException> {
            map.place(animal)
        }
    }

    "should move animal to a new position if the initial position is occupied" {
        val map = BouncyMap(10, 10)
        val animal1 = Animal(Vector2d(2, 2))
        val animal2 = Animal(Vector2d(2, 2))
        map.place(animal1)
        map.place(animal2)
        map.isOccupied(Vector2d(2, 2)) shouldBe true
        map.getAnimals().size shouldBe 2
    }

    "should return correct animals set" {
        val map = BouncyMap(10, 10)
        val animal1 = Animal(Vector2d(2, 2))
        val animal2 = Animal(Vector2d(3, 3))
        map.place(animal1)
        map.place(animal2)
        map.getAnimals() shouldBe setOf(animal1, animal2)
    }

    "should correctly check if position is occupied" {
        val map = BouncyMap(10, 10)
        val animal = Animal(Vector2d(2, 2))
        map.place(animal)
        map.isOccupied(Vector2d(2, 2)) shouldBe true
        map.isOccupied(Vector2d(3, 3)) shouldBe false
    }

    "should correctly check if position can be moved to" {
        val map = BouncyMap(10, 10)
        map.canMoveTo(Vector2d(0, 0)) shouldBe true
        map.canMoveTo(Vector2d(9, 9)) shouldBe true
        map.canMoveTo(Vector2d(10, 10)) shouldBe false
        map.canMoveTo(Vector2d(-1, -1)) shouldBe false
    }
})