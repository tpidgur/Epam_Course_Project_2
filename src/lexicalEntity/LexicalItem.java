package lexicalEntity;

import java.util.Iterator;

/**
 * the interface that has many realizations and enables to hide them
 * contains basic methods such as add/remove/getIterator etc.
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 11.06.2016)
 */
public interface LexicalItem {
    /**
     * adds element to a collection
     *
     * @param item
     */
    void addElement(LexicalItem item);

    /**
     * removes element from collection
     *
     * @param item
     */
    void removeElement(LexicalItem item);

    /**
     * @return an iterator that moves through elements in some collection
     */
    Iterator<LexicalItem> getIterator();

    /**
     * @return the text representation of block of text
     */
    String toText();
}
