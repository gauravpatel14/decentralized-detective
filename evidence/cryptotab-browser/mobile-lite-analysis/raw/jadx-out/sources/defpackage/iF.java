package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class iF implements AB0, hF {
    public static final Map b;
    public static final HashMap c;
    public final Class a;

    static {
        List listAsList = Arrays.asList(InterfaceC0798hk0.class, InterfaceC0926jk0.class, xk0.class, zk0.class, Ak0.class, Bk0.class, Ck0.class, Dk0.class, Ek0.class, Fk0.class, InterfaceC0864ik0.class, InterfaceC0986kk0.class, InterfaceC1046lk0.class, mk0.class, nk0.class, ok0.class, pk0.class, qk0.class, InterfaceC1405rk0.class, InterfaceC1465sk0.class, uk0.class, vk0.class, wk0.class);
        ArrayList arrayList = new ArrayList(PG.d(listAsList));
        int i = 0;
        for (Object obj : listAsList) {
            int i2 = i + 1;
            if (i < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new I81((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        b = EL0.c(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        for (String str : map.values()) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            int iLastIndexOf = str.lastIndexOf(46, str.length() - 1);
            map3.put(S3.a(sb, iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1, str.length()), "CompanionObject"), str.concat(".Companion"));
        }
        for (Map.Entry entry : b.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), "kotlin.Function" + iIntValue);
        }
        c = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(EL0.b(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            Object key = entry2.getKey();
            String strSubstring = (String) entry2.getValue();
            int iLastIndexOf2 = strSubstring.lastIndexOf(46, strSubstring.length() - 1);
            if (iLastIndexOf2 != -1) {
                strSubstring = strSubstring.substring(iLastIndexOf2 + 1, strSubstring.length());
            }
            linkedHashMap.put(key, strSubstring);
        }
    }

    public iF(Class cls) {
        this.a = cls;
    }

    @Override // defpackage.hF
    public final Class a() {
        return this.a;
    }

    public final String b() {
        String str;
        Class cls = this.a;
        String strConcat = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        boolean zIsArray = cls.isArray();
        HashMap map = c;
        if (!zIsArray) {
            String str2 = (String) map.get(cls.getName());
            return str2 == null ? cls.getCanonicalName() : str2;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.isPrimitive() && (str = (String) map.get(componentType.getName())) != null) {
            strConcat = str.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public final boolean c(Object obj) {
        Map map = b;
        Class clsA = this.a;
        Integer num = (Integer) map.get(clsA);
        if (num != null) {
            return AbstractC0222Si2.b(num.intValue(), obj);
        }
        if (clsA.isPrimitive()) {
            clsA = xB0.a(Gs1.a(clsA));
        }
        return clsA.isInstance(obj);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof iF) && xB0.a(this).equals(xB0.a((AB0) obj));
    }

    public final int hashCode() {
        return xB0.a(this).hashCode();
    }

    public final String toString() {
        return this.a.toString() + " (Kotlin reflection is not available)";
    }
}
