package cherry.vitas.ipcalculator.model;

import static cherry.vitas.ipcalculator.model.Converter.octetArrayToIntValue;

class IPCalculatorBinaryDataFactory implements IPCalculatorDataFactory {
    @Override
    public IPCalculatorData create(String ip, String netmask) {
        IPCalculatorData data = new IPCalculatorData();

        data.setAddress(new IPAddressBinary(ip));

        IPAddress netmaskAddress = new IPAddressBinary(netmask);
        int netmaskValue = octetArrayToIntValue(netmaskAddress.getAddress());
        data.setNetmaskValue(netmaskValue);
        data.setNetmask(netmaskAddress);

        return data;
    }
}
