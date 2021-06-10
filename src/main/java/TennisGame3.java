
public class TennisGame3 implements TennisGame {
    
    private int playerTwoPoints;
    private int playerOnePoints;
    private String namePlayerOne;
    private String namePlayerTwo;
    private String[] palabras = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String namePlayerOne, String namePlayerTwo) {
        this.namePlayerOne = namePlayerOne;
        this.namePlayerTwo = namePlayerTwo;
    }
    public String getScore() {
        String response;

        if (isLessThat(playerOnePoints) && isLessThat(playerTwoPoints)
                && !(toAddNumbers(playerOnePoints, playerTwoPoints) == 6)) {

            response = palabras[playerOnePoints];
            return isSameThan(playerOnePoints, playerTwoPoints) ? response + "-All" : response + "-" + palabras[playerTwoPoints];
        } else {

            if (isSameThan(playerOnePoints, playerTwoPoints))
                return "Deuce";
            response = isGreaterThat(playerOnePoints, playerTwoPoints) ? namePlayerOne : namePlayerTwo;
            return (squareNumber(subtractNumbers(playerOnePoints, playerTwoPoints)) == 1) ? "Advantage " + response : "Win for " + response;
        }
    }

    private int squareNumber(int number){
        return (int) Math.pow(number,2);
    }

    private int subtractNumbers(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }

    private boolean isGreaterThat(int numberOne, int numberTwo) {
        return numberOne > numberTwo;
    }

    private boolean isSameThan(int numberOne, int numberTwo) {
        return numberOne == numberTwo;
    }

    private int toAddNumbers(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    private boolean isLessThat(int number) {
        return number < 4;
    }
    

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.playerOnePoints += 1;
        else
            this.playerTwoPoints += 1;
        
    }

}
