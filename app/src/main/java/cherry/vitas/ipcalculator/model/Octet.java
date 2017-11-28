package cherry.vitas.ipcalculator.model;

import java.util.BitSet;

import static cherry.vitas.ipcalculator.model.NumericConstants.OCTET_SIZE;
import static cherry.vitas.ipcalculator.model.StringConstants.NEGATIVE_BIT;
import static cherry.vitas.ipcalculator.model.StringConstants.POSITIVE_BIT;

public class Octet {

    private BitSet bitArray;

    Octet(String s) { this(Integer.parseInt(s)); }

    Octet(int value) {
        bitArray = parseBitSet(value);
    }

    Octet(BitSet bitArray) {
        this.bitArray = bitArray;
    }

    private Octet() {bitArray = new BitSet(OCTET_SIZE);}

    void setBitSet(BitSet bitArray) { this.bitArray = bitArray; }

    BitSet getBitSet() { return bitArray; }

    static Octet invert(Octet src) {
        Octet inverted = new Octet();
        for(int i = 0; i < OCTET_SIZE; ++i) {
            boolean value = src.bitArray.get(i);
            inverted.bitArray.set(i, !value);
        }
        return inverted;
    }

    static int getDecimalRepresent(BitSet bitArray) {
        int sum = 0;
        for(int i = OCTET_SIZE - 1; i >= 0; --i)
            if(bitArray.get(i)) {
                sum += 1 << OCTET_SIZE - 1 - i;
            }
        return sum;
    }

    static BitSet parseBitSet(int value) {
        BitSet newBitSet = new BitSet(OCTET_SIZE);
        boolean remindStarted = false;
        for (int current = value, reminder = 0, i = 0; i < OCTET_SIZE; ++i) {
            if(remindStarted) {
                current = current - reminder;
                remindStarted = false;
            }
            reminder = 1 << OCTET_SIZE - 1 - i;
            if (current == reminder) {
                newBitSet.set(i, true);
                break;
            } else if (current < reminder) {
                newBitSet.set(i, false);
            } else {
                newBitSet.set(i, true);
                remindStarted = true;
            }
        }
        return newBitSet;
    }

    @Override
    public String toString() {
        return String.valueOf(getDecimalRepresent(bitArray));
    }

    String toBitString() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < OCTET_SIZE; ++i)
            s.append((getBitSet().get(i)) ? POSITIVE_BIT : NEGATIVE_BIT);
        return s.toString();
    }

    @Override
    public Octet clone() {
        BitSet clonedBitArray = (BitSet)bitArray.clone();
        return new Octet(clonedBitArray);
    }
}
