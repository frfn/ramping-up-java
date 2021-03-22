package a_classTraits.carExample;

// interface giving behaviors, you can compare
public interface Compare {
    boolean isFaster(Compare object); // the object needs to be of type Compare!
    boolean isMoreExpensive(Compare object);
}
