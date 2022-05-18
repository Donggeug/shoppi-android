package com.shoppi.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text


class HomeBannerAdapter : ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(BannerDiffCallback()){

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):HomeBannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_banner, parent, false)
        return HomeBannerViewHolder(view)
    }
    override fun onBindViewHolder(holder: HomeBannerViewHolder, position:Int){
        holder.bind(getItem(position))
    }

    class HomeBannerViewHolder(view:View) : RecyclerView.ViewHolder(view){

        private val bannerImageView = view.findViewById<ImageView>(R.id.iv_banner_image)
        private val bannerBadgeTextView = view.findViewById<TextView>(R.id.tv_banner_badge)
        private val bannerTitle = view.findViewById<TextView>(R.id.bg_banner_title)
        private val bannerDetailThumbnail = view.findViewById<ImageView>(R.id.iv_banner_detail_thumbnail)
        private val bannerDetailBrandLabel = view.findViewById<TextView>(R.id.tv_banner_detail_brand_label)
        private val bannerDetailProductLabel = view.findViewById<TextView>(R.id.tv_banner_detail_product_label)
        private val bannerDetailProductDiscountRate = view.findViewById<TextView>(R.id.tv_banner_detail_product_discount_rate)
        private val bannerDetailProductDiscountPrice = view.findViewById<TextView>(R.id.tv_banner_detail_product_discount_price)
        private val bannerDetailProductPrice = view.findViewById<TextView>(R.id.tv_banner_detail_product_price)

        fun bind(banner:Banner){
            GlideApp.with(itemView)
                .load(banner.backgroundImageUrl)
                .into(bannerImageView)
        }
    }
}

class BannerDiffCallback : DiffUtil.ItemCallback<Banner>(){
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }

}