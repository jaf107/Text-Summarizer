public class improved_summary {
    public static void main(String[] args) {
        SummaryTool summary = new SummaryTool();
        summary.init();
        summary.extractSentenceFromContext();
        summary.groupSentencesIntoParagraphs();
        summary.printSentences();
        summary.createIntersectionMatrix();

        summary.createDictionary();
        System.out.println("\n\n\nSUMMARY\n\n\n");
        summary.createSummary();
        summary.printSummary();

        summary.printStats();
    }
}
