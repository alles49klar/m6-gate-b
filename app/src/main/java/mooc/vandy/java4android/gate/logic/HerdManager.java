package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */

    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /**
     * Constructor initializes the fields.
     */
    public static final int HERD = 24;

    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    // TODO -- Fill your code in here
    public void simulateHerd(Random rand) {
        int ahir_hayvan_sayisi=HERD;
       mOut.println("There are currently "+ ahir_hayvan_sayisi+ " snails in the pen and "+(HERD-ahir_hayvan_sayisi)+" snails in the pasture");


        for (int i=0;i<10;i++){



            if(ahir_hayvan_sayisi==HERD){
                ahir_hayvan_sayisi+=mEastGate.thru(rand.nextInt(24)+1);


            }
            else if(ahir_hayvan_sayisi==0){
                ahir_hayvan_sayisi+=mWestGate.thru(rand.nextInt(24)+1);
            }else{
                int hangi_kapi=rand.nextInt(2);
                if (hangi_kapi==0){
                    ahir_hayvan_sayisi+=mWestGate.thru(rand.nextInt(HERD-ahir_hayvan_sayisi)+1);
                }
                else

                    ahir_hayvan_sayisi+=mEastGate.thru(rand.nextInt(ahir_hayvan_sayisi)+1);
            }
            mOut.println("There are currently "+ ahir_hayvan_sayisi+ " snails in the pen and "+(HERD-ahir_hayvan_sayisi)+" snails in the pasture");


        }

    }


}
