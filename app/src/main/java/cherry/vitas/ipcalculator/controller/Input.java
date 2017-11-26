package cherry.vitas.ipcalculator.controller;

import android.widget.EditText;
import android.widget.RadioButton;

public class Input {

    private RadioButton mIPAddressBinary;
    private RadioButton mNetmaskBinary;
    private EditText mIPAddress;
    private EditText mNetmask;

    public boolean isEmpty() { return mIPAddress.length() == 0 || mNetmask.length() == 0; }

    public void setIPAddressBinary(RadioButton mIPAddressBinary) {
        this.mIPAddressBinary = mIPAddressBinary;
    }

    public void setNetmaskBinary(RadioButton mNetmaskBinary) {
        this.mNetmaskBinary = mNetmaskBinary;
    }

    public void setIPAddress(EditText mIPAddress) {
        this.mIPAddress = mIPAddress;
    }

    public void setNetmask(EditText mNetmask) {
        this.mNetmask = mNetmask;
    }

    String getIP() { return mIPAddress.getText().toString(); }

    String getNetmask() { return mNetmask.getText().toString(); }

    boolean getIPBinaryChecked() { return mIPAddressBinary.isChecked(); }

    boolean getNetmaskBinaryChecked() { return mNetmaskBinary.isChecked(); }
}
