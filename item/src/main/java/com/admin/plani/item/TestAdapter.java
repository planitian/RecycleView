package com.admin.plani.item;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

/**
 * 创建时间 2018/9/26
 *
 * @author plani
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    private OnClick click;
    //传入的数据
    private List<TestBean> beans;

    public TestAdapter(OnClick click, List<TestBean> beans) {
        this.click = click;
        this.beans = beans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new ViewHolder(root);
    }


    //这个方法 是全部刷新item 布局
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TestBean bean = beans.get(position);
        System.out.println("全部更新绑定"+bean);
        holder.one.setText(bean.getImage()+"");
        holder.two.setText(bean.getSize()+"");
        holder.three.setText(bean.getAge()+"");
    }

    /**
     * @param holder
     * @param position
     * @param payloads   用于标识 刷新布局里面的那个具体控件
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        System.out.println(">>>>payloads"+payloads);
        if (payloads.isEmpty()){
            super.onBindViewHolder(holder, position, payloads);
            return;
        }
        TestBean bean = beans.get(position);
        //循环得到payloads里面的参数
        for (Object payload:payloads) {
            switch (String.valueOf(payload)){
                case "one":
                    holder.one.setText(bean.getImage()+"");
                    break;
                case "two":
                    holder.two.setText(bean.getSize()+"");
                    break;
                case "three":
                    holder.three.setText(bean.getAge()+"");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button one;
        private Button two;
        private Button three;

        public ViewHolder(View itemView) {
            super(itemView);
            one = itemView.findViewById(R.id.one);
            two = itemView.findViewById(R.id.two);
            three = itemView.findViewById(R.id.three);
            two.setOnClickListener(v -> {
                   click.click(v,getAdapterPosition());
            });
        }
    }
    //用于给按钮添加点击事件
    public interface OnClick{
        void click(View view, int position);
    }
}
