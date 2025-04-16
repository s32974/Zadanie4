public class Zamowienie {

    private int id;
    private Klient klient;
    private Produkt[] produkty;
    private int[] ilosci;
    private String dataZamowienia;
    private String status;

    public Zamowienie(int id, Klient klient, Produkt[] produkty, int[] ilosci, String dataZamuwienia, String wTrakcieRealizacjii) {
        this.id = id;
        this.klient = klient;
        this.produkty = produkty;
        this.ilosci = ilosci;
        this.dataZamowienia = dataZamuwienia;
        this.status = wTrakcieRealizacjii;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(String dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Produkt[] getProdukty() {
        return produkty;
    }

    public void setProdukty(Produkt[] produkty) {
        this.produkty = produkty;
    }

    public int[] getIlosci() {
        return ilosci;
    }

    public void setIlosci(int[] ilosci) {
        this.ilosci = ilosci;
    }

    public void obliczWartoscZamowienia() {
        double wartosc = 0;

        for (int i = 0; i < produkty.length; i++) {

            wartosc += produkty[i].getCena() * ilosci[i];

        }

        System.out.println("Wartosc zamowienia:" + wartosc);

    }

    public double zastosujZnizke() {
        double zniszka = 0;
        if (klient.isCzyStaly()) {

            zniszka = 10;

        }

        return zniszka;
    }


    public void wyswietlSzczegoly() {


        System.out.println("Zamuwienie:" + this.id);
        System.out.println("klijent:" + this.klient.getImie() + " " + klient.getNazwisko());
        System.out.println("Data zamuwienia:" + this.dataZamowienia);
        System.out.println("status:" + this.status);
        for (int i = 0; i < produkty.length; i++) {
            System.out.println("produkt:" + produkty[i].getNazwa() + " ilość:" + this.ilosci[i] + " cena:" + produkty[i].getCena());

        }
        obliczWartoscZamowienia();

    }

}
