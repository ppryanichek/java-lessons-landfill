class DuckDuckGoose {
  
  public static class Player {
    String name;
    
    public Player(String name) {
      this.name = name;
    }
    
    public Player() {
    }
    
    Player[] makePlayerArr(String[] str) {
      Player[] myStrings = new Player[str.length];
      
      for (int i = 0; i < str.length; i++) {
        myStrings[i] = new Player(str[i]);
      }
      return myStrings;
    }
  }
  
  public static String duckDuckGoose(Player[] players, int goose) {
    // my code 
    // int index;
    // for (index = 0; index < goose; index++) {
    //   if(index == players.length){index = 0;}
    // }
    //   return players[index-1].name;

    return players[(goose - 1) % players.length].name;
  }
    
  public static void main(String[] args) {
    Player[] players = new Player().makePlayerArr(new String[] { "a", "b", "c", "d" });

    int goose = 7;
    System.out.println("Player name: \'" + duckDuckGoose(players, goose) + "\'");
  }
}

