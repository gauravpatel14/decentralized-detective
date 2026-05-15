package defpackage;

import java.util.HashMap;

/* JADX INFO: renamed from: ib0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0855ib0 extends Ux1 {
    public final HashMap x = new HashMap();

    @Override // defpackage.Ux1
    public final Rx1 e(Object obj) {
        return (Rx1) this.x.get(obj);
    }

    @Override // defpackage.Ux1
    public final Object f(Object obj) {
        Object objF = super.f(obj);
        this.x.remove(obj);
        return objF;
    }
}
