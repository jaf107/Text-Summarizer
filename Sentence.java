package com.company;

class Sentence{
    int paragraphNumber;
    int number;
    int stringLength;
    double score;
    int noOfWords;
    int spaceCounter;
    String value;

    Sentence(int number, String value, int stringLength, int paragraphNumber){
        this.number = number;
        this.value = new String(value);
        this.stringLength = stringLength;
        this.spaceCounter = 0;
        for(int i=0;i<stringLength;i++)
        {
            if(value.charAt(i) == ' ') {
                spaceCounter++;
            }

        }
        //noOfWords = value.split(" s+").length;
        this.noOfWords = spaceCounter + 1;
        score = 0.0;
        this.paragraphNumber=paragraphNumber;
    }
}