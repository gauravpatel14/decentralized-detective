package defpackage;

import android.graphics.Path;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class rc1 {
    public static float[] a(float[] fArr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i, length);
        float[] fArr2 = new float[i];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[Catch: NumberFormatException -> 0x00aa, LOOP:3: B:25:0x0068->B:44:0x0096, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.qc1[] b(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rc1.b(java.lang.String):qc1[]");
    }

    public static qc1[] c(qc1[] qc1VarArr) {
        qc1[] qc1VarArr2 = new qc1[qc1VarArr.length];
        for (int i = 0; i < qc1VarArr.length; i++) {
            qc1VarArr2[i] = new qc1(qc1VarArr[i]);
        }
        return qc1VarArr2;
    }

    public static void d(qc1[] qc1VarArr, Path path) {
        int i;
        int i2;
        char c;
        int i3;
        int i4;
        qc1 qc1Var;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        qc1[] qc1VarArr2 = qc1VarArr;
        int i5 = 6;
        float[] fArr = new float[6];
        int length = qc1VarArr2.length;
        int i6 = 0;
        char c2 = 'm';
        while (i6 < length) {
            qc1 qc1Var2 = qc1VarArr2[i6];
            char c3 = qc1Var2.a;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[2];
            float f16 = fArr[3];
            float f17 = fArr[4];
            float f18 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = i5;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f17, f18);
                    f13 = f17;
                    f15 = f13;
                    f14 = f18;
                    f16 = f14;
                default:
                    i = 2;
                    break;
            }
            float f19 = f17;
            float f20 = f18;
            float f21 = f13;
            float f22 = f14;
            int i7 = 0;
            while (true) {
                float[] fArr2 = qc1Var2.b;
                if (i7 < fArr2.length) {
                    if (c3 != 'A') {
                        if (c3 != 'C') {
                            if (c3 == 'H') {
                                i2 = i7;
                                c = c3;
                                i3 = i6;
                                i4 = length;
                                qc1Var = qc1Var2;
                                path.lineTo(fArr2[i2], f22);
                                f21 = fArr2[i2];
                            } else if (c3 == 'Q') {
                                i2 = i7;
                                c = c3;
                                i3 = i6;
                                i4 = length;
                                qc1Var = qc1Var2;
                                float f23 = fArr2[i2];
                                int i8 = i2 + 1;
                                float f24 = fArr2[i8];
                                int i9 = i2 + 2;
                                int i10 = i2 + 3;
                                path.quadTo(f23, f24, fArr2[i9], fArr2[i10]);
                                f = fArr2[i2];
                                f2 = fArr2[i8];
                                f21 = fArr2[i9];
                                f22 = fArr2[i10];
                            } else if (c3 == 'V') {
                                i2 = i7;
                                c = c3;
                                i3 = i6;
                                i4 = length;
                                qc1Var = qc1Var2;
                                path.lineTo(f21, fArr2[i2]);
                                f22 = fArr2[i2];
                            } else if (c3 != 'a') {
                                if (c3 != 'c') {
                                    if (c3 != 'h') {
                                        if (c3 == 'q') {
                                            i2 = i7;
                                            float f25 = f22;
                                            float f26 = f21;
                                            int i11 = i2 + 1;
                                            int i12 = i2 + 2;
                                            int i13 = i2 + 3;
                                            path.rQuadTo(fArr2[i2], fArr2[i11], fArr2[i12], fArr2[i13]);
                                            float f27 = f26 + fArr2[i2];
                                            float f28 = fArr2[i11] + f25;
                                            float f29 = f26 + fArr2[i12];
                                            f22 = f25 + fArr2[i13];
                                            f16 = f28;
                                            f15 = f27;
                                            c = c3;
                                            i3 = i6;
                                            i4 = length;
                                            f21 = f29;
                                        } else if (c3 == 'v') {
                                            i2 = i7;
                                            path.rLineTo(0.0f, fArr2[i2]);
                                            f22 += fArr2[i2];
                                        } else if (c3 == 'L') {
                                            i2 = i7;
                                            int i14 = i2 + 1;
                                            path.lineTo(fArr2[i2], fArr2[i14]);
                                            f21 = fArr2[i2];
                                            f22 = fArr2[i14];
                                        } else if (c3 == 'M') {
                                            i2 = i7;
                                            f21 = fArr2[i2];
                                            f22 = fArr2[i2 + 1];
                                            if (i2 > 0) {
                                                path.lineTo(f21, f22);
                                            } else {
                                                path.moveTo(f21, f22);
                                                f20 = f22;
                                                f19 = f21;
                                            }
                                        } else if (c3 == 'S') {
                                            i2 = i7;
                                            float f30 = f22;
                                            float f31 = f21;
                                            if (c2 == 'c' || c2 == 's' || c2 == 'C' || c2 == 'S') {
                                                f7 = (f30 * 2.0f) - f16;
                                                f8 = (f31 * 2.0f) - f15;
                                            } else {
                                                f8 = f31;
                                                f7 = f30;
                                            }
                                            int i15 = i2 + 1;
                                            int i16 = i2 + 2;
                                            int i17 = i2 + 3;
                                            path.cubicTo(f8, f7, fArr2[i2], fArr2[i15], fArr2[i16], fArr2[i17]);
                                            float f32 = fArr2[i2];
                                            float f33 = fArr2[i15];
                                            f21 = fArr2[i16];
                                            f22 = fArr2[i17];
                                            f16 = f33;
                                            f15 = f32;
                                        } else if (c3 == 'T') {
                                            i2 = i7;
                                            float f34 = f22;
                                            float f35 = f21;
                                            if (c2 == 'q' || c2 == 't' || c2 == 'Q' || c2 == 'T') {
                                                f3 = (f35 * 2.0f) - f15;
                                                f4 = (f34 * 2.0f) - f16;
                                            } else {
                                                f3 = f35;
                                                f4 = f34;
                                            }
                                            int i18 = i2 + 1;
                                            path.quadTo(f3, f4, fArr2[i2], fArr2[i18]);
                                            f5 = fArr2[i2];
                                            f6 = fArr2[i18];
                                        } else if (c3 == 'l') {
                                            i2 = i7;
                                            int i19 = i2 + 1;
                                            path.rLineTo(fArr2[i2], fArr2[i19]);
                                            f21 += fArr2[i2];
                                            f22 += fArr2[i19];
                                        } else if (c3 == 'm') {
                                            i2 = i7;
                                            float f36 = fArr2[i2];
                                            f21 += f36;
                                            float f37 = fArr2[i2 + 1];
                                            f22 += f37;
                                            if (i2 > 0) {
                                                path.rLineTo(f36, f37);
                                            } else {
                                                path.rMoveTo(f36, f37);
                                                f20 = f22;
                                                f19 = f21;
                                            }
                                        } else if (c3 == 's') {
                                            if (c2 == 'c' || c2 == 's' || c2 == 'C' || c2 == 'S') {
                                                float f38 = f21 - f15;
                                                f9 = f22 - f16;
                                                f10 = f38;
                                            } else {
                                                f9 = 0.0f;
                                                f10 = 0.0f;
                                            }
                                            int i20 = i7 + 1;
                                            int i21 = i7 + 2;
                                            int i22 = i7 + 3;
                                            i2 = i7;
                                            float f39 = f22;
                                            float f40 = f21;
                                            path.rCubicTo(f10, f9, fArr2[i7], fArr2[i20], fArr2[i21], fArr2[i22]);
                                            f3 = f40 + fArr2[i2];
                                            f4 = f39 + fArr2[i20];
                                            f5 = f40 + fArr2[i21];
                                            f6 = fArr2[i22] + f39;
                                        } else if (c3 != 't') {
                                            i2 = i7;
                                        } else {
                                            if (c2 == 'q' || c2 == 't' || c2 == 'Q' || c2 == 'T') {
                                                f11 = f21 - f15;
                                                f12 = f22 - f16;
                                            } else {
                                                f12 = 0.0f;
                                                f11 = 0.0f;
                                            }
                                            int i23 = i7 + 1;
                                            path.rQuadTo(f11, f12, fArr2[i7], fArr2[i23]);
                                            float f41 = f11 + f21;
                                            float f42 = f12 + f22;
                                            f21 += fArr2[i7];
                                            f22 += fArr2[i23];
                                            f16 = f42;
                                            i2 = i7;
                                            c = c3;
                                            i3 = i6;
                                            i4 = length;
                                            f15 = f41;
                                        }
                                        qc1Var = qc1Var2;
                                    } else {
                                        i2 = i7;
                                        path.rLineTo(fArr2[i2], 0.0f);
                                        f21 += fArr2[i2];
                                    }
                                    c = c3;
                                    i3 = i6;
                                    i4 = length;
                                    qc1Var = qc1Var2;
                                } else {
                                    i2 = i7;
                                    float f43 = f22;
                                    float f44 = f21;
                                    int i24 = i2 + 2;
                                    int i25 = i2 + 3;
                                    int i26 = i2 + 4;
                                    int i27 = i2 + 5;
                                    path.rCubicTo(fArr2[i2], fArr2[i2 + 1], fArr2[i24], fArr2[i25], fArr2[i26], fArr2[i27]);
                                    f3 = f44 + fArr2[i24];
                                    f4 = f43 + fArr2[i25];
                                    f5 = f44 + fArr2[i26];
                                    f6 = fArr2[i27] + f43;
                                }
                                f16 = f4;
                                f15 = f3;
                                c = c3;
                                i3 = i6;
                                i4 = length;
                                f21 = f5;
                                f22 = f6;
                                qc1Var = qc1Var2;
                            } else {
                                i2 = i7;
                                float f45 = f22;
                                float f46 = f21;
                                int i28 = i2 + 5;
                                int i29 = i2 + 6;
                                c = c3;
                                i4 = length;
                                qc1Var = qc1Var2;
                                i3 = i6;
                                qc1.a(path, f46, f45, fArr2[i28] + f46, fArr2[i29] + f45, fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                                f21 = f46 + fArr2[i28];
                                f22 = f45 + fArr2[i29];
                            }
                            i7 = i2 + i;
                            qc1Var2 = qc1Var;
                            length = i4;
                            c2 = c;
                            c3 = c2;
                            i6 = i3;
                        } else {
                            i2 = i7;
                            c = c3;
                            i3 = i6;
                            i4 = length;
                            qc1Var = qc1Var2;
                            int i30 = i2 + 2;
                            int i31 = i2 + 3;
                            int i32 = i2 + 4;
                            int i33 = i2 + 5;
                            path.cubicTo(fArr2[i2], fArr2[i2 + 1], fArr2[i30], fArr2[i31], fArr2[i32], fArr2[i33]);
                            f21 = fArr2[i32];
                            f22 = fArr2[i33];
                            f = fArr2[i30];
                            f2 = fArr2[i31];
                        }
                        f15 = f;
                        f16 = f2;
                        i7 = i2 + i;
                        qc1Var2 = qc1Var;
                        length = i4;
                        c2 = c;
                        c3 = c2;
                        i6 = i3;
                    } else {
                        i2 = i7;
                        c = c3;
                        i3 = i6;
                        i4 = length;
                        qc1Var = qc1Var2;
                        int i34 = i2 + 5;
                        int i35 = i2 + 6;
                        qc1.a(path, f21, f22, fArr2[i34], fArr2[i35], fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f21 = fArr2[i34];
                        f22 = fArr2[i35];
                    }
                    f16 = f22;
                    f15 = f21;
                    i7 = i2 + i;
                    qc1Var2 = qc1Var;
                    length = i4;
                    c2 = c;
                    c3 = c2;
                    i6 = i3;
                }
            }
            fArr[0] = f21;
            fArr[1] = f22;
            fArr[2] = f15;
            fArr[3] = f16;
            fArr[4] = f19;
            fArr[5] = f20;
            c2 = qc1Var2.a;
            i6++;
            qc1VarArr2 = qc1VarArr;
            length = length;
            i5 = 6;
        }
    }
}
