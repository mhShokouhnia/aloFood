package com.example.alofood

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.view.animation.Transformation
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.alofood.databinding.LayoutTestBinding
import com.google.android.material.shape.RoundedCornerTreatment
import org.w3c.dom.Text

class FoodAdapter(private val data: ArrayList<Food>, private val foodEvent: FoodEvents) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(private val binding: LayoutTestBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun BindData(position: Int) {

            binding.itemMainSub.text = data[position].txtSub
            binding.itemMainCity.text = data[position].txtCity
            binding.itemMainPrice.text = "$" + data[position].txtPrice + " vip"
            binding.itemMainDistance.text = data[position].txtDistance + " miles from you"
            binding.itemMainRatting.rating = data[position].rating
            binding.itemMainRateNum.text =
                "(" + data[position].numOfRating.toString() + " Ratings ) "

            Glide.with(binding.root.context)
                .load(data[position].urlImg)
//                .transform(RoundedCornersTransformation(16 , 4))
                .into(binding.itemImgMain)

            itemView.setOnClickListener {
                foodEvent.FoodClicked(data[adapterPosition], adapterPosition)
            }
            itemView.setOnLongClickListener {
                foodEvent.FoodLongClicked(data[adapterPosition], adapterPosition)
                true
            }


        }

        private fun RoundedCornersTransformation(
            radius: Int,
            margin: Int
        ): com.bumptech.glide.load.Transformation<Bitmap> {
            TODO("Not yet implemented")
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = LayoutTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.BindData(position)
    }

    fun setData(newList: ArrayList<Food>) {

        data.clear()
        data.addAll(newList)
        notifyDataSetChanged()

    }

    fun addFood(newFood: Food) {
        data.add(0, newFood)
        notifyItemInserted(0)
    }

    fun removeFood(oldFood: Food, oldPosition: Int) {
        data.remove(oldFood)
        notifyItemRemoved(oldPosition)
    }

    fun updateFood(newFood: Food, position: Int) {
        data.set(position, newFood)
        notifyItemChanged(position)
    }

    interface FoodEvents {
        fun FoodClicked(food: Food, position: Int)
        fun FoodLongClicked(oldFood: Food, oldPosition: Int)

    }
}