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

        BibliographyDatabase.addListOfJournals(testJournalList);

        Issue testIssue1 = new Issue(2010, 13, 8, testJournal1);
        testIssue1.addArticle("The 18th Dynasty", "Michael Stevenson"); // should add successfully
        testJournal1.addIssue(2020, 8, 15); // should add successfully
        BibliographyDatabase.addJournal("Ancient Greece"); // should add successfully
        
        BibliographyDatabase.addJournal(testJournal1); // already in list
        BibliographyDatabase.addJournal(new Journal("Modern Drummer")); // should add successfully
        BibliographyDatabase.removeJournal(new Journal("Not in List")); // not in list

        BibliographyDatabase.addIssue(testIssue1); // should add successfully
        BibliographyDatabase.addIssue(testIssue1); // already in list
        BibliographyDatabase.removeIssue(testIssue1); // should remove successfully
        BibliographyDatabase.addIssue(testIssue1); // should add successfully

        Article testArticle1 = new Article("Plants and Animals", "Indie Author");
        Article testArticle2 = new Article("Cities", "Indie Author", testIssue1);

        BibliographyDatabase.addArticle(testArticle1); // should add to independent section
        BibliographyDatabase.addArticle(testArticle2); // should add successfully
        BibliographyDatabase.removeArticle(new Article("Not in Bib", "Unknown Author", testIssue1)); // not in list
        BibliographyDatabase.removeArticle(new Article("Not in Bib", "Unknown Author")); // not in list
        BibliographyDatabase.removeArticle(testArticle1); // should remove from independent section
        BibliographyDatabase.removeArticle(testArticle2); // should remove
        System.out.println(BibliographyDatabase.getMostFrequentAuthor()); // Michael Stevenson
    }
}