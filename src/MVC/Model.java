package MVC;

import lexicalEntity.CodeSnippet;
import lexicalEntity.Composite;
import lexicalEntity.CompositeComparator;
import lexicalEntity.DocChar;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1) breaks down the paragraph into sentences, words,symbols
 * 2) doesn't break down the code snippet(adds it as block of text)
 * 3) sorts the words beginning with vowel in the natural order of first consonant occurrence
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 11.06.2016)
 */
public class Model {
    /**
     * The regEx break the input text on paragraphs, sentences, words, symbols etc.
     */
    //    public static final String PARAGRAPH_REGEX = "(/{2}(.|\\r|\\n)*\\*/{3}\\s~)|(.+)(\\r?\\n)*";
    public static final String CODE_REGEX = "[/]{2}(.|\\r|\\n){0,200}[*][/]{3}\\s[~]";// For example: // public class\n */// ~
    public static final String PARAGRAPH = "(.+)(\\r?\\n)*";
    public static final String PARAGRAPH_REGEX = "(" + CODE_REGEX + ")|" + PARAGRAPH;
    public static final String SENTENCE_REGEX = "(((\\d{1,}\\.)?[A-Яа-я\\w\\s?,*\\-\\(\\):;+'\"]+[а-я\\s?\\w.\\(\\),\\-–’:;/]*)[(\\.){1,3}\\?!:;]+\\s?)";
    public static final String WORD_REGEX2 = "[A-Яа-я\\w'’]+|\\s+|[\"\\(\\)-.,?!:/\\s@]{1}|(\\d{1,}\\.(\\d{1,})?)";
    public static final String PUNCTUATION_SYMBOL = "[\"\\(\\)-.,?!:/\\s@]{1}";
    public static final String VOWEL_REGEX = "[АaЕеЁёИиОоУуЭэЮюЯя]{1,2}[а-яА-Я]*";
    public static final String SYMBOL_REGEX = ".{1}";
    /**
     * collection of selected words starting with vowel
     */
    private List<Composite> composList = new LinkedList<>();
    /**
     * contains a sequence of paragraphs
     */
    private Composite paragraphList = new Composite();
    /**
     * an instance of DocChar.DocCharFactory through which the access to the docCharPool can be obtained
     */
    private DocChar.DocCharFactory symbolGenerator = new DocChar.DocCharFactory();

    /**
     * checks if the input text is a code snippet or an ordinary text.
     * in first case inserts a code snippet as a distinct paragraph without breaking down it.
     * Otherwise breaks down the ordinary text on sentences
     * @param text = many paragraphs
     * @return the Composite object that contains a tree structure of the text (i.e. sentences,
     * words,symbols) (composite pattern)
     *
     */
    public Composite parseParagraph(String text) {
        String paragraph = "";
        Pattern pat = Pattern.compile(PARAGRAPH_REGEX);
        Matcher mat = pat.matcher(text);
        while (mat.find()) {
            paragraph = mat.group();
            if (paragraph.matches(CODE_REGEX)) {
                paragraphList.addElement(new CodeSnippet(paragraph));
                paragraphList.addElement(symbolGenerator.getDocChar('\n'));
                continue;
            } else {
                paragraph = mat.group(3);
                paragraphList.addElement(parseSentence(paragraph));//add splitted paragraphs
                paragraphList.addElement(symbolGenerator.getDocChar('\n'));
            }
        }
        return paragraphList;
    }

    /**
     * breaks the paragraph into sentences
     * @param text = one paragraph
     * @return the Composite object: sentence containing  nested collections  of words and symbols inside
     */
    public Composite parseSentence(String text) {
        Composite sentenceList = new Composite();
        String sentence = "";
        Pattern pat = Pattern.compile(SENTENCE_REGEX);
        Matcher mat = pat.matcher(text);
        while (mat.find()) {
            sentence = mat.group();
            sentenceList.addElement(parseWordWithSign(sentence));
        }
        return sentenceList;
    }

    /**
     * breaks the sentence into words
     * @param text = one sentence
     * @return the Composite object: word containing  nested collection  of  symbols inside
     * also checks if the word matches the PUNCTUATION_SYMBOL adds it as a counterpart of sentence
     * if there is tab or several spaces substitutes it by one space
     * also selects the words that start with vowel and adds it to the composList collection
     */
    public Composite parseWordWithSign(String text) {
        Composite wordAndSignList = new Composite();
        String word = "";
        Pattern pat = Pattern.compile(WORD_REGEX2);
        Matcher mat = pat.matcher(text);
        while (mat.find()) {
            word = mat.group();
            if (word.matches(PUNCTUATION_SYMBOL) || word.matches("\\s+")) {
                if (word.matches("\\t") || word.matches("\\s+")) {
                    word = " ";
                }
                char character = word.charAt(0);
                wordAndSignList.addElement(symbolGenerator.getDocChar(character));
            } else {
                if (word.matches(VOWEL_REGEX)) {
                    composList.add(parseSymbol(word));
                }
                wordAndSignList.addElement(parseSymbol(word));
            }
        }
        return wordAndSignList;
    }


    /**
     * breaks the word into symbols
     * @param text = one word
     * @return the Composite symbol. each time it is checked whether there is such symbol in
     * sentence containing  nested collections  of words and symbols inside docCharPool collection (flyweight pattern)
     */
    public Composite parseSymbol(String text) {
        Composite symbolList = new Composite();
        String symbol = "";
        Pattern pat = Pattern.compile(SYMBOL_REGEX);
        Matcher mat = pat.matcher(text);
        while (mat.find()) {
            symbol = mat.group();
            char character = symbol.charAt(0);
            symbolList.addElement(symbolGenerator.getDocChar(character));
        }
        return symbolList;
    }

    /**
     * sorts the collection of selected words beginning with vowels on the first occurrence of consonant
     * (natural order for consonant)
     * @return sorted collection of words starting with vowels
     */
    public List sorting() {
        Collections.sort(composList, new CompositeComparator());
        return composList;
    }

    public DocChar.DocCharFactory getSymbolGenerator() {
        return symbolGenerator;
    }

    public List<Composite> getComposList() {
        return composList;
    }

    public Composite getParagraphList() {
        return paragraphList;
    }
}
