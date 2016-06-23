package MVC;

import lexicalEntity.CodeSnippet;
import lexicalEntity.Composite;
import lexicalEntity.DocChar;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * tests the main methods in model
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 11.06.2016)
 */
public class ModelTest {

    private static Model model;
    String snippet = "// package mvc;\n" +
            "public  class Point {\n" +
            "}\n" +
            "\n" +
            " */// ~";

    /**
     * beforehand the instance of Model class is created
     */
    @BeforeClass
    public static void runT() {
        model = new Model();
    }

    /**
     * in order to test the testParseParagraph() method the nested structure of paragraph has been created,
     * including sentences, words, symbols
     *
     * @return Composite paragraphlist (contains one or several paragraphs broken down up to the symbol)
     */
    public Composite fillParagraphsCollection() {
        Composite paragraphList = new Composite();
        Composite paragraph = new Composite();
        Composite sentence = new Composite();

        List sentenceList = sentence.getList();
        List list1 = new LinkedList<>();
        list1.add(model.getSymbolGenerator().getDocChar('1'));
        Composite comp1 = new Composite();
        comp1.setList(list1);
        sentenceList.add(comp1);


        sentenceList.add(model.getSymbolGenerator().getDocChar('.'));
        sentenceList.add(model.getSymbolGenerator().getDocChar(' '));

        List list2 = new LinkedList<>();
        list2.add(model.getSymbolGenerator().getDocChar('Ч'));
        list2.add(model.getSymbolGenerator().getDocChar('Т'));
        list2.add(model.getSymbolGenerator().getDocChar('О'));
        Composite comp2 = new Composite();
        comp2.setList(list2);
        sentenceList.add(comp2);

        sentenceList.add(model.getSymbolGenerator().getDocChar(' '));

        List list3 = new LinkedList<>();
        list3.add(model.getSymbolGenerator().getDocChar('Т'));
        list3.add(model.getSymbolGenerator().getDocChar('А'));
        list3.add(model.getSymbolGenerator().getDocChar('К'));
        list3.add(model.getSymbolGenerator().getDocChar('О'));
        list3.add(model.getSymbolGenerator().getDocChar('Е'));
        Composite comp3 = new Composite();
        comp3.setList(list3);
        sentenceList.add(comp3);


        sentenceList.add(model.getSymbolGenerator().getDocChar(' '));
        List list4 = new LinkedList<>();
        list4.add(model.getSymbolGenerator().getDocChar('J'));
        list4.add(model.getSymbolGenerator().getDocChar('A'));
        list4.add(model.getSymbolGenerator().getDocChar('V'));
        list4.add(model.getSymbolGenerator().getDocChar('A'));
        Composite comp4 = new Composite();
        comp4.setList(list4);
        sentenceList.add(comp4);


        sentenceList.add(model.getSymbolGenerator().getDocChar('?'));
        paragraph.addElement(sentence);

        Composite paragraph2 = new Composite();
        List paragraphList2 = paragraph2.getList();
        Composite sentence2 = new Composite();
        List sentenceList2 = sentence2.getList();

        List list5 = new LinkedList<>();
        list5.add(model.getSymbolGenerator().getDocChar('Ч'));
        list5.add(model.getSymbolGenerator().getDocChar('т'));
        list5.add(model.getSymbolGenerator().getDocChar('о'));
        Composite comp5 = new Composite();
        comp5.setList(list5);
        sentenceList2.add(comp5);

        sentenceList2.add(model.getSymbolGenerator().getDocChar(' '));

        List list6 = new LinkedList<>();
        list6.add(model.getSymbolGenerator().getDocChar('з'));
        list6.add(model.getSymbolGenerator().getDocChar('н'));
        list6.add(model.getSymbolGenerator().getDocChar('а'));
        list6.add(model.getSymbolGenerator().getDocChar('ю'));
        list6.add(model.getSymbolGenerator().getDocChar('т'));
        Composite comp6 = new Composite();
        comp6.setList(list6);
        sentenceList2.add(comp6);


        sentenceList2.add(model.getSymbolGenerator().getDocChar('?'));

        paragraph2.addElement(sentence2);
        paragraphList.addElement(paragraph);
        paragraphList.addElement(model.getSymbolGenerator().getDocChar('\n'));
        paragraphList.addElement(paragraph2);
        paragraphList.addElement(model.getSymbolGenerator().getDocChar('\n'));
        return paragraphList;
    }

    /**
     * in order to test the testParseSentence() method the nested structure of sentence has been created,
     * including  words, symbols
     *
     * @return Composite sentence (contains one sentence broken down up to the symbol)
     */
    public Composite fillSentencesCollection() {
        Composite sentence1 = new Composite();

        List sentenceList1 = sentence1.getList();
        List list1 = new LinkedList<>();
        list1.add(model.getSymbolGenerator().getDocChar('1'));
        Composite comp1 = new Composite();
        comp1.setList(list1);
        sentenceList1.add(comp1);


        sentenceList1.add(model.getSymbolGenerator().getDocChar('.'));
        sentenceList1.add(model.getSymbolGenerator().getDocChar(' '));

        List list2 = new LinkedList<>();
        list2.add(model.getSymbolGenerator().getDocChar('Ч'));
        list2.add(model.getSymbolGenerator().getDocChar('Т'));
        list2.add(model.getSymbolGenerator().getDocChar('О'));

        Composite comp2 = new Composite();
        comp2.setList(list2);
        sentenceList1.add(comp2);

        sentenceList1.add(model.getSymbolGenerator().getDocChar(' '));

        List list3 = new LinkedList<>();
        list3.add(model.getSymbolGenerator().getDocChar('Т'));
        list3.add(model.getSymbolGenerator().getDocChar('А'));
        list3.add(model.getSymbolGenerator().getDocChar('К'));
        list3.add(model.getSymbolGenerator().getDocChar('О'));
        list3.add(model.getSymbolGenerator().getDocChar('Е'));
        Composite comp3 = new Composite();
        comp3.setList(list3);
        sentenceList1.add(comp3);


        sentenceList1.add(model.getSymbolGenerator().getDocChar(' '));
        List list4 = new LinkedList<>();
        list4.add(model.getSymbolGenerator().getDocChar('J'));
        list4.add(model.getSymbolGenerator().getDocChar('A'));
        list4.add(model.getSymbolGenerator().getDocChar('V'));
        list4.add(model.getSymbolGenerator().getDocChar('A'));
        Composite comp4 = new Composite();
        comp4.setList(list4);
        sentenceList1.add(comp4);
        sentenceList1.add(model.getSymbolGenerator().getDocChar('?'));
        Composite paragraph = new Composite();
        paragraph.addElement(sentence1);
        return paragraph;
    }

