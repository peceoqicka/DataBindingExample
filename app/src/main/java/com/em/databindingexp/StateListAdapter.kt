package com.em.databindingexp

import android.view.View
import com.em.databindingexp.databinding.ItemStateBinding

/**
 * <pre>
 *      author  :   peceoqicka
 *      e-mail  :   ratchet@qq.com
 *      time    :   2017/09/22
 *      desc    :   开关状态列表数据适配器(使用DataBinding)
 *      version :   1.0
 * </pre>
 */
class StateListAdapter(settings: List<Setting>) : BaseBindingAdapter<Setting, ItemStateBinding>(settings) {
    override fun onItemClick(itemView: View?, data: Setting?) {
    }

    override fun getLayoutId(viewType: Int): Int = R.layout.item_state

    override fun onSetData(binding: ItemStateBinding, data: Setting) {
        binding.setting = data
    }
}