package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: Ki0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0118Ki0 {
    public static final C0185Pi0 a = new C0185Pi0();
    public static final AbstractC0207Ri0 b;

    static {
        AbstractC0207Ri0 abstractC0207Ri0 = null;
        try {
            abstractC0207Ri0 = (AbstractC0207Ri0) Class.forName("Xi0").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = abstractC0207Ri0;
    }

    public static final void a(int i, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(i);
        }
    }
}
