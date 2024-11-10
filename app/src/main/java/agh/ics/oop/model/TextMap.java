package agh.ics.oop.model;

import java.util.List;
import java.util.ArrayList;

public class TextMap implements WorldNumberPositionMap<String, Integer> {
    private final List<String> textList = new ArrayList<>();

    @Override
    public boolean place(String text) {
        textList.add(text);
        return true;
    }

    @Override
    public void move(String text, MoveDirection direction) {
        int position = textList.indexOf(text);
        int potentialPosition = direction == MoveDirection.FORWARD || direction == MoveDirection.RIGHT ? position + 1 : position - 1;

        if (canMoveTo(potentialPosition)) {
            textList.set(position, textList.get(potentialPosition));
            textList.set(potentialPosition, text);
        }
    }

    @Override
    public boolean isOccupied(Integer position) {
        return position.intValue() < textList.size();
    }

    @Override
    public String objectAt(Integer position) {
        return textList.get(position.intValue());
    }

    @Override
    public boolean canMoveTo(Integer position) {
        return isOccupied(position) && position >= 0;
    }

    @Override
    public String toString() {
        return String.join(" ", textList);
    }
}
