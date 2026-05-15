package org.chromium.ui.resources;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import defpackage.AbstractC0292Xp1;
import defpackage.AbstractC0911ja;
import defpackage.AbstractC1499tM;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class HandleViewResources {
    public static final int[] a = {R.attr.textSelectHandleLeft};
    public static final int[] b = {R.attr.textSelectHandle};
    public static final int[] c = {R.attr.textSelectHandleRight};

    public static Bitmap a(Context context, int[] iArr) {
        Bitmap bitmapDecodeResource;
        if (context == null) {
            context = AbstractC1499tM.a;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, AbstractC0292Xp1.ThemeOverlay_UI_SelectionHandle);
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.getTheme().obtainStyledAttributes(iArr);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(typedArrayObtainStyledAttributes.getIndex(0), 0);
        Resources resources = typedArrayObtainStyledAttributes.getResources();
        typedArrayObtainStyledAttributes.recycle();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = config;
        Bitmap bitmapDecodeResource2 = BitmapFactory.decodeResource(resources, resourceId, options);
        if (bitmapDecodeResource2 != null) {
            return bitmapDecodeResource2;
        }
        if (resources != contextThemeWrapper.getResources() && (bitmapDecodeResource = BitmapFactory.decodeResource(contextThemeWrapper.getResources(), resourceId, options)) != null) {
            return bitmapDecodeResource;
        }
        TypedArray typedArrayObtainStyledAttributes2 = contextThemeWrapper.getTheme().obtainStyledAttributes(iArr);
        Drawable drawable = typedArrayObtainStyledAttributes2.getDrawable(0);
        if (drawable == null) {
            try {
                drawable = AbstractC0911ja.b(contextThemeWrapper.getResources(), typedArrayObtainStyledAttributes2.getResourceId(0, 0), 0);
            } catch (Resources.NotFoundException unused) {
            }
        }
        typedArrayObtainStyledAttributes2.recycle();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap getCenterHandleBitmap(Context context) {
        return a(context, b);
    }

    public static float getHandleHorizontalPaddingRatio() {
        return 0.25f;
    }

    public static Bitmap getLeftHandleBitmap(Context context) {
        return a(context, a);
    }

    public static Bitmap getRightHandleBitmap(Context context) {
        return a(context, c);
    }
}
