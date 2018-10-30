package me.developer.suttichai.dagger.main.adapter;

import java.util.List;

import androidx.databinding.ViewDataBinding;
import me.developer.suttichai.dagger.BR;
import me.developer.suttichai.dagger.R;
import me.developer.suttichai.dagger.api.menu.response.MenuGroup;
import me.developer.suttichai.dagger.binding.BaseAdapter;

public class MenuGroupAdapter extends BaseAdapter {
    private List<MenuGroup> groups;
    private Listener listener;

    public MenuGroupAdapter(List<MenuGroup> groups, Listener listener) {
        this.groups = groups;
        this.listener = listener;
    }

    @Override
    protected int getLayout() {
        return R.layout.menu_group_item;
    }

    @Override
    protected Object getItem(int position) {
        if (getLayoutType(position) == BR.menuGroup)
            return groups.get(position);

        return null;
    }

    @Override
    protected int getLayoutType(int position) {
        if (groups != null && position >= 0 && position < groups.size())
            return BR.menuGroup;
        return -1;
    }

    @Override
    protected ViewDataBinding updateOtherVariable(ViewDataBinding binding) {
        binding.setVariable(BR.menuGroupListener, listener);
        return binding;
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    public interface Listener {
        void onMenuGroupClick();
    }
}