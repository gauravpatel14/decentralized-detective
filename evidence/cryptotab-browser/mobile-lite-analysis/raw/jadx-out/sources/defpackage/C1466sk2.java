package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: renamed from: sk2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1466sk2 extends AbstractC1577uk2 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1466sk2(Unsafe unsafe, int i) {
        super(unsafe);
        this.b = i;
    }

    @Override // defpackage.AbstractC1577uk2
    public final void c(long j, byte[] bArr, long j2) {
        switch (this.b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // defpackage.AbstractC1577uk2
    public final boolean d(long j, Object obj) {
        switch (this.b) {
            case 0:
                if (AbstractC1633vk2.g) {
                    if (AbstractC1633vk2.g(j, obj) == 0) {
                    }
                } else if (AbstractC1633vk2.h(j, obj) == 0) {
                }
                break;
            default:
                if (AbstractC1633vk2.g) {
                    if (AbstractC1633vk2.g(j, obj) == 0) {
                    }
                } else if (AbstractC1633vk2.h(j, obj) == 0) {
                }
                break;
        }
        return false;
    }

    @Override // defpackage.AbstractC1577uk2
    public final byte e(long j) {
        switch (this.b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // defpackage.AbstractC1577uk2
    public final byte f(long j, Object obj) {
        switch (this.b) {
            case 0:
                if (!AbstractC1633vk2.g) {
                }
                break;
            default:
                if (!AbstractC1633vk2.g) {
                }
                break;
        }
        return AbstractC1633vk2.h(j, obj);
    }

    @Override // defpackage.AbstractC1577uk2
    public final double g(long j, Object obj) {
        switch (this.b) {
        }
        return Double.longBitsToDouble(j(j, obj));
    }

    @Override // defpackage.AbstractC1577uk2
    public final float h(long j, Object obj) {
        switch (this.b) {
        }
        return Float.intBitsToFloat(i(j, obj));
    }

    @Override // defpackage.AbstractC1577uk2
    public final void m(Object obj, long j, boolean z) {
        switch (this.b) {
            case 0:
                if (!AbstractC1633vk2.g) {
                    AbstractC1633vk2.p(obj, j, z ? (byte) 1 : (byte) 0);
                } else {
                    AbstractC1633vk2.o(obj, j, z ? (byte) 1 : (byte) 0);
                }
                break;
            default:
                if (!AbstractC1633vk2.g) {
                    AbstractC1633vk2.p(obj, j, z ? (byte) 1 : (byte) 0);
                } else {
                    AbstractC1633vk2.o(obj, j, z ? (byte) 1 : (byte) 0);
                }
                break;
        }
    }

    @Override // defpackage.AbstractC1577uk2
    public final void n(Object obj, long j, byte b) {
        switch (this.b) {
            case 0:
                if (!AbstractC1633vk2.g) {
                    AbstractC1633vk2.p(obj, j, b);
                } else {
                    AbstractC1633vk2.o(obj, j, b);
                }
                break;
            default:
                if (!AbstractC1633vk2.g) {
                    AbstractC1633vk2.p(obj, j, b);
                } else {
                    AbstractC1633vk2.o(obj, j, b);
                }
                break;
        }
    }

    @Override // defpackage.AbstractC1577uk2
    public final void o(Object obj, long j, double d) {
        switch (this.b) {
            case 0:
                r(obj, j, Double.doubleToLongBits(d));
                break;
            default:
                r(obj, j, Double.doubleToLongBits(d));
                break;
        }
    }

    @Override // defpackage.AbstractC1577uk2
    public final void p(float f, long j, Object obj) {
        switch (this.b) {
            case 0:
                q(Float.floatToIntBits(f), j, obj);
                break;
            default:
                q(Float.floatToIntBits(f), j, obj);
                break;
        }
    }

    @Override // defpackage.AbstractC1577uk2
    public final boolean u() {
        switch (this.b) {
        }
        return false;
    }
}
