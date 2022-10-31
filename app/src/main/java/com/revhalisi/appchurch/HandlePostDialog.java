package com.revhalisi.appchurch;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class HandlePostDialog extends AppCompatDialogFragment {
    private EditText infor_field;  // = editAlertLayout.findViewById(R.id.editInformation);

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = getActivity().getLayoutInflater();
    View view = inflater.inflate(R.layout.edit_post_dialog,null);



        builder.setView(view)
                .setTitle("add Post")
                .setPositiveButton("post", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }
                );

        final EditText infor_field = view.findViewById(R.id.editInformation);
                return builder.create();



    }
}
