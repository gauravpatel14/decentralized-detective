package defpackage;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: lq, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1051lq extends MJ0 {
    @Override // defpackage.MJ0
    public final Object a(Object obj) {
        WeakReference weakReference = (WeakReference) mq.d.get((String) obj);
        if (weakReference == null) {
            return null;
        }
        return (Bitmap) weakReference.get();
    }

    @Override // defpackage.MJ0
    public final int f(Object obj, Object obj2) {
        return ((Bitmap) obj2).getByteCount();
    }
}
