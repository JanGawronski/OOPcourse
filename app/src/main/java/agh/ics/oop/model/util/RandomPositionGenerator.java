package agh.ics.oop.model.util;

import agh.ics.oop.model.Vector2d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomPositionGenerator implements Iterable<Vector2d> {
    private final int count;
    private final List<Vector2d> allPositions = new ArrayList<>();

    public RandomPositionGenerator(int maxWidth, int maxHeight, int count) {
        this.count = count;

        for (int i = 0; i < maxWidth; i++)
            for (int j = 0; j < maxHeight; j++)
                allPositions.add(new Vector2d(i, j));
    }


    @Override
    public Iterator<Vector2d> iterator() {
        return new Iterator<Vector2d>() {
            private final Random random = new Random();
            private int generated = 0;
            private final List<Vector2d> positionsLeft = new ArrayList<>(allPositions);

            @Override
            public boolean hasNext() {
                return generated < count && !positionsLeft.isEmpty();
            }

            @Override
            public Vector2d next() {
                if (!hasNext())
                    throw new UnsupportedOperationException("No more positions to generate");
                
                int index = random.nextInt(positionsLeft.size());
                Vector2d position = positionsLeft.get(index);
                positionsLeft.set(index, positionsLeft.getLast());
                positionsLeft.removeLast();
                generated++;
                return position;
            }
        };
    }




}
