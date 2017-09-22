package com.em.databindingexp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.find

class IndexActivity : AppCompatActivity() {
    private val list = arrayListOf<Setting>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        val rv = find<RecyclerView>(R.id.rv_index_setting)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv.addItemDecoration(LineItemDecorator(this, R.drawable.line_item_decorator, 30, LineItemDecorator.HORIZONTAL))

        list.add(Setting(getString(R.string.silence_mode), true))
        list.add(Setting(getString(R.string.vibrate_in_silence_mode), false))

        rv.adapter = SettingListAdapter(list)

        val rvState = find<RecyclerView>(R.id.rv_index_state)
        rvState.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvState.adapter = StateListAdapter(list)
    }
}
