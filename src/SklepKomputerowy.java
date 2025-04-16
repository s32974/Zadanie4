public class SklepKomputerowy {

    private Produkt[] produkty;
    private Klient[] klienci;
    private Zamowienie[] zamowienia;
    private int liczbaProduktow;
    private int liczbaKlientow;
    private int liczbaZamowien;

    public SklepKomputerowy() {
        this.produkty = new Produkt[10];
        this.klienci = new Klient[10];
        this.zamowienia = new Zamowienie[10];
        this.liczbaProduktow = 0;
        this.liczbaKlientow = 0;
        this.liczbaZamowien = 0;
    }


    public Klient[] getKlienci() {
        return klienci;
    }

    public void setKlienci(Klient[] klienci) {
        this.klienci = klienci;
    }

    public Produkt[] getProdukty() {
        return produkty;
    }

    public void setProdukty(Produkt[] produkty) {
        this.produkty = produkty;
    }

    public Zamowienie[] getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(Zamowienie[] zamowienia) {
        this.zamowienia = zamowienia;
    }

    public int getLiczbaProduktow() {
        return liczbaProduktow;
    }

    public void setLiczbaProduktow(int liczbaProduktow) {
        this.liczbaProduktow = liczbaProduktow;
    }

    public int getLiczbaKlientow() {
        return liczbaKlientow;
    }

    public void setLiczbaKlientow(int liczbaKlientow) {
        this.liczbaKlientow = liczbaKlientow;
    }

    public int getLiczbaZamowien() {
        return liczbaZamowien;
    }

    public void setLiczbaZamowien(int liczbaZamowien) {
        this.liczbaZamowien = liczbaZamowien;
    }


    public void dodajProdukt(Produkt produkt) {

        if (liczbaProduktow < produkty.length) {
            produkty[liczbaProduktow++] = produkt;
            System.out.println("dodano produkt pomyślnie " + produkt.getNazwa());
        } else {
            System.out.println("nie udało się dodać produktu");
        }
    }

    public void dodajKlienta(Klient klient) {
        if (liczbaKlientow < klienci.length) {
            klienci[liczbaKlientow++] = klient;
            System.out.println("dodano klijenta pomyślnie");
        } else {
            System.out.println("nie udało się dodać klijenta");
        }
    }

    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {

        Zamowienie zamowienie = new Zamowienie(liczbaZamowien + 1, klient, produkty, ilosci, "12.03.2025", "w trakcie realizacjii");
        if (liczbaZamowien < zamowienia.length) {
            zamowienia[liczbaZamowien++] = zamowienie;
            System.out.println("dodano zamuwienie pomyślnie");
        } else {
            System.out.println("nie udało się dodać zamuwienia");
        }

        return zamowienie;
    }

    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {

        Produkt[] mojeProdukty = zamowienie.getProdukty();
        int[] ilosci = zamowienie.getIlosci();

        for (int i = 0; i < mojeProdukty.length; i++) {
            for (int j = 0; j < liczbaProduktow; j++) {
                int ilosc = produkty[j].getIloscWMagazynie();
                int ruznica = ilosc - ilosci[i];
                produkty[j].setIloscWMagazynie(ruznica);

            }


        }

    }


    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {

        for (int i = 0; i < liczbaZamowien; i++) {

            if (zamowienia[i].getId() == idZamowienia) {
                zamowienia[i].setStatus(nowyStatus);
            }
        }
    }


    public void wyswietlProduktyWKategorii(String kategoria) {

        for (int i = 0; i < liczbaProduktow; i++) {

            if (produkty[i].getKategoria().equals(kategoria)) {
                System.out.println(produkty[i].getNazwa());

            }


        }

    }


    public void wyswietlZamowieniaKlienta(int idKlienta) {
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getKlient().getId() == idKlienta) {
                System.out.println("Id zamuwieńa" + zamowienia[i].getId());
            }
        }
    }


}
