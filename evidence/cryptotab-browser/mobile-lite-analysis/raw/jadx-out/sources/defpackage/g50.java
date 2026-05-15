package defpackage;

import android.graphics.Bitmap;
import android.graphics.Rect;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class g50 implements Zu1 {
    public final Bitmap a;
    public final Rect b;
    public final long c;

    public g50(Bitmap bitmap, Rect rect, long j) {
        this.a = bitmap;
        this.b = rect;
        this.c = j;
    }

    @Override // defpackage.Zu1
    public final Rect a() {
        return this.b;
    }

    @Override // defpackage.Zu1
    public final XZ0 b() {
        return null;
    }

    @Override // defpackage.Zu1
    public final Bitmap c() {
        return this.a;
    }

    @Override // defpackage.Zu1
    public final long d() {
        return this.c;
    }

    @Override // defpackage.Zu1
    public final boolean e() {
        return false;
    }
}
