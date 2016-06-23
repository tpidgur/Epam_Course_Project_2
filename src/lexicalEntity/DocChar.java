package lexicalEntity;

import java.util.HashMap;
import java.util.Iterator;

/**
 * the given class realizes the flyweight pattern:
 * there is a collection of chars, wrapped in some class (MutableDocChar)
 * if any char already exists in collection the link on it is returned,
 * otherwise the new one is created
 * it implements LexicalItem interface, so that it can be nested in Composite collections of sentences, words etc.
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 11.06.2016)
 */
public class DocChar implements LexicalItem {
    private char character;

    public DocChar(char character) {
        this.character = character;
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
     * in this case both toText() and toString() return the String representation of char
     *
     * @return
     */

    @Override
    public String toText() {
        return toString();
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }

    /**
     * wraps the char into  MutableDocChar class used after in DocCharFactory
     */
    private static class MutableDocChar extends DocChar {
        private char character;

        public MutableDocChar() {
            super('\u0000');
        }

        public char getChar() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }
    }

    /**
     * fills the docCharPool collection with unique DocChars
     */
    public static class DocCharFactory {
        private MutableDocChar myChar = new MutableDocChar();
        private HashMap docCharPool = new HashMap();

        /**
         * provides check if some symbol c already exists in the docCharPool, otherwise creates the new one
         * @param c
         * @return the DocChar
         */
        public DocChar getDocChar(char c) {
            myChar.setCharacter(c);
            DocChar thisChar = (DocChar) docCharPool.get(myChar);
            if (thisChar == null) {
                thisChar = new DocChar(c);
                docCharPool.put(thisChar, thisChar);
            }
            return thisChar;
        }
    }

    public char getChar() {
        return character;
    }

    @Override
    public int hashCode() {
        return getChar();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof DocChar && ((DocChar) o).getChar() == getChar());
    }

}

