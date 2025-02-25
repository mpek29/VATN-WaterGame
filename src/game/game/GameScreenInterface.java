package game;

public interface GameScreenInterface {
	
	// Interface pour la gestion des questions et réponses
	public QuizQuestion showQuestion();
	public void showAnswer();
	public boolean registerAnswer(QuizQuestion questions,String answers);
	
	// Interface pour la gestion des ressources
	public void showScore(int score, int time );
	public void getScore();
	
	// Interface pour la création du jeu
	public void createGame();
	public void ckeckSave();
	
	// Interface pour l'affichage du jeu
	public void showScreen();
	public void hideScreen();
	public void resetScreen();
	

}
