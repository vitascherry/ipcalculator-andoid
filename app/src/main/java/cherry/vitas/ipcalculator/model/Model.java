package cherry.vitas.ipcalculator.model;

import cherry.vitas.ipcalculator.controller.Notation;

import static cherry.vitas.ipcalculator.model.NumericConstants.MAX_NETMASK_HOST_COUNT;
import static cherry.vitas.ipcalculator.model.NumericConstants.NETMASK_MAXIMUM;
import static cherry.vitas.ipcalculator.model.IPCalculator.*;

public class Model {
    private IPCalculatorDataFactory dataFactory;
    private IPCalculatorData data;

    public void clearData() {
        data = null;
    }

    public IPCalculatorData getData() {
        return data;
    }

    /**
     * Initialize calculator with IP and Netmask
     * @param ip String with IP Address
     * @param netmask String with Netmask/Netmask Address
     */
    public void initCalculator(String ip, String netmask, Notation type) {
        switch (type) {
            case DECIMAL:
                dataFactory = new IPCalculatorDecimalDataFactory();
                break;
            case BINARY:
                dataFactory = new IPCalculatorBinaryDataFactory();
                break;
        }
        data = dataFactory.create(ip, netmask);
    }

    /**
     * Calculates all data defined by app logic
     */
    public void calculateData() {
        IPAddress wildcard =
                calculateWildcard(data.getNetmask());
        data.setWildcard(wildcard);
        IPAddress network =
                calculateNetwork(data.getAddress(), data.getNetmask());
        data.setNetwork(network);
        IPAddress broadcast =
                calculateBroadcast(data.getAddress(), wildcard);
        data.setBroadcast(broadcast);
        data.setMinHost( calculateMinHost(network) );
        if(isNetmaskMaximum()) {
            data.setMaxHost(broadcast.clone());
            data.setMaxHostCount(MAX_NETMASK_HOST_COUNT);
        } else {
            data.setMaxHost(calculateMaxHost(broadcast));
            data.setMaxHostCount(calculateMaxHostCount(wildcard));
        }
    }

    /**
     * @return true, if netmask value is max, else - false
     */
    private boolean isNetmaskMaximum() {
        return data.getNetmaskValue() == NETMASK_MAXIMUM;
    }
}
