
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;
    private String palabras[] = {"Fifteen","Thirty","Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (isSameNumber(P1point,P2point) && isLessThan(P1point,4))
        {
            if (isSameNumber(P1point,0))
                score = "Love";
            if (isSameNumber(P1point,1))
                score = "Fifteen";
            if (isSameNumber(P1point,2))
                score = "Thirty";
            score += "-All";
        }
        if (isSameNumber(P1point,P2point)&& isGreaterOrEqualThan(P1point,3))
            score = "Deuce";
        
        if (isGreaterThan(P1point,0) && isSameNumber(P2point,0))
        {
            //mayor> 0 o menor que cuatro
            P1res = (isGreaterOrEqualThan(P1point,0) && isLessThan(P1point,4))? palabras[P1point - 1] : "";
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (isGreaterThan(P2point,0) && isSameNumber(P1point,0))
        {
            P2res = (isGreaterOrEqualThan(P2point,0) && isLessThan(P2point,4))? palabras[P2point - 1] : "";
            P1res = "Love";
            score = P1res + "-" + P2res;
        }


        if (isGreaterThan(P1point,P2point) && isLessThan(P1point,4))
        {

            if (isSameNumber(P1point,2))
                P1res="Thirty";
            if (isSameNumber(P1point,3))
                P1res="Forty";
            if (isSameNumber(P2point,1))
                P2res="Fifteen";
            if (isSameNumber(P2point,2))
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (isGreaterThan(P2point,P1point) && isLessThan(P2point,4))
        {
            if (isSameNumber(P2point,2))
                P2res="Thirty";
            if (isSameNumber(P2point,3))
                P2res="Forty";
            if (isSameNumber(P1point,1))
                P1res="Fifteen";
            if (isSameNumber(P1point,2))
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
        // es mayor que && es mayor igual que
        if (isGreaterThan(P1point,P2point) && isGreaterOrEqualThan(P2point,3))
        {
            score = "Advantage player1";
        }
        // es mayor que && es mayor igual que
        if (isGreaterThan(P2point,P1point)&& isGreaterOrEqualThan(P1point,3))
        {
            score = "Advantage player2";
        }

        if (isGreaterOrEqualThan(P1point,4) && isGreaterOrEqualThan(P2point,0) && isGreaterOrEqualThan(substractNumbers(P1point,P2point),2))
        {
            score = "Win for player1";
        }
        if (isGreaterOrEqualThan(P2point, 4) &&  isGreaterOrEqualThan(P1point,0) && isGreaterOrEqualThan(substractNumbers(P2point,P1point),2))
        {
            score = "Win for player2";
        }
        return score;
    }

    private boolean isLessThan(int scorePlayer1, int minorNumber) {
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