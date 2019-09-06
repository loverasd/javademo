package com.note.myConcurrent;

import java.util.concurrent.RecursiveAction;

/**
 * @Classname MyForkJoin
 * @Date 2019-08-15 14:59
 * @Created by chenpan
 * @Description
 */
public class MyForkJoin extends RecursiveAction {
    private int[] mSource;
    private int mStart;
    private int mLength;
    private int[] mDestination;

    // Processing window size; should be odd.
    private int mBlurWidth = 15;

    public MyForkJoin(int[] src, int start, int length, int[] dst) {
        mSource = src;
        mStart = start;
        mLength = length;
        mDestination = dst;
    }

    protected void computeDirectly() {
        int sidePixels = (mBlurWidth - 1) / 2;
        for (int index = mStart; index < mStart + mLength; index++) {
            // Calculate average.
            float rt = 0, gt = 0, bt = 0;
            for (int mi = -sidePixels; mi <= sidePixels; mi++) {
                int mindex = Math.min(Math.max(mi + index, 0),
                        mSource.length - 1);
                int pixel = mSource[mindex];
                rt += (float)((pixel & 0x00ff0000) >> 16)
                        / mBlurWidth;
                gt += (float)((pixel & 0x0000ff00) >>  8)
                        / mBlurWidth;
                bt += (float)((pixel & 0x000000ff) >>  0)
                        / mBlurWidth;
            }

            // Reassemble destination pixel.
            int dpixel = (0xff000000     ) |
                    (((int)rt) << 16) |
                    (((int)gt) <<  8) |
                    (((int)bt) <<  0);
            mDestination[index] = dpixel;
        }
    }
    protected static int sThreshold = 100000;
    @Override
    protected void compute() {
        if (mLength < sThreshold) {
            computeDirectly();
            return;
        }

        int split = mLength / 2;

        invokeAll(new MyForkJoin(mSource, mStart, split, mDestination),
                new MyForkJoin(mSource, mStart + split, mLength - split,
                        mDestination));
    }
}
