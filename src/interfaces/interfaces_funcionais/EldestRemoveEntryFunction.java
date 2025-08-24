package interfaces.interfaces_funcionais;

import java.util.Map;

@FunctionalInterface
public interface EldestRemoveEntryFunction<K,V> {
    boolean remove(Map<K,V> map, Map.Entry<K,V> eldest);
}
