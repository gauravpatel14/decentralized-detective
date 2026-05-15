package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Vo implements InterfaceC1014lH0 {
    public final InterfaceC1014lH0 a;
    public int b = 0;
    public int c = -1;
    public int d = -1;

    public Vo(InterfaceC1014lH0 interfaceC1014lH0) {
        this.a = interfaceC1014lH0;
    }

    @Override // defpackage.InterfaceC1014lH0
    public final void a(int i, int i2) {
        int i3;
        if (this.b == 2 && (i3 = this.c) >= i && i3 <= i + i2) {
            this.d += i2;
            this.c = i;
        } else {
            d();
            this.c = i;
            this.d = i2;
            this.b = 2;
        }
    }

    @Override // defpackage.InterfaceC1014lH0
    public final void b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (this.b == 3 && i <= (i4 = this.d + (i3 = this.c)) && (i5 = i + i2) >= i3) {
            this.c = Math.min(i, i3);
            this.d = Math.max(i4, i5) - this.c;
        } else {
            d();
            this.c = i;
            this.d = i2;
            this.b = 3;
        }
    }

    @Override // defpackage.InterfaceC1014lH0
    public final void c(int i, int i2) {
        int i3;
        if (this.b == 1 && i >= (i3 = this.c)) {
            int i4 = this.d;
            if (i <= i3 + i4) {
                this.d = i4 + i2;
                this.c = Math.min(i, i3);
                return;
            }
        }
        d();
        this.c = i;
        this.d = i2;
        this.b = 1;
    }

    public final void d() {
        int i = this.b;
        if (i == 0) {
            return;
        }
        InterfaceC1014lH0 interfaceC1014lH0 = this.a;
        if (i == 1) {
            interfaceC1014lH0.c(this.c, this.d);
        } else if (i == 2) {
            interfaceC1014lH0.a(this.c, this.d);
        } else if (i == 3) {
            interfaceC1014lH0.b(this.c, this.d);
        }
        this.b = 0;
    }
}
