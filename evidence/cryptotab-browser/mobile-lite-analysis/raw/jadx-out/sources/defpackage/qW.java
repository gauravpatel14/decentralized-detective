package defpackage;

import android.transition.Transition;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.y;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class qW extends e {
    public final Object b;
    public final boolean c;
    public final Object d;

    public qW(y yVar, boolean z, boolean z2) {
        super(yVar);
        int i = yVar.a;
        n nVar = yVar.c;
        this.b = i == 2 ? z ? nVar.getReenterTransition() : nVar.getEnterTransition() : z ? nVar.getReturnTransition() : nVar.getExitTransition();
        this.c = yVar.a == 2 ? z ? nVar.getAllowReturnTransitionOverlap() : nVar.getAllowEnterTransitionOverlap() : true;
        this.d = z2 ? z ? nVar.getSharedElementReturnTransition() : nVar.getSharedElementEnterTransition() : null;
    }

    public final AbstractC0207Ri0 b() {
        Object obj = this.b;
        AbstractC0207Ri0 abstractC0207Ri0C = c(obj);
        Object obj2 = this.d;
        AbstractC0207Ri0 abstractC0207Ri0C2 = c(obj2);
        if (abstractC0207Ri0C == null || abstractC0207Ri0C2 == null || abstractC0207Ri0C == abstractC0207Ri0C2) {
            return abstractC0207Ri0C == null ? abstractC0207Ri0C2 : abstractC0207Ri0C;
        }
        throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.a.c + " returned Transition " + obj + " which uses a different Transition  type than its shared element transition " + obj2).toString());
    }

    public final AbstractC0207Ri0 c(Object obj) {
        if (obj == null) {
            return null;
        }
        C0185Pi0 c0185Pi0 = AbstractC0118Ki0.a;
        if (obj instanceof Transition) {
            return c0185Pi0;
        }
        AbstractC0207Ri0 abstractC0207Ri0 = AbstractC0118Ki0.b;
        if (abstractC0207Ri0 != null && abstractC0207Ri0.g(obj)) {
            return abstractC0207Ri0;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.a.c + " is not a valid framework Transition or AndroidX Transition");
    }
}
