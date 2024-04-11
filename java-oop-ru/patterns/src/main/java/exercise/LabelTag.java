package exercise;

// BEGIN
public class LabelTag implements TagInterface{
    private String labelValue;
    private TagInterface childTag;

    public LabelTag(String labelValue, TagInterface childTag) {
        this.labelValue = labelValue;
        this.childTag = childTag;
    }

    public String render() {
        return "<label>" + this.labelValue + this.childTag.render() + "</label>";
    }
}
// END
