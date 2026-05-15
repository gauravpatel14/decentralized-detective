package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SE1 extends ER0 {
    public final wS0 d;
    public ER0 e;

    public SE1(ER0 er0, wS0 ws0) {
        super(er0.a, er0.b);
        this.d = ws0;
    }

    public final ER0 b() {
        if (this.e == null) {
            ByteBuffer byteBufferSlice = ((ByteBuffer) this.a.position(this.d.a.a)).slice();
            byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
            this.e = new ER0(byteBufferSlice, this.b);
        }
        return this.e;
    }

    @Override // defpackage.ER0
    public final SE1 a() {
        return this;
    }
}