    /**
     * in order to test the testParseWordWithSign() method the nested structure of word has been created,
     * including   symbols
     *
     * @return Composite word (contains one word broken down up to the symbol)
     */
    public Composite fillWordCollection() {
        Composite word = new Composite();
        List wordList = word.getList();
        List list3 = new LinkedList<>();
        list3.add(model.getSymbolGenerator().getDocChar('Т'));
        list3.add(model.getSymbolGenerator().getDocChar('А'));
        list3.add(model.getSymbolGenerator().getDocChar('К'));
        list3.add(model.getSymbolGenerator().getDocChar('О'));
        list3.add(model.getSymbolGenerator().getDocChar('Е'));
        Composite comp3 = new Composite();
        comp3.setList(list3);
        wordList.add(comp3);
        return word;
    }

    /**
     * adds  words beginning with vowel in a sorted order
     * @return
     */
    public List sortWords() {
        Composite word = new Composite();
        List wordList = word.getList();
        List list3 = new LinkedList<>();
        list3.add(model.getSymbolGenerator().getDocChar('о'));
        list3.add(model.getSymbolGenerator().getDocChar('б'));
        list3.add(model.getSymbolGenerator().getDocChar('ы'));
        list3.add(model.getSymbolGenerator().getDocChar('ч'));
        list3.add(model.getSymbolGenerator().getDocChar('н'));
        list3.add(model.getSymbolGenerator().getDocChar('ы'));
        list3.add(model.getSymbolGenerator().getDocChar('е'));
        Composite comp3 = new Composite();
        comp3.setList(list3);
        wordList.add(comp3);

        List list4 = new LinkedList<>();
        list4.add(model.getSymbolGenerator().getDocChar('у'));
        list4.add(model.getSymbolGenerator().getDocChar('ж'));
        list4.add(model.getSymbolGenerator().getDocChar('е'));
        Composite comp4 = new Composite();
        comp4.setList(list4);
        wordList.add(comp4);

        List list5 = new LinkedList<>();
        list5.add(model.getSymbolGenerator().getDocChar('о'));
        list5.add(model.getSymbolGenerator().getDocChar('н'));
        list5.add(model.getSymbolGenerator().getDocChar('и'));
        Composite comp5 = new Composite();
        comp5.setList(list5);
        wordList.add(comp5);

        List list6 = new LinkedList<>();
        list6.add(model.getSymbolGenerator().getDocChar('е'));
        list6.add(model.getSymbolGenerator().getDocChar('щ'));
        list6.add(model.getSymbolGenerator().getDocChar('е'));
        Composite comp6 = new Composite();
        comp6.setList(list6);
        wordList.add(comp6);
        return wordList;
    }

    /**
     * adds the code snippet to the model's paragraphList and \n
     *
     * @return
     */
    public Composite formCodeSnippet() {
        Composite paragraphList = model.getParagraphList();
        paragraphList.addElement(new CodeSnippet(snippet));
        paragraphList.addElement(model.getSymbolGenerator().getDocChar('\n'));
        return paragraphList;
    }

    /**
     * tests the parseParagraph method in Model
     */
    @Test
    public void testParseParagraph() {
        Composite res = model.parseParagraph("1.\tЧТО ТАКОЕ JAVA?\n\nЧто знают?");
        assertEquals(res, fillParagraphsCollection());
    }

    /**
     * tests the parseSentence method in Model
     */
    @Test
    public void testParseSentence() {
        Composite res = model.parseSentence("1. ЧТО ТАКОЕ JAVA?");
        assertEquals(res, fillSentencesCollection());
    }

    /**
     * tests the parseWordWithSign method in Model
     */
    @Test
    public void testParseWordWithSign() {
        Composite res = model.parseWordWithSign("ТАКОЕ");
        assertEquals(res, fillWordCollection());
    }

    /**
     * tests the parseSymbol method in Model
     */
    @Test
    public void testParseSymbol() {
        Composite symbol = new Composite();
        List symbolList = symbol.getList();
        symbolList.add(model.getSymbolGenerator().getDocChar('Ч'));
        Composite res = model.parseSymbol("Ч");
        assertEquals(res, symbol);
    }

    /**
     * tests the sorting() method in Model
     */
    @Test
    public void testSorting() {
        model.parseSentence("обычные уже они еще будь?");
        List res = model.sorting();
        assertEquals(res, sortWords());
    }

    /**
     * tests the parseParagraph() method in Model in case if the code snippet has been passed at the input
     */
    @Test
    public void testParseParagraphWithCode() {
        Composite res = model.parseParagraph(snippet);
        assertEquals(res, formCodeSnippet());
    }


}