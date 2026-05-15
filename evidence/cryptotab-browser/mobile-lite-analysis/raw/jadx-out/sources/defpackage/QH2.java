package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class QH2 implements BI2 {
    public static final Object c = new Object();
    public volatile BI2 a;
    public volatile Object b = c;

    public QH2(BI2 bi2) {
        this.a = bi2;
    }

    public static QH2 a(BI2 bi2) {
        return bi2 instanceof QH2 ? (QH2) bi2 : new QH2(bi2);
    }

    public static BI2 b(BI2 bi2) {
        return bi2 instanceof QH2 ? bi2 : new QH2(bi2);
    }

    @Override // defpackage.BI2
    public final Object zza() {
        Object objZza = this.b;
        Object obj = c;
        if (objZza == obj) {
            synchronized (this) {
                try {
                    objZza = this.b;
                    if (objZza == obj) {
                        objZza = this.a.zza();
                        Object obj2 = this.b;
                        if (obj2 != obj && obj2 != objZza) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + objZza + ". This is likely due to a circular dependency.");
                        }
                        this.b = objZza;
                        this.a = null;
                    }
                } finally {
                }
            }
        }
        return objZza;
    }
}
