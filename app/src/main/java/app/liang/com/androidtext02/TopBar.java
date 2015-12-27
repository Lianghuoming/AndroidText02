package app.liang.com.androidtext02;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by meimei on 15/12/27.
 */
public class TopBar extends RelativeLayout{

    private Button leftButton,  rightButton;
    private TextView titleTv;

    private LayoutParams leftParams,rightParams,titleParams;

    private int leftTextColor;
    private Drawable leftBackground = null;
    private String leftText;

    private int rightTextColor;
    private Drawable rightBackground = null;
    private String rightText;

    private float   titleTextSize;
    private int     titleTextColor;
    private String  titleText;

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        System.out.print("TopBar(Context context, AttributeSet attrs, int defStyleAttr)");
    }



    public TopBar(Context context) {
        super(context);
        System.out.print("TopBar(Context context)");
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        System.out.print("TopBar(Context context, AttributeSet attrs)");
        TypedArray ta = context.obtainStyledAttributes(attrs, app.liang.com.androidtext02.R.styleable.TopBar);

        try {
            leftTextColor  = ta.getColor(app.liang.com.androidtext02.R.styleable.TopBar_leftTextColor,0);
            leftBackground = ta.getDrawable(app.liang.com.androidtext02.R.styleable.TopBar_leftBackground);
            leftText       = ta.getString(app.liang.com.androidtext02.R.styleable.TopBar_leftText);

            rightTextColor  = ta.getColor(app.liang.com.androidtext02.R.styleable.TopBar_rightTextColor,0);
            rightBackground = ta.getDrawable(app.liang.com.androidtext02.R.styleable.TopBar_rightBackground);
            rightText       = ta.getString(app.liang.com.androidtext02.R.styleable.TopBar_rightText);

            titleTextSize  = ta.getDimension(app.liang.com.androidtext02.R.styleable.TopBar_topTitleTextSize,0);
            titleTextColor = ta.getColor(app.liang.com.androidtext02.R.styleable.TopBar_topTitleTextColor,0);
            titleText      = ta.getString(app.liang.com.androidtext02.R.styleable.TopBar_topTitle);
        }finally {
            ta.recycle();
        }

        initTopView(context);
    }


    private void initTopView(Context context){

        leftButton = new Button(context);
        rightButton = new Button(context);
        titleTv = new TextView(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);

        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);

        titleTv.setTextColor(titleTextColor);
        titleTv.setText(titleText);
        titleTv.setTextSize(titleTextSize);

        setBackgroundColor(0xFFF59563);

        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);

        leftParams.addRule(ALIGN_PARENT_LEFT,TRUE);
        rightParams.addRule(ALIGN_PARENT_RIGHT,TRUE);
        titleParams.addRule(CENTER_IN_PARENT,TRUE);

        addView(leftButton,leftParams);
        addView(rightButton,rightParams);
        addView(titleTv,titleParams);
    }
}
