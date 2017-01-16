package ru.hoticecream.animations.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.hoticecream.animations.R;

/**
 * Created by v.kholyavin (16/01/2017)
 */

public class FirstFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        getViewParent().setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CatsAdapter());
        return view;
    }

    void onCatClick(View image, CatItem item) {
        ViewCompat.setTransitionName(image, item.name);
        getViewParent().onCatClicked(image);
    }

    public class CatsAdapter extends RecyclerView.Adapter<CatsHolder> {

        private final List<CatItem> items = Arrays.asList(
                new CatItem("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Valentino.jpg/200px-Valentino.jpg", "Абиссинская"),
                new CatItem("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Australian_Mist.jpg/200px-Australian_Mist.jpg", "Австралийский мит"),
                new CatItem("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/BrownVarientAsianCat.JPG/200px-BrownVarientAsianCat.JPG", "Азиатская"),
                new CatItem("https://upload.wikimedia.org/wikipedia/ru/thumb/b/ba/Акринский-кот.jpg/200px-Акринский-кот.jpg", "Акринская"),
                new CatItem("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/American_bobtail.jpg/200px-American_bobtail.jpg", "Американский бобтейл длинношерстный"),
                new CatItem("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/American_Wirehair_-_CFF_cat_show_Heinola_2008-05-04_IMG_8721.JPG/200px-American_Wirehair_-_CFF_cat_show_Heinola_2008-05-04_IMG_8721.JPG", "Американская жесткошёрстная")
        );

        @Override
        public CatsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CatsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cat, parent, false)) {
                @Override
                public void onItemClicked(CatItem currentItem) {
                    onCatClick(imageCat, currentItem);
                }
            };
        }

        @Override
        public void onBindViewHolder(CatsHolder holder, int position) {
            holder.bind(items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    public abstract static class CatsHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.image_cat)
        ImageView imageCat;
        private CatItem currentItem;

        public CatsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClicked(currentItem);
                }
            });
        }

        public abstract void onItemClicked(CatItem currentItem);

        public void bind(CatItem catItem) {
            this.currentItem = catItem;
            Picasso.with(imageCat.getContext()).load(catItem.url).into(imageCat);
            textName.setText(catItem.name);
        }
    }

    public static class CatItem {
        String url;
        String name;

        public CatItem(String url, String name) {
            this.url = url;
            this.name = name;
        }
    }

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }
}
