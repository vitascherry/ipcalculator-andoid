package cherry.vitas.ipcalculator.model;

import java.util.BitSet;

class OctetBinary extends Octet {

    OctetBinary(String s) { super(parseBitSet(s)); }

    private static BitSet parseBitSet(String s) {
        BitSet newBitSet = new BitSet(s.length());
        for (int i = 0; i < s.length(); ++i) {
            boolean bit = s.charAt(i) == '1';
            newBitSet.set(i, bit);
        }
        return newBitSet;
    }
}
