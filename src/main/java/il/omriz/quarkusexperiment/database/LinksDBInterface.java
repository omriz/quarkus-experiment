package il.omriz.quarkusexperiment.database;

import java.util.Map;
import java.net.URI;

public interface LinksDBInterface {
    public URI getLink(String alias);
    public void setLink(String alias, URI link);
    public Map<String, URI> listLinks();
}
