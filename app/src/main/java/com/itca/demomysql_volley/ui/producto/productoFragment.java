package com.itca.demomysql_volley.ui.producto;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.itca.demomysql_volley.Dto_categorias;
import com.itca.demomysql_volley.R;

import java.util.ArrayList;


public class productoFragment extends Fragment {

    private TextInputLayout ti_id, ti_nombre_prod, ti_descripcion, ti_stock,
            ti_precio, ti_unidadmedida;

    private EditText et_id, et_nombre_prod, et_descripcion, et_stock, et_precio, et_unidadmedida;
    private Spinner sp_estadoProductos, sp_fk_categoria;
    private TextView tv_fechahora;
    private Button btnSave, btnNew;

    ProgressDialog progressDialog;
    ArrayList<String> lista = null;
    ArrayList<Dto_categorias> listaCategorias;

    //Va a representar la información que se va a mostrar en el combo

    // Arreglos para efectuar pruebas de carga de opciones en spinner.
    String elementos[] = {"Uno", "Dos", "Tres", "Cuatro", "Cinco"};

    final String[] elementos1 =new String[]{
            "Seleccione",
            "1",
            "2",
            "3",
            "4",
            "5"
    };

    String idcategoria = "";
    String nombrecategoria = "";
    int conta = 0;

    String datoStatusProduct = "";

    //Instancia DTO
    dto_productos dto = new dto_productos();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_producto, container, false);
    }
}