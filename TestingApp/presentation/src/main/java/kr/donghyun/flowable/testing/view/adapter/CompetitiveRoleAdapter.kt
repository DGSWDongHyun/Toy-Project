package kr.donghyun.flowable.testing.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.donghyun.flowable.domain.data.CompetitiveRatingModel
import kr.donghyun.flowable.testing.databinding.ItemRoleBinding
import kr.donghyun.flowable.testing.view.extensions.setGlideImage

class CompetitiveRoleAdapter(private val listRole: MutableList<CompetitiveRatingModel> = mutableListOf()) : RecyclerView.Adapter<CompetitiveViewHolder>() {
    fun updateRoleData(updateList : List<CompetitiveRatingModel>) {
        val currentSize = listRole.size
        listRole.apply {
            clear()
            notifyItemRangeRemoved(0, currentSize)
            addAll(updateList)
            notifyItemRangeInserted(0, updateList.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitiveViewHolder
        = CompetitiveViewHolder(ItemRoleBinding.inflate(LayoutInflater.from(parent.context),null, false))

    override fun onBindViewHolder(holder: CompetitiveViewHolder, position: Int) {
        holder.bind(listRole[position])
    }

    override fun getItemCount(): Int = listRole.size
}

class CompetitiveViewHolder(private val binding : ItemRoleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data : CompetitiveRatingModel) {
        binding.apply {
            roleName.text = bindRole(data.competitivePosition)
            tierScore.text = "${data.ratingLevels}점"
            tierImage.setGlideImage(itemView.context, data.competitiveRankIcon)
        }
    }

    fun bindRole(role : String) : String = when(role) {
        "tank" -> "탱커"
        "damage" -> "딜러"
        "support" -> "힐러"
        else -> "자유"
    }
}