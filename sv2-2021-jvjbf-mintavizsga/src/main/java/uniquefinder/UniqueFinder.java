package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {
    public List<Character> getUniqueChars(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text is null.");
        }
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (!chars.contains(text.charAt(i))) {
                chars.add(text.charAt(i));
            }
        }
        return chars;
    }
}
