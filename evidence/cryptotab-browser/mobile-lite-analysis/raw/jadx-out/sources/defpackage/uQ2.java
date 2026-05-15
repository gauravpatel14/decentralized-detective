package defpackage;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class uQ2 extends MJ0 {
    public final /* synthetic */ TQ2 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uQ2(TQ2 tq2) {
        super(20);
        this.g = tq2;
    }

    @Override // defpackage.MJ0
    public final Object a(Object obj) throws Throwable {
        gP2 gp2;
        LinkedHashMap linkedHashMap;
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        TQ2 tq2 = this.g;
        tq2.h();
        Preconditions.checkNotEmpty(str);
        if (TextUtils.isEmpty(str) || (gp2 = (gP2) tq2.h.get(str)) == null || gp2.l() == 0) {
            return null;
        }
        if (!tq2.h.containsKey(str) || tq2.h.get(str) == null) {
            tq2.m(str);
        } else {
            tq2.n(str, (gP2) tq2.h.get(str));
        }
        uQ2 uq2 = tq2.j;
        synchronized (uq2.c) {
            linkedHashMap = new LinkedHashMap(uq2.b.a.entrySet().size());
            for (Map.Entry entry : uq2.b.a.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return (XH2) linkedHashMap.get(str);
    }
}
