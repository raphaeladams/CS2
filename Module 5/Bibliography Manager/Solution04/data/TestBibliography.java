package data;

import java.util.ArrayList;

public class TestBibliography
{
    // Extra tests run for the BibliographyDatabase class.
    public static void main(String args[])
    {
        ArrayList<Journal> testJournalList = Journal.getSampleJournals();

        Journal testJournal1 = new Journal("TEST JOURNAL 1");
        Journal testJournal2 = new Journal("TEST JOURNAL 2");
        testJournalList.add(testJournal1);
        testJournalList.add(testJournal2);
        
        for (Journal j : testJournalList)
        {
            System.out.println(j);
        }

        BibliographyDatabase testBib = new BibliographyDatabase("TEST BIB");
        testBib.addListOfJournals(testJournalList);

        Issue testIssue1 = new Issue(2010, 13, 8, testJournal1);
        testIssue1.addArticle("The 18th Dynasty", "Michael Stevenson"); // should add successfully
        testJournal1.addIssue(2020, 8, 15); // should add successfully
        testBib.addJournal("Ancient Greece"); // should add successfully
        
        testBib.addJournal(testJournal1); // already in list
        testBib.addJournal(new Journal("Modern Drummer")); // should add successfully
        testBib.removeJournal(new Journal("Not in List")); // not in list

        testBib.addIssue(testIssue1); // should add successfully
        testBib.addIssue(testIssue1); // already in list
        testBib.removeIssue(testIssue1); // should remove successfully
        testBib.addIssue(testIssue1); // should add successfully

        Article testArticle1 = new Article("Plants and Animals", "Indie Author");
        Article testArticle2 = new Article("Cities", "Indie Author", testIssue1);

        testBib.addArticle(testArticle1); // should add to independent section
        testBib.addArticle(testArticle2); // should add successfully
        testBib.removeArticle(new Article("Not in Bib", "Unknown Author", testIssue1)); // not in list
        testBib.removeArticle(new Article("Not in Bib", "Unknown Author")); // not in list
        testBib.removeArticle(testArticle1); // should remove from independent section
        testBib.removeArticle(testArticle2); // should remove
        System.out.println(testBib.getMostFrequentAuthor()); // Michael Stevenson
    }
}