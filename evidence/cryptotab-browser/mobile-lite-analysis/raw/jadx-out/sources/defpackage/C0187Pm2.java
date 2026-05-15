package defpackage;

import java.util.Objects;
import org.chromium.base.Callback;

/* JADX INFO: renamed from: Pm2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0187Pm2 implements Callback {
    public final InterfaceC0173Om2 t;
    public Object u;

    public C0187Pm2(InterfaceC0173Om2 interfaceC0173Om2) {
        this.t = interfaceC0173Om2;
    }

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        if (Objects.equals(obj, this.u)) {
            return;
        }
        Object obj2 = this.u;
        this.u = obj;
        this.t.a(obj, obj2);
    }
}
