package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class mE0 implements InterfaceC0988kn1 {
    public static final Object c = new Object();
    public volatile Object a = c;
    public volatile InterfaceC0988kn1 b;

    public mE0(InterfaceC0988kn1 interfaceC0988kn1) {
        this.b = interfaceC0988kn1;
    }

    @Override // defpackage.InterfaceC0988kn1
    public final Object get() {
        Object obj = this.a;
        Object obj2 = c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.a;
                    if (obj == obj2) {
                        obj = this.b.get();
                        this.a = obj;
                        this.b = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
