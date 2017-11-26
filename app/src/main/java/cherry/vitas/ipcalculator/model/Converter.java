package cherry.vitas.ipcalculator.model;

import static cherry.vitas.ipcalculator.model.NumericConstants.OCTETS_COUNT;
import static cherry.vitas.ipcalculator.model.NumericConstants.OCTET_MAX_VALUE;
import static cherry.vitas.ipcalculator.model.NumericConstants.OCTET_SIZE;

class Converter {

    static Octet[] intValueToOctetArray(int value) {
        int cardinality = value;
        Octet[] array = new Octet[OCTETS_COUNT];
        for(int decimalValue = OCTET_MAX_VALUE, i = 0; i < OCTETS_COUNT; ++i) {
            if(cardinality < OCTET_SIZE) {
                if(cardinality <= 0) {
                    decimalValue = 0;
                } else {
                    // decimalValue represents bits count set to 1 from MSB to LSB
                    decimalValue = OCTET_MAX_VALUE + 1 - (1 << OCTET_SIZE - cardinality);
                }
            }
            array[i] = new Octet(decimalValue);
            cardinality -= OCTET_SIZE;
        }
        return array;
    }

    static int octetArrayToIntValue(Octet[] array) {
        int value = 0;
        for(int cardinality, i = 0; i < OCTETS_COUNT; ++i) {
            cardinality = array[i].getBitSet().cardinality();
            value += cardinality;
        }
        return value;
    }
}
