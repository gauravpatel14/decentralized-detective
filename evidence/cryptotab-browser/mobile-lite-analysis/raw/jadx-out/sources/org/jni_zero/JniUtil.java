package org.jni_zero;

import android.util.ArrayMap;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class JniUtil {
    public static Map arrayToMap(Object[] objArr) {
        int length = objArr.length;
        ArrayMap arrayMap = new ArrayMap(length / 2);
        for (int i = 0; i < length; i += 2) {
            arrayMap.put(objArr[i], objArr[i + 1]);
        }
        return arrayMap;
    }

    public static Object[] mapToArray(Map map) {
        Object[] objArr = new Object[map.size() * 2];
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            int i2 = i + 1;
            objArr[i] = entry.getKey();
            i += 2;
            objArr[i2] = entry.getValue();
        }
        return objArr;
    }
}
