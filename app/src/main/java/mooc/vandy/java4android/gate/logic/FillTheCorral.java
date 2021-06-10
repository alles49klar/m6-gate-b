package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    // TODO -- Fill your code in here
    public void setCorralGates(Gate[] gate, Random rand) {
        mOut.println("Initial gate setup:");
        for (int i = 0; i < gate.length; i++) {
            int yon = rand.nextInt(3) - 1;


            if (yon == 1) {
                gate[i].setSwing(1);
            } else if (yon == -1) {
                gate[i].setSwing(-1);
            } else {
                gate[i].setSwing(0);
            }

            mOut.println("Gate " + i + ": " + gate[i]);

        }

    }


    public boolean anyCorralAvailable(Gate[] corral) {
        int acik_sayisi = 0;
        for (int i = 0; i < corral.length; i++) {
            if (corral[i].getSwingDirection() == Gate.IN) {
                acik_sayisi++;
            }
        }
        if (acik_sayisi >= 1) {
            return true;
        } else
            return false;


    }

    public int corralSnails(Gate[] corral, Random rand) {
        int cayir_hayvan_sayisi = 5;
        int tur_sayisi = 0;
        while (cayir_hayvan_sayisi > 0) {
            int rageleKapininIndeksi=rand.nextInt(corral.length);
            Gate rastgele_kapi = corral[rageleKapininIndeksi];
            int rastgele_hayvan_sayisi = rand.nextInt(cayir_hayvan_sayisi) + 1;
            if (rastgele_kapi.thru(rastgele_hayvan_sayisi) > 0) {
                cayir_hayvan_sayisi -= rastgele_hayvan_sayisi;
            } else if (rastgele_kapi.thru(rastgele_hayvan_sayisi) < 0) {
                cayir_hayvan_sayisi += rastgele_hayvan_sayisi;
            } else {
                cayir_hayvan_sayisi += 0;
            }
            mOut.println(rastgele_hayvan_sayisi + " are trying to move through corral " +rageleKapininIndeksi);
            tur_sayisi++;

        }
        mOut.println("It took " + tur_sayisi + " attempts to corral all of the snails.");
        return tur_sayisi;

    }
}
