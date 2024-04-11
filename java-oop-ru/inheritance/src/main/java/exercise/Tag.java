package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private final String ATTR_FORMAT = " %s=\"%s\"";
    String tagName;
    Map<String, String> attrMap;

    public Tag(String tagName, Map<String, String> attrMap) {
        this.tagName = tagName;
        this.attrMap = attrMap;
    }

    public String generateAttributes () {
        StringBuilder stringBuilder = new StringBuilder();
        for (var attr : this.attrMap.entrySet()) {
            stringBuilder.append(String.format(ATTR_FORMAT, attr.getKey(), attr.getValue()));
        }
        return stringBuilder.toString();
    }
}
// END
