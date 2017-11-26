package cherry.vitas.ipcalculator.controller;

import android.widget.CheckBox;
import android.widget.EditText;

public class Input {

    private CheckBox mBinaryInput;
    private EditText mIPAddressInput;
    private EditText mNetmaskInput;

    public boolean isEmpty() { return mIPAddressInput.length() == 0 || mNetmaskInput.length() == 0; }

    public void setBinaryInput(CheckBox mBinaryInput) {
        this.mBinaryInput = mBinaryInput;
    }

    public void setIPAddress(EditText mIPAddressInput) {
        this.mIPAddressInput = mIPAddressInput;
    }

    public void setNetmask(EditText mNetmaskInput) {
        this.mNetmaskInput = mNetmaskInput;
    }

    String getIPAddress() { return mIPAddressInput.getText().toString(); }

    String getNetmask() { return mNetmaskInput.getText().toString(); }

    boolean isBinaryInputChecked() { return mBinaryInput.isChecked(); }
}
