package spielumwelt.vordergrund.hindernisse;

import spielumwelt.vordergrund.froesche.Frosch;

public interface Kollidierbar<T> {
    boolean kollidieren(Frosch frosch);
}
