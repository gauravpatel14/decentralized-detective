package defpackage;

import android.media.MediaRoute2Info;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: lP0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1026lP0 {
    public static ArrayList a(List list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MediaRoute2Info mediaRoute2InfoB = YN0.b(it.next());
            if (mediaRoute2InfoB != null) {
                arrayList.add(mediaRoute2InfoB.getId());
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.OO0 b(android.media.MediaRoute2Info r13) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC1026lP0.b(android.media.MediaRoute2Info):OO0");
    }
}
