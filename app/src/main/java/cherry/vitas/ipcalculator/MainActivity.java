package cherry.vitas.ipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import cherry.vitas.ipcalculator.controller.Controller;
import cherry.vitas.ipcalculator.model.Model;
import cherry.vitas.ipcalculator.controller.Input;

public class MainActivity extends AppCompatActivity {

    private Controller appController;
    private cherry.vitas.ipcalculator.view.View appView;
    private Input appInput;
    Button mCalculateBinary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Model appModel = new Model();
        appView = new cherry.vitas.ipcalculator.view.View();
        appInput = new Input();
        appController = new Controller(appModel, appView, appInput);
        mCalculateBinary = (Button)findViewById(R.id.CalculateBinary);

        initInputView();
        initTextView();
    }

    private void initInputView() {
        appInput.setIPAddress((EditText) findViewById(R.id.IPAddressInput));
        appInput.setNetmask((EditText) findViewById(R.id.NetmaskInput));
        appInput.setIPAddressBinary((RadioButton) findViewById(R.id.IPAddressBinary));
        appInput.setNetmaskBinary((RadioButton) findViewById(R.id.NetmaskBinary));
    }

    private void initTextView() {
        appView.setErrorMassage((TextView) findViewById(R.id.ErrorMassage));
        appView.setIPAddressValue((TextView) findViewById(R.id.IPAddressValue));
        appView.setIPAddressBitString((TextView) findViewById(R.id.IPAddressBitString));
        appView.setNetmaskValue((TextView) findViewById(R.id.NetmaskValue));
        appView.setNetmaskBitString((TextView) findViewById(R.id.NetmaskBitString));
        appView.setWildcardValue((TextView) findViewById(R.id.WildcardValue));
        appView.setWildcardBitString((TextView) findViewById(R.id.WildcardBitString));
        appView.setNetworkValue((TextView) findViewById(R.id.NetworkValue));
        appView.setNetworkBitString((TextView) findViewById(R.id.NetworkBitString));
        appView.setBroadcastValue((TextView) findViewById(R.id.BroadcastValue));
        appView.setBroadcastBitString((TextView) findViewById(R.id.BroadcastBitString));
        appView.setMinHostValue((TextView) findViewById(R.id.MinHostValue));
        appView.setMinHostBitString((TextView) findViewById(R.id.MinHostBitString));
        appView.setMaxHostValue((TextView) findViewById(R.id.MaxHostValue));
        appView.setMaxHostBitString((TextView) findViewById(R.id.MaxHostBitString));
        appView.setMaxHostCountValue((TextView) findViewById(R.id.MaxHostCount));
    }

    public void onClickCalculate(View view) {
        appView.clearTextView();
        if(!appInput.isEmpty()) {
            appController.processClickCalculate();
            mCalculateBinary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appController.processClickBinary();
                }
            });
        }
    }
}
