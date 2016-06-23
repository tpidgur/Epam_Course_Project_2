package lexicalEntity;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * provides the rule for Composite objects comparison
 * task: to order the words starting with vowels in natural order for the first occurrence of consonants
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 11.06.2016)
 */
public class CompositeComparator implements Comparator {
    /**
     * regular expression corresponding to the consonants choice
     */
    public static final String CONSONANT_REGEX = "[БВГДЖЗЙКЛМНПРСТФХЦЧШЩбвгджзйклмнпрстфхцчшщ]";

    /**
     * compares the words on the first occurred consonant char
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Object o1, Object o2) {
        Composite composite1 = (Composite) o1;
        Composite composite2 = (Composite) o2;
        if (getFirstConsonant(composite1) > getFirstConsonant(composite2)) return 1;
        else if (getFirstConsonant(composite1) < getFirstConsonant(composite2)) return -1;
        else return 0;
    }

    /**
     * searches the first occured consonant and returns it as char
     * @param composite
     * @return
     */
    public char getFirstConsonant(Composite composite) {
        Iterator<LexicalItem> itr = composite.getList().iterator();
        while (itr.hasNext()) {
            DocChar symb = (DocChar) itr.next();
            if (symb.toString().matches(CONSONANT_REGEX)) {
                return symb.getChar();
            }
        }
        return 0;
    }
}
