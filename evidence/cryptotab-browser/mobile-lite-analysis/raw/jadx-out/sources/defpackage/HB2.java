package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HB2 {
    public final C0576eN2 a;

    public HB2(C0576eN2 c0576eN2) {
        this.a = c0576eN2;
    }

    public final synchronized void a(Context context, HashSet hashSet) {
        AssetManager assets = context.getAssets();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((Integer) TG2.b(assets, "addAssetPath", Integer.class, String.class, ((File) it.next()).getPath())).intValue();
        }
    }
}
