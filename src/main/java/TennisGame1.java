
public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1Name;
    private String player2Name;
    private String score = "";

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") scorePlayer1 += 1;
        else scorePlayer2 += 1;
    }

    public String getScore() {
        if (isSameNumber(scorePlayer1, scorePlayer2))
        {
            score = showDrawMessage();
        }
        else if (isGreaterThan(scorePlayer1,4) || isGreaterThan(scorePlayer2,4))
        {
            score = showFinalMessage();
        }
        else
        {
            score = showScoreMessage(score);
        }
        return score;
    }

    private boolean isGreaterThan(int scorePlayer1, int biggerNumber) {
        return scorePlayer1 >= biggerNumber;
    }

    private boolean isSameNumber(int scorePlayer1, int scorePlayer2) {
        return scorePlayer1 == scorePlayer2;
    }

    private String showScoreMessage(String score) {
        String palabras[] = {"Love","Fifteen","Thirty","Forty"};
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = scorePlayer1;
            else { score +="-"; tempScore = scorePlayer2;}
            score += palabras[tempScore];
        }
        return score;
    }

    private String showFinalMessage() {
        int minusResult = scorePlayer1 - scorePlayer2;
        if (isSameNumber(minusResult,1)) score ="Advantage player1";
        else if (isSameNumber(minusResult,-1)) score ="Advantage player2";
        else if (isGreaterThan(minusResult,2)) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private String showDrawMessage() {
        String palabras[] = {"Love-All", "Fifteen-All", "Thirty-All"};
        return (isLessThanOrEqual(scorePlayer1, 2)) ? palabras[scorePlayer1] : "Deuce";
    }

    private boolean isLessThanOrEqual(int scorePlayer1, int minorNumber) {
        return scorePlayer1 <= minorNumber;
    }
}
