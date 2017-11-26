package cherry.vitas.ipcalculator.model;

import static cherry.vitas.ipcalculator.model.Converter.intValueToOctetArray;
import static cherry.vitas.ipcalculator.model.Converter.octetArrayToIntValue;
import static cherry.vitas.ipcalculator.utils.NetmaskUtils.isNumber;

class IPCalculatorDecimalDataFactory implements IPCalculatorDataFactory {
    @Override
    public IPCalculatorData create(String ip, String netmask) {
        IPCalculatorData data = new IPCalculatorData();

        data.setAddress(new IPAddress(ip));

        IPAddress netmaskAddress;
        int netmaskValue;
        if(isNumber(netmask)) {
            netmaskValue = Integer.parseInt(netmask);
            netmaskAddress = new IPAddress(intValueToOctetArray(netmaskValue));
        } else {
            netmaskAddress = new IPAddress(netmask);
            netmaskValue = octetArrayToIntValue(netmaskAddress.getAddress());
        }
        data.setNetmaskValue(netmaskValue);
        data.setNetmask(netmaskAddress);

        return data;
    }
}
