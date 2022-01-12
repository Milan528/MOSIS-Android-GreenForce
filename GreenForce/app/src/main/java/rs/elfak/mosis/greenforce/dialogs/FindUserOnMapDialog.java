package rs.elfak.mosis.greenforce.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;


import rs.elfak.mosis.greenforce.R;
import rs.elfak.mosis.greenforce.interfaces.IFindUserOnMapDialogListener;
import rs.elfak.mosis.greenforce.interfaces.IFragmentComponentInitializer;

public class FindUserOnMapDialog extends AppCompatDialogFragment implements IFragmentComponentInitializer {
    private EditText username;
    private IFindUserOnMapDialogListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_find_user_on_map,null);

        builder.setView(view)
                .setTitle("Locate user")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Find", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                     String text=username.getText().toString();
                     listener.onUsernameReceived(text);

            }
        });
        initializeComponents(view);
     return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener=(IFindUserOnMapDialogListener)context;
    }

    @Override
    public void initializeComponents(View v) {
        username=v.findViewById(R.id.dialog_find_user_username);
    }

}
