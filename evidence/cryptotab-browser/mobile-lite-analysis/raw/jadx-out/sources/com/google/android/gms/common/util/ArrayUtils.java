package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class ArrayUtils {
    private ArrayUtils() {
    }

    @KeepForSdk
    public static Object[] concat(Object[]... objArr) {
        if (objArr.length == 0) {
            return (Object[]) Array.newInstance(objArr.getClass(), 0);
        }
        int length = 0;
        for (Object[] objArr2 : objArr) {
            length += objArr2.length;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr[0], length);
        int length2 = objArr[0].length;
        for (int i = 1; i < objArr.length; i++) {
            Object[] objArr3 = objArr[i];
            int length3 = objArr3.length;
            System.arraycopy(objArr3, 0, objArrCopyOf, length2, length3);
            length2 += length3;
        }
        return objArrCopyOf;
    }

    @KeepForSdk
    public static byte[] concatByteArrays(byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr[0], length);
        int length2 = bArr[0].length;
        for (int i = 1; i < bArr.length; i++) {
            byte[] bArr3 = bArr[i];
            int length3 = bArr3.length;
            System.arraycopy(bArr3, 0, bArrCopyOf, length2, length3);
            length2 += length3;
        }
        return bArrCopyOf;
    }

    @KeepForSdk
    public static boolean contains(int[] iArr, int i) {
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    @KeepForSdk
    public static ArrayList newArrayList() {
        return new ArrayList();
    }

    @KeepForSdk
    public static Object[] removeAll(Object[] objArr, Object... objArr2) {
        int length;
        int i;
        if (objArr == null) {
            return null;
        }
        if (objArr2 == null || (length = objArr2.length) == 0) {
            return Arrays.copyOf(objArr, objArr.length);
        }
        Class<?> cls = objArr2.getClass();
        Object[] objArr3 = (Object[]) Array.newInstance(cls.getComponentType(), objArr.length);
        if (length == 1) {
            i = 0;
            for (Object obj : objArr) {
                if (!Objects.equal(objArr2[0], obj)) {
                    objArr3[i] = obj;
                    i++;
                }
            }
        } else {
            int i2 = 0;
            for (Object obj2 : objArr) {
                if (!contains(objArr2, obj2)) {
                    objArr3[i2] = obj2;
                    i2++;
                }
            }
            i = i2;
        }
        if (objArr3 == null) {
            return null;
        }
        return i == objArr3.length ? objArr3 : Arrays.copyOf(objArr3, i);
    }

    @KeepForSdk
    public static ArrayList toArrayList(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    @KeepForSdk
    public static int[] toPrimitiveArray(Collection collection) {
        int i = 0;
        if (collection == null || collection.isEmpty()) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            iArr[i] = ((Integer) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    @KeepForSdk
    public static Integer[] toWrapperArray(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb, double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(dArr[i]);
        }
    }

    @KeepForSdk
    public static void writeStringArray(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(strArr[i]);
            sb.append("\"");
        }
    }

    @KeepForSdk
    public static boolean contains(Object[] objArr, Object obj) {
        int length = objArr != null ? objArr.length : 0;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (!Objects.equal(objArr[i], obj)) {
                i++;
            } else if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb, float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(fArr[i]);
        }
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb, int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(iArr[i]);
        }
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb, long[] jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(jArr[i]);
        }
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb, Object[] objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(objArr[i]);
        }
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb, boolean[] zArr) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(zArr[i]);
        }
    }
}
