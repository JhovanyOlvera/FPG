package com.fpg.fpg.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fpg.fpg.R;
import com.fpg.fpg.interfaces.GroupCallbacks;
import com.fpg.fpg.models.GroupNews;
import com.fpg.fpg.models.News;
import com.fpg.fpg.ui.details.DetailNews;
import com.fpg.fpg.utils.Constants;
import com.fpg.fpg.utils.Fonts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhovany on 27/03/17.
 */

public class ListHeaderNewsAdapter extends RecyclerView.Adapter<ListHeaderNewsAdapter.ListHeaderNewsViewHolder> {

    private List<GroupNews> groupNewsList;
    private GroupCallbacks mGroupCallbacks;
    private int viewPosition = 0;
    private Context context;

    public ListHeaderNewsAdapter(List<GroupNews> groupNewsList, Context context, GroupCallbacks mGroupCallbacks) {
        this.mGroupCallbacks = mGroupCallbacks;
        this.context = context;
        this.groupNewsList = groupNewsList;
    }

    @Override
    public ListHeaderNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (groupNewsList.get(viewPosition).getTypeCard().getNameCardType().equals("CARD")) {
            //view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_calendar, parent, false);
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_v1, parent, false);
            viewPosition++;
        } else if (groupNewsList.get(viewPosition).getTypeCard().getNameCardType().equals("BANNER")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_headline, parent, false);
            viewPosition++;
        } else if (groupNewsList.get(viewPosition).getTypeCard().getNameCardType().equals("CARD_V2")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_calendar_v_2, parent, false);
            viewPosition++;
        } else if (groupNewsList.get(viewPosition).getTypeCard().getNameCardType().equals("ICON_V1")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_icon_v_1, parent, false);
            viewPosition++;
        }
        return new ListHeaderNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHeaderNewsViewHolder holder, int position) {
        holder.bindViewHolder(groupNewsList.get(position));
    }

    @Override
    public int getItemCount() {
        return groupNewsList.size();
    }

    protected class ListHeaderNewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private GroupNews groupNews;
        private CardView cv_container;
        /*CARD*/
        private TextView tv_day;
        private TextView tv_month;
        private TextView tv_activity;
        private TextView tv_news_1;
        private TextView tv_news_2;
        private TextView tv_news_3;
        private TextView tv_news_4;
        /*BANNER*/
        private ImageView iv_banner;

        /*CARD V2*/
        private TextView tv_day_v2;
        private TextView tv_month_v2;
        private TextView tv_weekday;
        private TextView tv_news_1_v2;
        private TextView tv_news_2_v2;
        private TextView tv_news_3_v2;
        private TextView tv_news_4_v2;

        public ListHeaderNewsViewHolder(View itemView) {
            super(itemView);

            cv_container = (CardView) itemView.findViewById(R.id.cv_container);

            tv_day = (TextView) itemView.findViewById(R.id.tv_day);
            tv_month = (TextView) itemView.findViewById(R.id.tv_month);
            tv_activity = (TextView) itemView.findViewById(R.id.tv_activity);

            tv_news_1 = (TextView) itemView.findViewById(R.id.tv_news_1);
            tv_news_2 = (TextView) itemView.findViewById(R.id.tv_news_2);
            tv_news_3 = (TextView) itemView.findViewById(R.id.tv_news_3);
            iv_banner = (ImageView) itemView.findViewById(R.id.iv_banner);

            tv_day_v2 = (TextView) itemView.findViewById(R.id.tv_day_v2);
            tv_month_v2 = (TextView) itemView.findViewById(R.id.tv_month_v2);
            tv_weekday = (TextView) itemView.findViewById(R.id.tv_weekday);
            tv_news_1_v2 = (TextView) itemView.findViewById(R.id.tv_news_1_v2);
            tv_news_2_v2 = (TextView) itemView.findViewById(R.id.tv_news_2_v2);
            tv_news_3_v2 = (TextView) itemView.findViewById(R.id.tv_news_3_v2);
            tv_news_4_v2 = (TextView) itemView.findViewById(R.id.tv_news_4_v2);
        }

        private void bindViewHolder(GroupNews groupNews) {
            this.groupNews = groupNews;
            cv_container.setOnClickListener(this);
            if (groupNews.getTypeCard().getNameCardType().equals("CARD")) {

                int valor = groupNews.getNews().size();
                if (valor > 1) {
                    tv_activity.setText(valor + " Actividades");
                } else {
                    tv_activity.setText(valor + " Actividad");
                }

                if (!TextUtils.isEmpty(groupNews.getDateNews().getStartDay().toString()) && !TextUtils.isEmpty(groupNews.getDateNews().getFinishDay().toString())) {
                    tv_day.setText(groupNews.getDateNews().getStartDay() + " - " + groupNews.getDateNews().getFinishDay());
                    tv_day.setTextSize(20);
                } else if (TextUtils.isEmpty(groupNews.getDateNews().getStartDay().toString()) && TextUtils.isEmpty(groupNews.getDateNews().getFinishDay().toString())) {
                    tv_day.setText("--");
                } else if (!TextUtils.isEmpty(groupNews.getDateNews().getStartDay().toString()) && TextUtils.isEmpty(groupNews.getDateNews().getFinishDay().toString())) {
                    tv_day.setText(groupNews.getDateNews().getStartDay());
                }

                tv_month.setText(groupNews.getDateNews().getMonth());
                //tv_year.setText(groupNews.getDateNews().getYear());

                List<TextView> textViews = new ArrayList<>();

                textViews.add(tv_news_1);
                tv_news_1.setTypeface(Fonts.getFontRoboto(context, Constants.ConstanTypeFont.ROBOTO_LIGHT));
                textViews.add(tv_news_2);
                tv_news_2.setTypeface(Fonts.getFontRoboto(context, Constants.ConstanTypeFont.ROBOTO_LIGHT));
                textViews.add(tv_news_3);
                tv_news_3.setTypeface(Fonts.getFontRoboto(context, Constants.ConstanTypeFont.ROBOTO_LIGHT));

                setNews(textViews, groupNews.getNews());

            } else if (groupNews.getTypeCard().getNameCardType().equals("BANNER")) {
                Glide.with(context).load(Constants.GoogleDrive.DRIVE_IMAGE_ROUTE + groupNews.getNews().get(0).getImage()).into(iv_banner);
            } else if (groupNews.getTypeCard().getNameCardType().equals("CARD_V2")) {
                tv_day_v2.setText(groupNews.getDateNews().getStartDay());
                tv_month_v2.setText(groupNews.getDateNews().getMonth());
                //tv_weekday.setText(groupNews.getDateNews().getYear());

                List<TextView> textViews = new ArrayList<>();

                textViews.add(tv_news_1_v2);
                textViews.add(tv_news_2_v2);
                textViews.add(tv_news_3_v2);
                textViews.add(tv_news_4_v2);

                setNews(textViews, groupNews.getNews());
            }
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.cv_container:
                    mGroupCallbacks.invokeActivity(DetailNews.class, groupNews.getRemoteId());
                    break;
            }
        }
    }

    private void setNews(List<TextView> tv, List<News> news) {

       /* if (news.size() == 1) {
            tv.get(0).setTextSize(18);
        } else if (news.size() == 2) {
            tv.get(0).setTextSize(18);
            tv.get(1).setTextSize(18);
        } else if (news.size() == 3) {
            tv.get(0).setTextSize(16);
            tv.get(1).setTextSize(16);
            tv.get(2).setTextSize(16);
        } else if (news.size() == 4) {
            tv.get(0).setTextSize(14);
            tv.get(1).setTextSize(14);
            tv.get(2).setTextSize(14);
            tv.get(3).setTextSize(14);
        }*/

        for (int index = 0; index < 3; index++) {
            if (index < news.size()) {
                if (news != null) {
                    tv.get(index).setText("\u0387 " + news.get(index).getShortTitle());
                    tv.get(index).setVisibility(View.VISIBLE);
                } else {
                    tv.get(index).setVisibility(View.GONE);
                }
            }
        }

    }
}