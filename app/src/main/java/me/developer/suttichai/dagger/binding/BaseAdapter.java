package me.developer.suttichai.dagger.binding;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, getLayout(), parent, false);
        binding = updateOtherVariable(binding);
        return new BaseViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        Object object = getItem(position);
        holder.bind(object);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutType(position);
    }

    protected abstract @LayoutRes
    int getLayout();

    protected abstract Object getItem(int position);

    protected abstract int getLayoutType(int position);

    protected abstract ViewDataBinding updateOtherVariable(ViewDataBinding binding);
}