package com.fpg.fpg.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fpg.fpg.R;
import com.fpg.fpg.models.News;
import com.fpg.fpg.utils.Constants;
import com.fpg.fpg.utils.DateFormat;
import com.fpg.fpg.utils.Fonts;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by jhovany on 27/03/17.
 */

public class ListDetailNewsAdapter extends RecyclerView.Adapter<ListDetailNewsAdapter.ListDetailNewsViewHolder> {


    private List<News> newsList;
    private int viewPosition = 0;
    private Context context;

    public ListDetailNewsAdapter(List<News> newsList, Context context) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public ListDetailNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (newsList.get(viewPosition).getTypeCard().getNameCardType().equals("DETAIL_V1")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_details_v2, parent, false);
            viewPosition++;
        }
        return new ListDetailNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListDetailNewsViewHolder holder, int position) {
        holder.bindViewHolder(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ListDetailNewsViewHolder extends RecyclerView.ViewHolder {

        //<editor-fold des=" * * * * *  U I    R E F E R E N C E S   DETAIL_V2   * * * * * ">

        @BindView(R.id.iv_detail)
        ImageView ivDetail;
        @BindView(R.id.tv_colege)
        TextView tvColege;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_description_detail)
        TextView tvDescriptionDetail;
        @BindView(R.id.tv_date)
        TextView tvDate;
        //</editor-fold>

        public ListDetailNewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindViewHolder(News news) {

            setFont(tvTitle);
            setFont1(tvDescriptionDetail);
            setFont(tvColege);
            setFont(tvDate);

            tvDate.setText(DateFormat.Format(news.getDateNews()));

            tvTitle.setText(news.getTitle());

            if (news.getImage().equals("------") || news.getImage().equals("")) {

                RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                layout.height = (int) 200.0f;
                ivDetail.setLayoutParams(layout);
                Glide.with(context).load(R.drawable.ic_place_holder).into(ivDetail);
            } else {
                Glide.with(context)
                        .load(Constants.GoogleDrive.DRIVE_IMAGE_ROUTE + news.getImage())
                        .placeholder(R.drawable.ic_place_holder)
                        .crossFade()
                        .dontTransform()
                        .into(ivDetail);
            }
            tvDescriptionDetail.setText(news.getDescription());
        }

        private void setFont(TextView tv) {
            tv.setTypeface(Fonts.getFontRoboto(context, Constants.ConstanTypeFont.DOSIS_BOLD));
        }

        private void setFont1(TextView tv) {
            tv.setTypeface(Fonts.getFontRoboto(context, Constants.ConstanTypeFont.DOSIS_MEDIUM));
        }

    }
}



