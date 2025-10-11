package up.mi.paa.reseau_electrique.model;



public enum TypeMaison {
    BASSE_CONSOMMATION(20),
    MOYENNE_CONSOMMATION(40),
    FORTE_CONSOMMATION(60);

    private final double consommationKW;

    TypeMaison(double consommationKW) {
        this.consommationKW = consommationKW;
    }

    public double getConsommationKW() {
        return consommationKW;
    }
    public static TypeMaison stringToTypeMaison(String s) {
        if (s == null) return null;

        switch (s.toUpperCase()) {
            case "BASSE":
                return TypeMaison.BASSE_CONSOMMATION;
            case "MOYENNE":
                return TypeMaison.MOYENNE_CONSOMMATION;
            case "FORTE":
                return TypeMaison.FORTE_CONSOMMATION;
            default:
                return null; // ou lever une exception si le format est incorrect
        }
    }

}
