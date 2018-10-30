package me.developer.suttichai.dagger.binding;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import me.developer.suttichai.dagger.BR;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;

    public BaseViewHolder(@NonNull ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object object) {
        binding.setVariable(BR.menuGroup, object);
        binding.executePendingBindings();
    }
}