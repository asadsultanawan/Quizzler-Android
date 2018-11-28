package com.londonappbrewery.quizzler;

public class TrueFalse {

    private int questionid;
    private boolean answer;

    public TrueFalse(int questionresourceid, boolean trueorfalse){

        questionid = questionresourceid;
        answer = trueorfalse;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
