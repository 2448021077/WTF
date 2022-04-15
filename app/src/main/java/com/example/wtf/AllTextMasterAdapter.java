package com.example.wtf;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;
//基于BaseQuickAdapter
public class AllTextMasterAdapter extends BaseQuickAdapter<AllTextMaster,BaseViewHolder> {
    //接口回调步骤2：定义成员变量

    private List<AllText> allTextList=new ArrayList<>();//用来传入数据
    public AllTextAdapter allTextAdapter;
    public Boolean flag=false;
    public AllTextMasterAdapter(Context context, @Nullable List<AllTextMaster> data) {
        super(R.layout.biankuang_test, data);//传入边框布局，数据
        this.mContext=context;//传入上下文
    }
    @Override
    protected void convert(BaseViewHolder helper, AllTextMaster item) {
        allTextList.clear();//除去旧数据
        helper.setText(R.id.tv_group_title,""+item.getItem_Type());//设置标题
        allTextList.addAll(item.getAllTextList());//添加新数据
        allTextAdapter=new AllTextAdapter(allTextList,flag);//创建小适配器，并传入数据
        allTextAdapter.setOnItemListenerListener(new AllTextAdapter.OnItemListener() {
            @Override
            public void OnItemClickListener(View view, int position) {
                Toast.makeText(mContext,
                        "项目"+position+"被点击！",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnItemLongClickListener(View view, int position) {
                Toast.makeText(mContext,
                        "项目"+position+"被长按！",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ((RecyclerView)helper.getView(R.id.recyclerview)).setLayoutManager(new LinearLayoutManager(mContext,RecyclerView.VERTICAL,false));//传入布局
        ((RecyclerView) helper.getView(R.id.recyclerview)).setAdapter(allTextAdapter);//设置适配器
        allTextAdapter.notifyDataSetChanged();//提醒数据发生改变
    }
    public void setCheckbox(Boolean flag){
        this.flag=flag;
        notifyDataSetChanged();
    }

}
