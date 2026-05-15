package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SU2 extends WU2 {
    public final int w;

    public SU2(int i, byte[] bArr) {
        super(bArr);
        WU2.l(0, i, bArr.length);
        this.w = i;
    }

    @Override // defpackage.WU2
    public final byte f(int i) {
        int i2 = this.w;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.u[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(AbstractC1214oR1.a(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(Vx1.a(i, i2, "Index > length: ", ", "));
    }

    @Override // defpackage.WU2
    public final byte i(int i) {
        return this.u[i];
    }

    @Override // defpackage.WU2
    public final int j() {
        return this.w;
    }
}
