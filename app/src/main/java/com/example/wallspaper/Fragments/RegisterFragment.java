package com.example.wallspaper.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wallspaper.HelperClass;
import com.example.wallspaper.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {



    private EditText first_name, last_name, register_email, register_password;
    private Button register;
    FirebaseDatabase database;
    DatabaseReference reference;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        first_name = view.findViewById(R.id.etFname);
        last_name = view.findViewById(R.id.etLname);
        register_email = view.findViewById(R.id.Remail);
        register_password = view.findViewById(R.id.etRPassword);
        register = view.findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                //fetching data from form
                String fname = first_name.getText().toString();
                String lname = last_name.getText().toString();
                String email = register_email.getText().toString();
                String password = register_password.getText().toString();

                if(fname.length()==0){
                    first_name.requestFocus();
                    first_name.setError("Field cannot be empty");
                }

                else if(lname.length()==0){
                    last_name.requestFocus();
                    last_name.setError("Field cannot be empty");
                }

                else if(email.length()==0){
                    register_email.requestFocus();
                    register_email.setError("Field cannot be empty");
                }

                else if(password.length()==0){
                    register_password.requestFocus();
                    register_password.setError("Field cannot be empty");
                }else{
                    HelperClass helperClass = new HelperClass(fname, lname, email, password);
                    reference.child(email).setValue(helperClass);
                    Toast.makeText(getActivity(), "Account created.", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment);
                }
            }
        });


        TextView newAccount;
        newAccount = view.findViewById(R.id.tvAlreadyAccount);
        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment);
            }
        });

        return view;
    }
}