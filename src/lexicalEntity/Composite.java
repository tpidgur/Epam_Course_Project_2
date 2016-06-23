package lexicalEntity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * the main class that enables to provide the tree structure of objects by nesting one inside other
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 11.06.2016)
 */

public class Composite implements LexicalItem {
    /**
     * the collection of LexicalItem objects that can be usually a nested collection of other LexicalItems
     */
    private List<LexicalItem> list = new LinkedList<>();

    /**
     * adds the element to the collection
     * @param item
     */
    @Override
    public void addElement(LexicalItem item) {
        list.add(item);
    }

    /**
     * removes element from collection
     * @param item
     */
    @Override
    public void removeElement(LexicalItem item) {
        list.remove(item);
    }

    /**
     * returns an iterator on the list collection
     * @return
     */
    @Override
    public Iterator<LexicalItem> getIterator() {
        return list.iterator();
    }

    /**
     * returns the toString() representation of collection
     * @return
     */
    @Override
    public String toString() {
        return list.toString();
    }

    /**
     * concats the elements of the list collection
     * (for example: it is required when you need to restore the initial text tht was broken down
     * into symbols)
     * @return
     */
    public String toText() {
        String str = "";
        Iterator<LexicalItem> iterator = list.iterator();
        while (iterator.hasNext()) {
            LexicalItem symb = (LexicalItem) iterator.next();
            str += symb.toText();
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return list != null ? list.equals(composite.list) : composite.list == null;
    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }

    public List<LexicalItem> getList() {
        return list;
    }

    public void setList(List<LexicalItem> list) {
        this.list = list;
    }
}
