package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishList = new ArrayList<>();
    public static final int CAPACITY = 20;

    public void addFish(Fish fish) {
        if (CAPACITY / (fishList.size() + 1) >= 5) {
            fishList.add(fish);
        } else {
            throw new IllegalStateException("Can not add fish because there is no more space.");
        }
    }

    public void feed() {
        for (Fish fish : fishList) {
            fish.feed();
        }
    }

    public void removeFish(int maxWeight) {
        List<Fish> toRemove = new ArrayList<>();
        for (Fish fish : fishList) {
            if (fish.getWeight() > maxWeight) {
                toRemove.add(fish);
            }
        }
        fishList.removeAll(toRemove);
    }

    public List<String> getStatus() {
        List<String> status = new ArrayList<>();
        for (Fish fish : fishList) {
            status.add(fish.getStatus());
        }
        return status;
    }

    public int getNumberOfFishWithMemoryLoss() {
        int count = 0;
        for (Fish fish : fishList) {
            if (fish.hasMemoryLoss()) {
                count++;
            }
        }
        return count;
    }

    public boolean isThereFishWithGivenColor(String color) {
        for (Fish fish : fishList) {
            if (fish.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish() {
        if (fishList.isEmpty()) {
            return null;
        }
        Fish minFish = fishList.get(0);
        for (Fish fish : fishList) {
            if (fish.getWeight() < minFish.getWeight()) {
                minFish = fish;
            }
        }
        return minFish;
    }
}
