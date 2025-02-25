package game;

public class QuizQuestion {
	private int indexCurrentQuestion;
    private String questionStatement;
    private String[] answerOptions;
	private CountryRessources[] answerChange;
   
    public QuizQuestion(int indexCurrentQuestion, String questionStatement, String[] answerOptions, CountryRessources[] answerChange) {
    	this.indexCurrentQuestion = indexCurrentQuestion;
    	this.questionStatement = questionStatement;
    	this.answerOptions = answerOptions;
    	this.answerChange = answerChange;
    }
    
    
    public int getNumberQuestion() {
        return indexCurrentQuestion;
    }
    
    public void nextNumberQuestion() {
    	this.indexCurrentQuestion += 1;
    }
    
    public String getQuestionStatement() {
        return questionStatement;
    }

    public void setQuestionStatement(String questionStatement) {
        this.questionStatement = questionStatement;
    }

    public String[] getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(String[] answerOptions) {
        this.answerOptions = answerOptions;
    }
    
    public CountryRessources getCountryRessources(int index){
    	return this.answerChange[index];
        
    }
}
