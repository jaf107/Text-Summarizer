
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SummaryTool {
    FileInputStream in;
    FileOutputStream out;
    ArrayList<Sentence> sentences, contentSummary;
    ArrayList<Paragraph> paragraphs;
    int noOfSentences,noOfParagraphs;

    double [][] intersectionMatrix;
    LinkedHashMap<Sentence, Double> dictionary;

    SummaryTool() {
        in = null;
        out = null;
        noOfSentences = 0;
        noOfParagraphs = 0;
    }
    void init(){
        sentences = new ArrayList<Sentence>();
        paragraphs = new ArrayList<Paragraph>();
        contentSummary = new ArrayList<Sentence>();
        dictionary = new LinkedHashMap<Sentence,Double>();
        noOfParagraphs = 0;
        noOfSentences = 0;
        try{
            in = new FileInputStream("");
            out = new FileOutputStream("SummaryOutput.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    void extractSentenceFromContext(){
        int nextChar,j=0;
        int prevChar = -1;
        try{
            while((nextChar = in.read()) != -1){
                //System.out.println(nextChar + " ");
                j = 0;
                char[] temp = new char[100000];
                while ((char)nextChar != '.'){
                    temp[j] = (char)nextChar;
                    if((nextChar = in.read()) == -1){
                        break;
                    }
                    if((char)nextChar == '\n' && (char)prevChar == '\n'){
                        noOfParagraphs++;
                    }
                    j++;
                    prevChar = nextChar;
                }

                sentences.add(new Sentence(noOfSentences,(new String(temp)).trim(),(new String(temp).trim().length(),noOfParagraphs));
                noOfSentences++;
                prevChar = nextChar;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void groupSentencesIntoParagraphs(){
        int paraNum = 0;
        Paragraph paragraph = new Paragraph(0);
        for(int i=0;i<noOfSentences;i++){
            if(sentences.get(i).paragraphNumber == paraNum){

            }else {
                paragraphs.add(paragraph);
                paraNum++;
                paragraph = new Paragraph(paraNum);
            }
            paragraph.sentences.add(sentences.get(i));

        }
        paragraphs.add(paragraph);
    }

    double noOfCommonWords(Sentence strl,Sentence str2){
        double commonCount = 0;
        for(String str1Word : strl.value.split("\\s+")){
            for(String str2Word : str2.value.split("\\s+")){

                if(str1Word.compareToIgnoreCase(str2Word) == 0){
                    commonCount++;
                }

            }
        }
        return 0;
    }

    void createIntersectionMatrix(){
        intersectionMatrix = new double[noOfSentences][noOfSentences];
        for(int i=0;i<noOfSentences;i++){
            for(int j=0;j<noOfSentences;j++){
                if(i<=j){
                    Sentence str1 = sentences.get(i);
                    Sentence str2 = sentences.get(j);
                    intersectionMatrix[i][j] = noOfCommonWords(str1,str2) / ((double)(str1.noOfWords + str2.noOfWords)/2)
                }else{
                    intersectionMatrix[i][j] = intersectionMatrix[j][i];
                }
            }
        }
    }
    void createDictionary(){
        for(int i=0;i<noOfSentences;i++){
            double score = 0;
            for (int j=0;j<noOfSentences;j++){
                score+=intersectionMatrix[i][j];
            }
            dictionary.put(sentences.get(i),score);
            ((Sentence)sentences.get(i)).score = score;
        }
    }

    void createSummary(){
        for()
    }


}
