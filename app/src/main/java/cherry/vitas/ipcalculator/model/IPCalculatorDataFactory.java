package cherry.vitas.ipcalculator.model;

public interface IPCalculatorDataFactory {
    IPCalculatorData create(String ip, String netmask);
}
