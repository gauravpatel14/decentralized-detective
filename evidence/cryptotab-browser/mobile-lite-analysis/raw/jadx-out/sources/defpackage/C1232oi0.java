package defpackage;

import androidx.fragment.app.n;
import androidx.fragment.app.s;
import java.util.ArrayList;

/* JADX INFO: renamed from: oi0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1232oi0 implements InterfaceC1166ni0 {
    public final int a;
    public final int b;
    public final /* synthetic */ s c;

    public C1232oi0(s sVar, int i, int i2) {
        this.c = sVar;
        this.a = i;
        this.b = i2;
    }

    @Override // defpackage.InterfaceC1166ni0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        s sVar = this.c;
        n nVar = sVar.z;
        int i = this.a;
        if (nVar == null || i >= 0 || !nVar.getChildFragmentManager().P(-1, 0)) {
            return sVar.Q(arrayList, arrayList2, i, this.b);
        }
        return false;
    }
}
