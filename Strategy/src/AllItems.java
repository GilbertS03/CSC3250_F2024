import java.util.*;
public class AllItems<T>{
    private ArrayList<T> _items;

    public AllItems(){_items = new ArrayList<T>();}
    public <S> int findItem(S v, SearchBehavior<T, S> sb){
        for(int i = 0; i < _items.size(); i++){
            if(sb.search(_items.get(i), v))
                return i;
        }
        return -1;
    }
    public void addItem(T t){_items.add(t);}
    public void removeItem(int i){_items.remove(i);}
    public int size(){return _items.size();}
    public T get(int i){return _items.get(i);}
}
