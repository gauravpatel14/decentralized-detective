package defpackage;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RX2 {
    public static final void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            WU2 wu2 = WU2.v;
            sb.append(DY2.a(new WU2(((String) obj).getBytes(NW2.a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof WU2) {
            sb.append(": \"");
            sb.append(DY2.a((WU2) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC1852zW2) {
            sb.append(" {");
            c((AbstractC1852zW2) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i4 = i + 2;
        a(sb, i4, "key", entry.getKey());
        a(sb, i4, "value", entry.getValue());
        sb.append("\n");
        while (i2 < i) {
            sb.append(' ');
            i2++;
        }
        sb.append("}");
    }

    public static final String b(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    public static void c(AbstractC1852zW2 abstractC1852zW2, StringBuilder sb, int i) {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : abstractC1852zW2.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String strSubstring = str.startsWith("get") ? str.substring(3) : str;
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List")) {
                String strConcat = String.valueOf(strSubstring.substring(0, 1).toLowerCase()).concat(String.valueOf(strSubstring.substring(1, strSubstring.length() - 4)));
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    a(sb, i, b(strConcat), AbstractC1852zW2.i(method2, abstractC1852zW2, new Object[0]));
                }
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map")) {
                String strConcat2 = String.valueOf(strSubstring.substring(0, 1).toLowerCase()).concat(String.valueOf(strSubstring.substring(1, strSubstring.length() - 3)));
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    a(sb, i, b(strConcat2), AbstractC1852zW2.i(method3, abstractC1852zW2, new Object[0]));
                }
            }
            if (((Method) map2.get("set".concat(strSubstring))) != null && (!strSubstring.endsWith("Bytes") || !map.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                String strConcat3 = String.valueOf(strSubstring.substring(0, 1).toLowerCase()).concat(String.valueOf(strSubstring.substring(1)));
                Method method4 = (Method) map.get("get".concat(strSubstring));
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objI = AbstractC1852zW2.i(method4, abstractC1852zW2, new Object[0]);
                    if (method5 == null) {
                        if (objI instanceof Boolean) {
                            if (((Boolean) objI).booleanValue()) {
                                a(sb, i, b(strConcat3), objI);
                            }
                        } else if (objI instanceof Integer) {
                            if (((Integer) objI).intValue() != 0) {
                                a(sb, i, b(strConcat3), objI);
                            }
                        } else if (objI instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objI).floatValue()) != 0) {
                                a(sb, i, b(strConcat3), objI);
                            }
                        } else if (!(objI instanceof Double)) {
                            if (objI instanceof String) {
                                zEquals = objI.equals("");
                            } else if (objI instanceof WU2) {
                                zEquals = objI.equals(WU2.v);
                            } else if (objI instanceof CU2) {
                                if (objI != ((AbstractC1852zW2) ((AbstractC1852zW2) ((CU2) objI)).k(6))) {
                                    a(sb, i, b(strConcat3), objI);
                                }
                            } else if (!(objI instanceof Enum) || ((Enum) objI).ordinal() != 0) {
                                a(sb, i, b(strConcat3), objI);
                            }
                            if (!zEquals) {
                                a(sb, i, b(strConcat3), objI);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objI).doubleValue()) != 0) {
                            a(sb, i, b(strConcat3), objI);
                        }
                    } else if (((Boolean) AbstractC1852zW2.i(method5, abstractC1852zW2, new Object[0])).booleanValue()) {
                        a(sb, i, b(strConcat3), objI);
                    }
                }
            }
        }
        EY2 ey2 = abstractC1852zW2.zzc;
        if (ey2 != null) {
            for (int i2 = 0; i2 < ey2.a; i2++) {
                a(sb, i, String.valueOf(ey2.b[i2] >>> 3), ey2.c[i2]);
            }
        }
    }
}
