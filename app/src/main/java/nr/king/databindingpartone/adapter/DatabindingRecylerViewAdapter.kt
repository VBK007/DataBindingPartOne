package nr.king.databindingpartone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import nr.king.databindingpartone.R
import nr.king.databindingpartone.databinding.RecylerviewAdapterBindingBinding
import nr.king.databindingpartone.model.DatabindingRecylerModel

class DatabindingRecylerViewAdapter(var arrayList: ArrayList<DatabindingRecylerModel>) :
    RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return MyViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recylerview_adapter_binding,parent,false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(position, this)
    }

    override fun getItemCount() = arrayList.size


    inner class MyViewHolder(var binding: RecylerviewAdapterBindingBinding) :
        BaseViewHolder(binding) {
        override fun bind(position: Int, databindingRecylerView: DatabindingRecylerViewAdapter) {
            binding.apply {
                var lData = arrayList[position]
                Glide.with(imgThump.context).apply {
                    load(lData.imageUrl)
                        .into(postImage)
                }
                Glide.with(imgThump.context).apply {
                    load(lData.imageUrl)
                        .into(userImage)
                }
                txtUserName.text = lData.userName
                txtNoOfLikes.text = lData.likeCount.plus(" ${imgThump.context.getString(R.string.no_of_likes)}")
                when(lData.isLiked)
                {
                    true->{imgThump.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24)}
                    else->{imgThump.setImageResource(R.drawable.unlike_thump)}
                }
            }
        }
    }
}


abstract class BaseViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(position: Int, databindingRecylerView: DatabindingRecylerViewAdapter)
}