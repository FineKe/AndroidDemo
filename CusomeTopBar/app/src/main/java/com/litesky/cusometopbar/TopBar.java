package com.litesky.cusometopbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by finefine.com on 2017/9/21.
 */

public class TopBar extends RelativeLayout {

    private Button leftButton,rightButton;
    private TextView textView;

    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    private String title;
    private float titleTextSize;
    private int titleTextColor;

    private LayoutParams leftParams,rightParams,titleParams;

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.TopBar);

        title=typedArray.getString(R.styleable.TopBar_title);
        titleTextSize=typedArray.getDimension(R.styleable.TopBar_titleTextSize,14);
        titleTextColor=typedArray.getColor(R.styleable.TopBar_titleTextColor,0);

        leftText=typedArray.getString(R.styleable.TopBar_leftText);
        leftBackground=typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        leftTextColor=typedArray.getColor(R.styleable.TopBar_leftTextColor,0);

        rightText=typedArray.getString(R.styleable.TopBar_rightText);
        rightBackground=typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        rightTextColor=typedArray.getColor(R.styleable.TopBar_rightTextColor,0);

        typedArray.recycle();
        
        textView=new TextView(context);
        leftButton=new Button(context);
        rightButton=new Button(context);

        setBackgroundColor(0xfff59563);



        textView.setText(title);
        leftButton.setText(leftText);
        rightButton.setText(rightText);
        titleParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT);


        rightParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        leftParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        addView(textView,titleParams);
        addView(rightButton,rightParams);
        addView(leftButton,leftParams);
    }
}
