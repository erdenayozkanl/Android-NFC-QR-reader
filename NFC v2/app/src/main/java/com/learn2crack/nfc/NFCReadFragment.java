package com.learn2crack.nfc;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;


public class NFCReadFragment extends DialogFragment {

    public static  String TAG = NFCReadFragment.class.getSimpleName();
    public static String message;
    public static NdefMessage ndefMessage;
    public static NFCReadFragment newInstance() {

        return new NFCReadFragment();
    }

    private TextView mTvMessage;
    private Listener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_read,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {

        mTvMessage = (TextView) view.findViewById(R.id.tv_message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (MainActivity)context;
        mListener.onDialogDisplayed();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener.onDialogDismissed();
    }

    public void onNfcDetected(Ndef ndef){

        readFromNFC(ndef);
    }

    public void readFromNFC(Ndef ndef) {

        try {
            ndef.connect();
            Intent intent = new Intent(getActivity(), Main2Activity.class);
             ndefMessage = ndef.getNdefMessage();
             message = new String(ndefMessage.getRecords()[0].getPayload());
            Log.d(TAG, "readFromNFC: "+message);
            mTvMessage.setText(message);
            message=mTvMessage.getText().toString();

            String name = message;
            intent.putExtra("name", name);
            startActivity(intent);
            ndef.close();


        } catch (IOException | FormatException e) {
            e.printStackTrace();

        }
    }
}
