package defpackage;

/* JADX INFO: renamed from: Pv, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0191Pv extends C0199Qv {
    public final int x;
    public final int y;

    public C0191Pv(byte[] bArr, int i, int i2) {
        super(bArr);
        C0199Qv.j(i, i + i2, bArr.length);
        this.x = i;
        this.y = i2;
    }

    @Override // defpackage.C0199Qv
    public final byte i(int i) {
        int i2 = this.y;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.u[this.x + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(AbstractC1214oR1.a(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(Vx1.a(i, i2, "Index > length: ", ", "));
    }

    @Override // defpackage.C0199Qv
    public final void p(int i, byte[] bArr) {
        System.arraycopy(this.u, this.x, bArr, 0, i);
    }

    @Override // defpackage.C0199Qv
    public final int s() {
        return this.x;
    }

    @Override // defpackage.C0199Qv
    public final int size() {
        return this.y;
    }

    @Override // defpackage.C0199Qv
    public final byte t(int i) {
        return this.u[this.x + i];
    }
}
