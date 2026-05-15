package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import defpackage.C0978kf;
import defpackage.Vx1;
import defpackage.gf;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    public static boolean isEmpty(Collection collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @KeepForSdk
    @Deprecated
    public static List listOf() {
        return Collections.emptyList();
    }

    @KeepForSdk
    public static Map mapOf(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Map mapZza = zza(3, false);
        mapZza.put(obj, obj2);
        mapZza.put(obj3, obj4);
        mapZza.put(obj5, obj6);
        return Collections.unmodifiableMap(mapZza);
    }

    @KeepForSdk
    public static Map mapOfKeyValueArrays(Object[] objArr, Object[] objArr2) {
        int length = objArr.length;
        int length2 = objArr2.length;
        if (length != length2) {
            throw new IllegalArgumentException(Vx1.a(length, length2, "Key and values array lengths not equal: ", " != "));
        }
        if (length == 0) {
            return Collections.emptyMap();
        }
        if (length == 1) {
            return Collections.singletonMap(objArr[0], objArr2[0]);
        }
        Map mapZza = zza(length, false);
        for (int i = 0; i < objArr.length; i++) {
            mapZza.put(objArr[i], objArr2[i]);
        }
        return Collections.unmodifiableMap(mapZza);
    }

    @KeepForSdk
    public static Set mutableSetOfWithSize(int i) {
        return i == 0 ? new C0978kf(0) : zzb(i, true);
    }

    @KeepForSdk
    @Deprecated
    public static Set setOf(Object obj, Object obj2, Object obj3) {
        Set setZzb = zzb(3, false);
        setZzb.add(obj);
        setZzb.add(obj2);
        setZzb.add(obj3);
        return Collections.unmodifiableSet(setZzb);
    }

    private static Map zza(int i, boolean z) {
        return i <= 256 ? new gf(i) : new HashMap(i, 1.0f);
    }

    private static Set zzb(int i, boolean z) {
        if (i <= (true != z ? 256 : 128)) {
            return new C0978kf(i);
        }
        return new HashSet(i, true != z ? 1.0f : 0.75f);
    }

    @KeepForSdk
    @Deprecated
    public static List listOf(Object obj) {
        return Collections.singletonList(obj);
    }

    @KeepForSdk
    @Deprecated
    public static List listOf(Object... objArr) {
        int length = objArr.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(objArr));
        }
        return Collections.singletonList(objArr[0]);
    }

    @KeepForSdk
    public static Map mapOf(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        Map mapZza = zza(6, false);
        mapZza.put(obj, obj2);
        mapZza.put(obj3, obj4);
        mapZza.put(obj5, obj6);
        mapZza.put(obj7, obj8);
        mapZza.put(obj9, obj10);
        mapZza.put(obj11, obj12);
        return Collections.unmodifiableMap(mapZza);
    }

    @KeepForSdk
    @Deprecated
    public static Set setOf(Object... objArr) {
        int length = objArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(objArr[0]);
        }
        if (length == 2) {
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Set setZzb = zzb(2, false);
            setZzb.add(obj);
            setZzb.add(obj2);
            return Collections.unmodifiableSet(setZzb);
        }
        if (length == 3) {
            return setOf(objArr[0], objArr[1], objArr[2]);
        }
        if (length != 4) {
            Set setZzb2 = zzb(length, false);
            Collections.addAll(setZzb2, objArr);
            return Collections.unmodifiableSet(setZzb2);
        }
        Object obj3 = objArr[0];
        Object obj4 = objArr[1];
        Object obj5 = objArr[2];
        Object obj6 = objArr[3];
        Set setZzb3 = zzb(4, false);
        setZzb3.add(obj3);
        setZzb3.add(obj4);
        setZzb3.add(obj5);
        setZzb3.add(obj6);
        return Collections.unmodifiableSet(setZzb3);
    }
}
