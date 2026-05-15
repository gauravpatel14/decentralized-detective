package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import defpackage.C0110Iz2;
import defpackage.C1366rA2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zag {
    final C0110Iz2 zaa;
    protected int zab;

    public zag(Uri uri, int i) {
        this.zaa = new C0110Iz2(uri);
        this.zab = i;
    }

    public abstract void zaa(Drawable drawable, boolean z, boolean z2, boolean z3);

    public final void zab(Context context, C1366rA2 c1366rA2, boolean z) {
        int i = this.zab;
        zaa(i != 0 ? context.getResources().getDrawable(i) : null, z, false, false);
    }

    public final void zac(Context context, Bitmap bitmap, boolean z) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
