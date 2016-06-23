package lexicalEntity;

import java.util.Iterator;

/**
 * wraps the String as LexicalItem
 * for example code snippet that doesn't need to be broken down in  lexical components is added as LexicalItem
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 11.06.2016)
 */
public class CodeSnippet implements LexicalItem {
    /**
     * String code snippet
     */
    private String text;

    public CodeSnippet(String text) {
        this.text = text;
    }

    @Override
    public void addElement(LexicalItem item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeElement(LexicalItem item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<LexicalItem> getIterator() {
        throw new UnsupportedOperationException();
    }

    /**
     * in this class both methods toString() and toText() return the same: String representation of code snippet
     * @return
     */
    @Override
    public String toText() {
        return toString();
    }

    @Override
    public String toString() {
        return text;
    }
}
