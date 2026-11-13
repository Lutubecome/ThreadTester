

public class ThreadTester {
  
  public ThreadTester() throws InterruptedException {
    
    int sleeptime = 100;
    int anzahlDurchlaeufe = 5; 
    
    System.out.println("\n\n\tStarte Ausgabe:\n");
    Zahlenausgabe z1 = new Zahlenausgabe(1, anzahlDurchlaeufe, sleeptime, "\t"); 
    Zahlenausgabe z2 = new Zahlenausgabe(2, anzahlDurchlaeufe, sleeptime, "\t\t"); 
    Zahlenausgabe z3 = new Zahlenausgabe(3, anzahlDurchlaeufe, sleeptime, "\t\t\t"); 
    Zahlenausgabe z4 = new Zahlenausgabe(4, anzahlDurchlaeufe, sleeptime, "\t\t\t\t"); 
    
    //rufe run-Methoden auf

    z1.run();
    z2.run();
    z3.run();
    z4.run();

    
    System.out.println("\n\tProgramm beendet!");
    
  }
  
  
  public static void main(String[] args) throws InterruptedException {
    ThreadTester t = new ThreadTester();   
  }
  
}


class Zahlenausgabe {

  int nummer, anzahl, time;
  String tab;
  
  public Zahlenausgabe(int nummer, int anzahlDurchlaeufe, int sleepTime, String tabulator){

    this.nummer = nummer;
    this.anzahl = anzahlDurchlaeufe;
    this.time = sleepTime;
    this.tab = tabulator;
    
  }
  
  public void run() throws InterruptedException {

    for (int i = 0; i<anzahl; i++){

      IO.println(tab + "Z" + nummer + ": " + i);

      Thread.sleep(time);

    }
    
  }
  
}
