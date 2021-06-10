package mooc.vandy.java4android.gate.logic;

import androidx.annotation.NonNull;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0;
    private int mSwing;


    public Gate() {
        mSwing = CLOSED;
    }


    public boolean setSwing(int mSwing) {
        if (mSwing == IN || mSwing == OUT || mSwing == CLOSED) {
            this.mSwing = mSwing;
            return true;
        } else {
            return false;
        }

    }

    public boolean open(int mSwing) {
        if (mSwing != CLOSED) {
            setSwing(mSwing);
            return true;
        } else {
            return false;
        }
    }

    public void close() {
        setSwing(CLOSED);
    }

    public int getSwingDirection() {
        return mSwing;
    }

    public int thru(int count) {

        if (this.mSwing == IN)
            return  count;
        else if (this.mSwing == OUT)
            return (- count);

        return 0;
    }


    @Override
    public String toString() {
        if (getSwingDirection() == CLOSED) {
            return "This gate is closed";
        } else if (getSwingDirection() == IN) {
            return "This gate is open and swings to enter the pen only";
        } else if (getSwingDirection() == OUT) {
            return "This gate is open and swings to exit the pen only";
        } else {
            return "This gate has an invalid swing direction";
        }
    }
}
