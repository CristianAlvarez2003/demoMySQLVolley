package com.itca.demomysql_volley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<dto_catprod> productList;

    //Uno
    private OnItemClickListener mListener;

    //Dos
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    //Tres
    public void setOnItemClickListener(Context mCtx, OnItemClickListener listener) {
        this.mCtx = mCtx;
        mListener = listener;
    }


    public ProductAdapter(Context mCtx, List<dto_catprod> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_consulta1, parent, false);
        ProductViewHolder evh = new ProductViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {

        dto_catprod datos = productList.get(position);

        holder.textViewNombre1.setText(datos.getId_producto() + ":" + datos.getNombre_producto());
        holder.textViewDescripcion1.setText(datos.getDes_producto());
        holder.textViewPrecio1.setText(String.valueOf(datos.getPrecio()));
        holder.textViewStock1.setText(String.valueOf(datos.getStock()));
        holder.textViewCategoria1.setText(String.valueOf(datos.getCategoria()) + ":" + datos.getNombre_categoria());
        holder.textViewFecha.setText(datos.getFecha());
        holder.textViewTitleProducto.setText(datos.getNombre_producto());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    public class PrductViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre1, textView
    }
}
