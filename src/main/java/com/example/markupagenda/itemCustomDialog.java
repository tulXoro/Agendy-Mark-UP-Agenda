package com.example.markupagenda;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class itemCustomDialog extends DialogFragment{

    private static final String TAG = "MyCustomDialog";

    public interface OnInputListener{
        void sendInput(String input);
    }
    public OnInputListener mOnInputListener;

    //widgets
    private EditText mInput;
    private TextView mActionOk, mActionCancel;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dialog_selection, container, false);
        mActionCancel = view.findViewById(R.id.action_cancel);
        mActionOk = view.findViewById(R.id.action_ok);
        mInput = view.findViewById(R.id.input);

        mActionCancel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                getDialog().dismiss();
            }
        });

        mActionOk.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                Snackbar.make(v, "Understood.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                String input = mInput.getText().toString();

                //FIXME
                mOnInputListener.sendInput(input);
                getDialog().dismiss();

            }


        });
        return view;
    }

    //TODO
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            mOnInputListener = (OnInputListener) getActivity();
        }catch(ClassCastException e){
            Log.e(TAG, "OnAttach: ClassCastException: " + e.getMessage());
        }
    }


}
