package com.company;

public class Main {

    public static void main(String[] args) {
        SummaryTool summary = new SummaryTool();
        summary.init();
        summary.extractSentenceFromContext();
        summary.groupSentencesIntoParagraphs();
        summary.printSentences();
        //summary.printIntersectionMatrix();
        summary.createIntersectionMatrix();

                //System.out.println("INTERSECTION MATRIX");
                //summary.printIntersectionMatrix();

        summary.createDictionary();
                //summary.printDicationary();

        System.out.println("\n\nSUMMMARY");
        summary.createSummary();
        summary.printSummary();

        summary.printStats();
    }
}

