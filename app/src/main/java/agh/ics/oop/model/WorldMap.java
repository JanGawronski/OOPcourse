package agh.ics.oop.model;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import agh.ics.oop.model.exceptions.IncorrectPositionException;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo, idzik
 */
public interface WorldMap extends MoveValidator {

    /**
     * Place a animal on the map.
     *
     * @param animal The animal to place on the map.
     * @return True if the animal was placed. The animal cannot be placed if the move is not valid.
     */
    void place(Animal animal) throws IncorrectPositionException;

    /**
     * Moves an animal (if it is present on the map) according to specified direction.
     * If the move is not possible, this method has no effect.
     */
    void move(Animal animal, MoveDirection direction);

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position Position to check.
     * @return True if the position is occupied.
     */
    boolean isOccupied(Vector2d position);

    /**
     * Return an animal at a given position.
     *
     * @param position The position of the animal.
     * @return animal or null if the position is not occupied.
     */
    Optional<WorldElement> objectAt(Vector2d position);

    /**
     * Return boundaries of map.
     *
     * @return boundary object containing Vector2d lowerLeft and Vector2d upperRight.
     */
    Boundary getCurrentBounds();

    /**
     * Return the id of the map.
     *
     * @return id of the map.
     */
    UUID getId();

    /**
     * Return an ordered collection of animals on the map.
     *
     * @return Collection of Animal.
     */
    Collection<Animal> getOrderedAnimals();

    /**
     * Return a collection of elements on the map.
     *.
     * @return Collection of WorldElement.
     */
    Collection<WorldElement> getElements();
}
