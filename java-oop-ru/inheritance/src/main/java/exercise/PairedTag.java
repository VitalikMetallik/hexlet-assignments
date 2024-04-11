package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private final String PAIRED_TAG_FORMAT = "<%s%s>%s%s</%s>";
    private String tagBody;
    private List<Tag> childList;

    public PairedTag(String tagName, Map<String, String> attrMap, String tagBody, List<Tag> childList) {
        super(tagName, attrMap);
        this.tagBody = tagBody;
        this.childList = childList;
    }

    @Override
    public String toString() {
        return String.format(
                PAIRED_TAG_FORMAT,
                this.tagName,
                this.generateAttributes(),
                this.tagBody,
                this.generateChildString(),
                this.tagName
        );
    }

    private String generateChildString() {
        StringBuilder resultString = new StringBuilder();
        for (var entry : this.childList) {
            resultString.append(entry);
        }
        return resultString.toString();
    }
}
// END
