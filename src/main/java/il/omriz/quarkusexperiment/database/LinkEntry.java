package il.omriz.quarkusexperiment.database;

import java.util.Objects;

public class LinkEntry {
    private String alias;
    private String target;

    public LinkEntry() {}
    public LinkEntry(String alias, String target) {
        this.alias = alias;
        this.target = target;
    }

    public String getAlias() {
        return alias;
    }

    public String getTarget() {
        return target;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.alias, this.target);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LinkEntry)) {
            return false;
        }

        LinkEntry other = (LinkEntry) obj;
        return Objects.equals(other.alias, this.alias) && Objects.equals(other.target, this.target);
    }

}
