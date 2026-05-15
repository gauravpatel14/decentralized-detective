package defpackage;

/* JADX INFO: renamed from: aQ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0353aQ2 {
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(byte[] bArr, int i, int i2) {
        int iA;
        while (i < i2 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i2) {
            iA = 0;
        } else {
            while (i < i2) {
                int i3 = i + 1;
                iA = bArr[i];
                if (iA < 0) {
                    if (iA >= -32) {
                        if (iA >= -16) {
                            if (i3 < i2 - 2) {
                                int i4 = i + 2;
                                int i5 = bArr[i3];
                                if (i5 <= -65) {
                                    if ((((i5 + 112) + (iA << 28)) >> 30) == 0) {
                                        int i6 = i + 3;
                                        if (bArr[i4] <= -65) {
                                            i += 4;
                                            if (bArr[i6] > -65) {
                                            }
                                        }
                                    }
                                }
                                iA = -1;
                                break;
                            }
                            iA = AbstractC0776hQ2.a(bArr, i3, i2);
                            break;
                        }
                        if (i3 < i2 - 1) {
                            int i7 = i + 2;
                            char c = bArr[i3];
                            if (c <= -65 && ((iA != -32 || c >= -96) && (iA != -19 || c < -96))) {
                                i += 3;
                                if (bArr[i7] > -65) {
                                }
                            }
                            iA = -1;
                            break;
                        }
                        iA = AbstractC0776hQ2.a(bArr, i3, i2);
                        break;
                    }
                    if (i3 >= i2) {
                        break;
                    }
                    if (iA >= -62) {
                        i += 2;
                        if (bArr[i3] > -65) {
                        }
                    }
                    iA = -1;
                    break;
                }
                i = i3;
            }
            iA = 0;
        }
        return iA == 0;
    }
}
