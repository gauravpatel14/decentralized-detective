package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import defpackage.C0204Qz2;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zadc {
    public static final Status zaa = new Status(8, "The connection to Google Play services was lost");
    final Set zab = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final C0204Qz2 zac = new C0204Qz2(this);

    public final void zaa(BasePendingResult basePendingResult) {
        this.zab.add(basePendingResult);
        basePendingResult.zan(this.zac);
    }

    public final void zab() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zab.toArray(new BasePendingResult[0])) {
            basePendingResult.zan(null);
            if (basePendingResult.zam()) {
                this.zab.remove(basePendingResult);
            }
        }
    }
}
