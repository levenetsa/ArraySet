package set;

import java.lang.reflect.Constructor;
import java.util.*;

/**
 * Created by alex on 25.02.15.
 */
public class ArraySet<T extends Comparable<T>> implements SortedSet<T> {

    T[] data;
    List<T> list;
    CartesianTree tree;

    public ArraySet(){}

    public ArraySet(Collection<T> data,Comparator<T> comparator){
        list = new ArrayList<T>(data);
        if (comparator== null) list.sort(comparator());
        else
            list.sort(comparator);

    }



    @Override
    public Comparator<? super T> comparator() {
        return new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        ArraySet<T> set = new ArraySet<T>();
        if (fromElement.equals(toElement)) return set;
        int l = list.indexOf(fromElement);
        int r = list.indexOf(toElement)-1;
        set.list=list.subList(l,r);
        return set;
    }

 /*   private void copy(ArraySet root, CartesianTree.Node root1, T fromElement, T toElement) {
        if (root1.x.compareTo(fromElement)<=0&&root1.x.compareTo(toElement)>=0)
            root.add(root1.x);
        if//http://www.twitch.tv/reinessa/popout

    }
*/
    @Override
    public SortedSet<T> headSet(T toElement) {
        ArraySet<T> set = new ArraySet<T>();
        int r = list.indexOf(toElement)-1;
        set.list = list.subList(0, r);
        return set;
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        ArraySet<T> set = new ArraySet<T>();
        int r = list.indexOf(fromElement);
        set.list = list.subList(r,size()-1);
        return set;
    }

    @Override
    public T first() {
        return list.get(0);
    }

    @Override
    public T last() {
        return list.get(size()-1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean contains(Object o) {
        T t = (T) o;
        return list.indexOf(t) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        a = (T1[]) list.toArray();
        return a;
    }

    @Override
    public boolean add(T t) {
        try {
            throw (new Exception("Set can't be changed"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        try {
            throw (new Exception("Set can't be changed"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object t : c) {
            if (list.indexOf((T)t)==-1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        try {
            throw (new Exception("Set can't be changed"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            throw (new Exception("Set can't be changed"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            throw (new Exception("Set can't be changed"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void clear() {
        try {
            throw (new Exception("Set can't be changed"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
