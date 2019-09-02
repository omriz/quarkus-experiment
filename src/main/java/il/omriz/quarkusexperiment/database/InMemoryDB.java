package il.omriz.quarkusexperiment.database;

import javax.enterprise.context.ApplicationScoped;
import java.net.URI;
import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@ApplicationScoped
public class InMemoryDB implements LinksDBInterface{

    public URI getLink(String alias) {
        readWriteLock.readLock().lock();
        // This will return null when not found.
        if (!links.containsKey(alias)) {
            readWriteLock.readLock().unlock();
            return null;
        }
        URI link = links.get(alias);
        readWriteLock.readLock().unlock();
        return link;
    }
    public void setLink(String alias, URI link){
        readWriteLock.writeLock().lock();
        links.put(alias, link);
        readWriteLock.writeLock().unlock();
    }

    private HashMap<String, URI> links = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
}
