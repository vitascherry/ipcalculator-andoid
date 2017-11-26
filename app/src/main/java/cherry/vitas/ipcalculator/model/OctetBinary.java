package cherry.vitas.ipcalculator.model;

import java.util.BitSet;

import static cherry.vitas.ipcalculator.model.StringConstants.NEGATIVE_BIT;
import static cherry.vitas.ipcalculator.model.StringConstants.POSITIVE_BIT;
import static cherry.vitas.ipcalculator.model.NumericConstants.OCTET_SIZE;

public class OctetBinary extends Octet {

    OctetBinary(String s) { super(parseBitSet(s)); }

    static BitSet parseBitSet(String s) {
        BitSet newBitSet = new BitSet(s.length());
        for (int i = 0; i < s.length(); ++i) {
            boolean bit = s.charAt(i) == '1';
            newBitSet.set(i, bit);
        }
        return newBitSet;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < OCTET_SIZE; ++i)
            s.append((getBitSet().get(i)) ? POSITIVE_BIT : NEGATIVE_BIT);
        return s.toString();
    }
}
