package defpackage;

import java.util.Arrays;

/* JADX INFO: renamed from: rW2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC1396rW2 extends AbstractBinderC1095mV2 {
    public final byte[] u;

    public BinderC1396rW2(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.u = bArr;
    }

    @Override // defpackage.AbstractBinderC1095mV2
    public final byte[] X0() {
        return this.u;
    }
}
