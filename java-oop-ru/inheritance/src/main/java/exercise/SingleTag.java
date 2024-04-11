package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    private final String SINGLE_TAG_FORMAT = "<%s%s>";

    public SingleTag(String tagName, Map<String, String> attrMap) {
        super(tagName, attrMap);
    }

    @Override
    public String toString() {
        return String.format(SINGLE_TAG_FORMAT, this.tagName, this.generateAttributes());
    }
}
// END
