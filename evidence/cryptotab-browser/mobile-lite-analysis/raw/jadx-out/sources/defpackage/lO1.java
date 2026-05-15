package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class lO1 {
    private volatile /* synthetic */ Object _state;
    public int a;

    public lO1(Object obj) {
        this._state = obj;
    }

    public final void a(Object obj) {
        int i;
        if (obj == null) {
            obj = AbstractC1062m21.a;
        }
        synchronized (this) {
            if (lz0.a(this._state, obj)) {
                return;
            }
            this._state = obj;
            int i2 = this.a;
            if ((i2 & 1) != 0) {
                this.a = i2 + 2;
                return;
            }
            int i3 = i2 + 1;
            this.a = i3;
            while (true) {
                synchronized (this) {
                    i = this.a;
                    if (i == i3) {
                        this.a = i3 + 1;
                        return;
                    }
                }
                i3 = i;
            }
        }
    }
}
