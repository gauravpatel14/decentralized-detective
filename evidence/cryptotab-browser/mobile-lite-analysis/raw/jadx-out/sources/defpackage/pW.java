package defpackage;

import android.view.ViewGroup;
import androidx.fragment.app.f;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class pW extends RC0 implements InterfaceC0798hk0 {
    public final /* synthetic */ f u;
    public final /* synthetic */ ViewGroup v;
    public final /* synthetic */ Object w;
    public final /* synthetic */ Es1 x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pW(f fVar, ViewGroup viewGroup, Object obj, Es1 es1) {
        super(0);
        this.u = fVar;
        this.v = viewGroup;
        this.w = obj;
        this.x = es1;
    }

    @Override // defpackage.InterfaceC0798hk0
    public final Object c() {
        f fVar = this.u;
        AbstractC0207Ri0 abstractC0207Ri0 = fVar.f;
        ViewGroup viewGroup = this.v;
        Object obj = this.w;
        Object objI = abstractC0207Ri0.i(viewGroup, obj);
        fVar.q = objI;
        if (objI != null) {
            this.x.t = new C1220oW(fVar, viewGroup);
            return C0302Yj2.a;
        }
        throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + '.').toString());
    }
}
