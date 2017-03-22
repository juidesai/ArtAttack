package juidesai.edu.csulb.com.artattack;

/**
 * Created by jmd19 on 3/21/2017.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class view_custom extends View {
    private Paint paint = new Paint();
    private Path path = new Path();
    Context context;

    public view_custom(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        paint.setAntiAlias(true);
        paint.setStrokeWidth(8f);
        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:

                path.lineTo(eventX, eventY);
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }
}


