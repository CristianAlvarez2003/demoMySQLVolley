package com.itca.demomysql_volley.ui.categoria;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.itca.demomysql_volley.R;

public class categoriaFragment extends Fragment {

    private TextInputLayout ti_idcategoria, ti_namecategoria;
    private EditText et_idcategoria, et_namecategoria;
    private Spinner sp_estado;
    private Button btnSave, btnNew;

    String datoSelect = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_categoria, container, false);
        ti_idcategoria = root.findViewById(R.id.ti_idcategoria);
        ti_namecategoria = root.findViewById(R.id.ti_namecategoria);
        et_idcategoria = root.findViewById(R.id.et_idcategoria);
        et_namecategoria = root.findViewById(R.id.et_namecategoria);
        sp_estado = root.findViewById(R.id.sp_estado);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.estadoCategorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_estado.setAdapter(adapter);
        sp_estado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(sp_estado.getSelectedItemPosition()>0) {
                    datoSelect = sp_estado.getSelectedItem().toString();
                }else{
                    datoSelect = "";               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnSave = root.findViewById(R.id.btnSave);
        btnNew = root.findViewById(R.id.btnNew);
        btnSave.setOnClickListener(this);
        btnNew.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){

            case R.id.btnSave:
                //save_server(getContext(),);
                String id = et_idcategoria.getText().toString();
                String nombre = et_namecategoria.getText().toString();
                if (id.length() == 0){
                    et_idcategoria.setError("Campo obligatorio");
                }else if(nombre.length() == 0){
                    et_namecategoria.setError("Campo obligatorio");
                    //}else if(!datoSelect.isEmpty()){
                    }else if(sp_estado.getSelectedItemPosition() > 0){
                    //Acciones para guardar registro en la base de datos.
                    Toast.makeText(getContext(), "Bien...", Toast.LENGTH_SHORT).show();
                    save_server(getContext(), Integer.parseInt(id), nombre, Integer.parseInt(datoSelect));

                }else{
                    Toast.makeText(getContext(), "Debe seleccionar un estado para la categoria",
                            Toast.LENGTH_SHORT).show();
                }break;

                case R.id.btnNew:
                    new_categories();
                    break;
                    default:

                }

            }
        }
}

    private void save_server(Context context, int parseInt, String nombre, int parseInt1) {
    }
}