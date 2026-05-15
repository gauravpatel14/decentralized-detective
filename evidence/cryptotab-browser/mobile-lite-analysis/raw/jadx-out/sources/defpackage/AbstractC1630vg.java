package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: vg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1630vg extends h51 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(AbstractC1630vg.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = AbstractC1574ug.a;

    @Override // defpackage.h51
    public final Object a(Object obj) {
        Object obj2 = this._consensus;
        eT1 et1 = AbstractC1574ug.a;
        if (obj2 == et1) {
            eT1 et1C = c(obj);
            obj2 = this._consensus;
            if (obj2 == et1) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, et1, et1C)) {
                        obj2 = et1C;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != et1) {
                        obj2 = this._consensus;
                        break;
                    }
                }
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract eT1 c(Object obj);
}
