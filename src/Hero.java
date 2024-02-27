public class Hero {
    private int hitPoints;
    private String name;
    private String winner = "";


    public Hero (String name){
        this.name = name;
        hitPoints = 100;
    }
    public String getName(){
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }

    public String toString(){
        return "Hero{" + "name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent){
        double ran = Math.random();
        if(ran<0.5){
            opponent.hitPoints -= 10;
        }
        else {
            hitPoints -= 10;
        }

    }

    public void senzuBean(){
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        while (opponent.hitPoints > 0 && hitPoints > 0) {
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return getName() + ": " + getHitPoints() + "\t" + opponent.getName() + ": " + opponent.getHitPoints();
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int numHeroWins = 0;
        int numoppWin = 0;
        int[] wins = new int[2];
        while (n >0){
            senzuBean();
            opponent.senzuBean();
            fightUntilTheDeath(opponent);
            if (hitPoints <= 0) {
                numoppWin++;
            } else {
                numHeroWins++;
            }
            n--;
        }
        senzuBean();
        opponent.senzuBean();
        if (numoppWin > numHeroWins){
            winner += opponent.getName() + "wins";
        }
        else if ( numHeroWins > numoppWin){
            winner+= getName()+"wins";
        }
        else{
            winner += "It has ended in a draw";
        }
        wins[0]=numoppWin;
        wins[1]=numHeroWins;

        return wins;
    }

    public String nFightsToTheDeath(Hero opponent, int x ){
        int [] wins = nFightsToTheDeathHelper(opponent,x);
        senzuBean();
        opponent.senzuBean();
        return getName() + ": " + wins[1] +" wins\n" + opponent.getName() + ": " + wins[0] +" wins\n" + winner + "wins!";

    }
    public void dramaticFightToTheDeath(Hero opponent){
        while (opponent.hitPoints != 0 && hitPoints > 0 || hitPoints != 0 && opponent.hitPoints > 0) {
            attack(opponent);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        toString();
    }
}



