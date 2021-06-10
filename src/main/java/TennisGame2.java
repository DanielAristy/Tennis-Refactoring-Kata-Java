
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;
    private String palabras[] = {"Love","Fifteen","Thirty","Forty"};
    private String score = "";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){

        if (isSameNumber(P1point,P2point) && isLessThan(P1point,4))
        {
            score = (isGreaterOrEqualThan(P1point,0) &&
                    isLessThan(P1point,3))? palabras[P1point] : "";
            score += "-All";
        }
        if (isSameNumber(P1point,P2point)&& isGreaterOrEqualThan(P1point,3))
            score = "Deuce";

        if (isGreaterThan(P1point,0) && isSameNumber(P2point,0))
        {
            //mayor> 0 o menor que cuatro
            P1res = (isGreaterOrEqualThan(P1point,0) &&
                    isLessThan(P1point,4))? palabras[P1point] : "";
            P2res = "Love";
            showPlayerScore();
        }
        if (isGreaterThan(P2point,0) && isSameNumber(P1point,0))
        {
            P2res = (isGreaterOrEqualThan(P2point,0) &&
                    isLessThan(P2point,4))? palabras[P2point] : "";
            P1res = "Love";
            showPlayerScore();
        }

        if (isGreaterThan(P1point,P2point) && isLessThan(P1point,4))
        {
            P1res = (isSameNumber(P1point,2))? palabras[P1point] : palabras[P1point];
            P2res = (isSameNumber(P2point,1))? palabras[P2point] : palabras[P2point];
            showPlayerScore();
        }
        if (isGreaterThan(P2point,P1point) && isLessThan(P2point,4))
        {
            P2res = (isSameNumber(P2point,2))? palabras[P2point] : palabras[P2point];
            P1res = (isSameNumber(P1point,1))? palabras[P1point] : palabras[P1point];
            showPlayerScore();
        }


        if (isGreaterThan(P1point,P2point) && isGreaterOrEqualThan(P2point,3))
        {
            score = "Advantage player1";
        }
        if (isGreaterThan(P2point,P1point)&& isGreaterOrEqualThan(P1point,3))
        {
            score = "Advantage player2";
        }

        if (isGreaterOrEqualThan(P1point,4) &&
                isGreaterOrEqualThan(P2point,0) &&
                isGreaterOrEqualThan(substractNumbers(P1point,P2point),2))
        {
            score = "Win for player1";
        }
        if (isGreaterOrEqualThan(P2point, 4) &&
                isGreaterOrEqualThan(P1point,0) &&
                isGreaterOrEqualThan(substractNumbers(P2point,P1point),2))
        {
            score = "Win for player2";
        }
        return score;
    }

    private void showPlayerScore() {
        score = P1res + "-" + P2res;
    }

    private boolean isLessThan(int scorePlayer1, int minorNumber){
        return scorePlayer1 < minorNumber;
    }

    private int substractNumbers(int number1, int number2){
        return number1 - number2;
    }
    private boolean isSameNumber(int scorePlayer1, int scorePlayer2) {
        return scorePlayer1 == scorePlayer2;
    }

    private boolean isGreaterOrEqualThan(int scorePlayer1, int biggerNumber) {
        return scorePlayer1 >= biggerNumber;
    }

    private boolean isGreaterThan(int scorePlayer1, int biggerNumber) {
        return scorePlayer1 > biggerNumber;
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}