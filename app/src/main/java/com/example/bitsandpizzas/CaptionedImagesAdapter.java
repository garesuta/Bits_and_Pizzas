package com.example.bitsandpizzas;

import androidx.recyclerview.widget.RecyclerView;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;

class CaptionedImagesAdapter extends RecyclerView.CaptionedImagesAdapter<CaptionedImagesAdapter.ViewHolder>{
    private String[] captions;
    private int[] imageIds;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public  ViewHolder(CardView v){
            super(v);
            cardView = v;
        }
        }
        public CaptionedImagesAdapter(String[] captions, int[] imageIds){
            this.captions = captions;
            this.imageIds = imageIds;
        }
        @Override
        public int getItemCount(){
        return captions.length;
        }
        @Override
        public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView)LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image,parent,false);
        return new ViewHolder(cv);
        }
        @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);
        TextView textView =(TextView)cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);
        }

    }
