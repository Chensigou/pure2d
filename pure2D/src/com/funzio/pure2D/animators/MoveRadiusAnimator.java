/**
 * 
 */
package com.funzio.pure2D.animators;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/**
 * @author long
 */
@Deprecated
public class MoveRadiusAnimator extends TweenAnimator {
    protected float mSrcX = 0;
    protected float mSrcY = 0;
    protected PointF mDelta = new PointF();

    public MoveRadiusAnimator(final Interpolator interpolator) {
        super(interpolator);
    }

    public void setValues(final float srcX, final float srcY, final float distance, final float radianAngle) {
        mSrcX = srcX;
        mSrcY = srcY;

        mDelta.x = distance * (float) Math.cos(radianAngle) - srcX;
        mDelta.y = distance * (float) Math.sin(radianAngle) - srcY;
    }

    public void setValues(final float srcX, final float srcY, final float distance, final int degreeAngle) {
        mSrcX = srcX;
        mSrcY = srcY;

        mDelta.x = distance * (float) Math.cos(degreeAngle * Math.PI / 180f) - srcX;
        mDelta.y = distance * (float) Math.sin(degreeAngle * Math.PI / 180f) - srcY;
    }

    public void setValues(final float distance, final float radianAngle) {
        mDelta.x = distance * (float) Math.cos(radianAngle);
        mDelta.y = distance * (float) Math.sin(radianAngle);
    }

    public void setValues(final float distance, final int degreeAngle) {
        mDelta.x = distance * (float) Math.cos(degreeAngle * Math.PI / 180f);
        mDelta.y = distance * (float) Math.sin(degreeAngle * Math.PI / 180f);
    }

    public void start(final float srcX, final float srcY, final float distance, final float radianAngle) {
        setValues(srcX, srcY, distance, radianAngle);

        start();
    }

    public void start(final float srcX, final float srcY, final float distance, final int degreeAngle) {
        setValues(srcX, srcY, distance, degreeAngle);

        start();
    }

    public void start(final float distance, final float radianAngle) {
        if (mTarget != null) {
            final PointF position = mTarget.getPosition();
            start(position.x, position.y, distance, radianAngle);
        }
    }

    public void start(final float distance, final int degreeAngle) {
        if (mTarget != null) {
            final PointF position = mTarget.getPosition();
            start(position.x, position.y, distance, degreeAngle);
        }
    }

    @Override
    protected void onUpdate(final float value) {
        if (mTarget != null) {
            if (mAccumulating) {
                mTarget.moveBy((value - mLastValue) * mDelta.x, (value - mLastValue) * mDelta.y);
            } else {
                mTarget.setPosition(mSrcX + value * mDelta.x, mSrcY + value * mDelta.y);
            }
        }

        super.onUpdate(value);
    }

    public PointF getDelta() {
        return mDelta;
    }
}
