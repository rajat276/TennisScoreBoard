import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class ScoreBoard {
    private int pointA;
    private int pointB;
    private int gameA;
    private int gameB;
    private int setA;
    private int setB;

    public ScoreBoard() {
        pointA = 0;
        pointB = 0;
        gameA = 0;
        gameB = 0;
        setA = 0;
        setB = 0;
    }

    public int getPointA() {
        return pointA;
    }

    public void setPointA(int pointA) {
        this.pointA = pointA;
    }

    public int getPointB() {
        return pointB;
    }

    public void setPointB(int pointB) {
        this.pointB = pointB;
    }

    public int getGameA() {
        return gameA;
    }

    public void setGameA(int gameA) {
        this.gameA = gameA;
    }

    public int getGameB() {
        return gameB;
    }

    public void setGameB(int gameB) {
        this.gameB = gameB;
    }

    public int getSetA() {
        return setA;
    }

    public void setSetA(int setA) {
        this.setA = setA;
    }

    public int getSetB() {
        return setB;
    }

    public void setSetB(int setB) {
        this.setB = setB;
    }

    public void generateScoreBoard(String score){
        for( int i = 0; i < score.length(); i++){
            updatePoint(score.charAt(i));
        }
        printScoreBoard();
    }

    public void updatePoint(char ch){
        if(ch=='A') {
            setPointA(getPointA()+1);
            if(getPointA() > 3 && getPointA() - getPointB() >=2  ) {
                updateGame('A');
            }
        }else{
            setPointB(getPointB()+1);
            if(getPointB() > 3 && getPointB() - getPointA() >=2  ) {
                updateGame('B');
            }
        }
    }

    public void updateGame(char player){
        if( player == 'A'){
            setGameA(getGameA()+1);
            if(getGameA() > 5 && getGameA() - getGameB() >=2  )
            updateSet('A');
        }else {
            setGameB(getGameB()+1);
            if(getGameB() > 5 && getGameB() - getGameA() >=2  )
                updateSet('B');
        }

        setPointA(0);
        setPointB(0);

    }

    public void updateSet(char player){

        if( player == 'A'){
            setSetA(getSetA()+1);

        }else {
            setSetB(getSetB()+1);

        }

        setGameA(0);
        setGameB(0);

    }


    public void printScoreBoard(){
        System.out.println("Player :\tA\tB");
        System.out.println("Sets   :\t" + getSetA() + "\t" + getSetB());
        System.out.println("Games  :\t" + getGameA() + "\t" + getGameB());
        System.out.println("Points :\t" + getPoint());
    }

    public String getPoint(){
        String actualScore [] = { "0", "15", "30", "40", "D", "A" };

        if( getPointA() < 4 && getPointB() < 4 )
            return  actualScore[getPointA()] + "\t" + actualScore[getPointB()];
        else if (Math.abs(getPointA() - getPointB()) == 0){
            return "Deuce";
        }
        else
            return "Advantage" + (getPointA()> getPointB() ? " - A" : " - B");
    }

}
