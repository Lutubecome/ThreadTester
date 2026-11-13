public class ThreadTesterReal {

    public ThreadTesterReal(){

        int sleeptime = 100;
        int anzahlDurchlaeufe = 5;

        System.out.println("\n\n\tStarte Ausgabe:\n");
        Zahlausgabe z1 = new Zahlausgabe(1, anzahlDurchlaeufe, sleeptime, "\t");
        Zahlausgabe z2 = new Zahlausgabe(2, anzahlDurchlaeufe, sleeptime, "\t\t");
        Zahlausgabe z3 = new Zahlausgabe(3, anzahlDurchlaeufe, sleeptime, "\t\t\t");
        Zahlausgabe z4 = new Zahlausgabe(4, anzahlDurchlaeufe, sleeptime, "\t\t\t\t");

        z1.start();
        z2.start();
        z3.start();
        z4.start();

        while(z1.isAlive() || z2.isAlive() || z3.isAlive() || z4.isAlive()){
        }

        System.out.println("Programm beendet!");

    }

    static void main() throws InterruptedException {
        ThreadTesterReal t = new ThreadTesterReal();
    }

}

class Zahlausgabe extends Thread{

    int nummer, anzahl, time;
    String tab;

    public Zahlausgabe(int nummer, int anzahlDurchlaeufe, int sleepTime, String tabulator){

        this.nummer = nummer;
        this.anzahl = anzahlDurchlaeufe;
        this.time = sleepTime;
        this.tab = tabulator;

    }


    public void run() {

        IO.println(tab+"Thread " + nummer + " gestartet !");

        for (int i = 0; i<anzahl; i++){

            IO.println(tab + "Z" + nummer + ": " + i);

            try {
                sleep(time+nummer*10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
