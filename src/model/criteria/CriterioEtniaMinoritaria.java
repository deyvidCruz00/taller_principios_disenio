package model;

public class CriterioEtniaMinoritaria implements CriterioOrdenamiento {
    @Override
    public int comparar(Candidato c1, Candidato c2) {
        boolean c1Minoritaria = c1.esEtniaMinoritaria();
        boolean c2Minoritaria = c2.esEtniaMinoritaria();

        if (c1Minoritaria && !c2Minoritaria) return -1;
        if (!c1Minoritaria && c2Minoritaria) return 1;
        return 0;
    }
}
