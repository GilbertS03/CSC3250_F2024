//    // T is the object that contains the data
//    // S is the search value
public interface SearchBehavior<T, S>{
    boolean search(T obj, S v);
}