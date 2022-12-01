package com.example.recyclerviewtest

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewtest.databinding.RecyclerViewBinding


class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = RecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.list

        val products = listOf(generateFakeProduct(), generateFakeProduct(), generateFakeProduct() )

        //scroller ver le haut
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        //scroller vers le bas
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductsAdapter(products)

    }
}

class ProductsAdapter(private val products : List<Product>) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun getItemCount(): Int = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.updateView(products[position])
    }

}


class ProductViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    private val productTitleTextView = v.findViewById<TextView>(R.id.product_title_bold)
    private val productMarqueTextView = v.findViewById<TextView>(R.id.product_text_italic)
    private val productNutriTextView = v.findViewById<TextView>(R.id.product_text_nutri)
    private val productTextCalTextView = v.findViewById<TextView>(R.id.product_text_cal)
    private val imageNavBookMarks = v.findViewById<ImageView>(R.id.image_bar_bookmarks)
   // private val pictureIv = v.findViewById<ImageView>(R.id.image)

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    fun updateView(product: Product) {
        productTitleTextView.applyBoldText(product.nom)
        productMarqueTextView.text = product.marque
        productNutriTextView.applyBoldTextEnd("Nutriscore : "+ product.nutriscore)
        productTextCalTextView.applyBoldTextFirstSpace(product.calories+" kCal/part")
        imageNavBookMarks
            .setColorFilter(Color.GREEN);

     //   Glide.with(itemView).load(product.url).into(pictureIv)


    }

}
fun TextView.applyBoldText(text: String) {
    val spannable = SpannableString(text)
    spannable.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(':') + 1, 0)
    setText(spannable)
}


fun TextView.applyBoldTextEnd(text: String){
    val spannable = SpannableString(text)
    spannable.setSpan(StyleSpan(Typeface.BOLD), text.indexOf(':') + 1, text.length, 0)
    setText(spannable)
}

fun TextView.applyBoldTextFirstSpace(text: String){
    val spannable = SpannableString(text)
    spannable.setSpan(StyleSpan(Typeface.BOLD), 0,text.indexOf(' ') + 1, 0)
    setText(spannable)
}