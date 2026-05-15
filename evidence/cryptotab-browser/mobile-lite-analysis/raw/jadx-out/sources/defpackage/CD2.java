package defpackage;

import android.os.Bundle;
import java.util.EnumMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CD2 {
    public static final CD2 b = new CD2(null, null);
    public final EnumMap a;

    public CD2(Boolean bool, Boolean bool2) {
        EnumMap enumMap = new EnumMap(EnumC1486tD2.class);
        this.a = enumMap;
        enumMap.put(EnumC1486tD2.AD_STORAGE, bool);
        enumMap.put(EnumC1486tD2.ANALYTICS_STORAGE, bool2);
    }

    public static CD2 a(Bundle bundle) {
        if (bundle == null) {
            return b;
        }
        EnumMap enumMap = new EnumMap(EnumC1486tD2.class);
        for (EnumC1486tD2 enumC1486tD2 : EnumC1486tD2.values()) {
            String string = bundle.getString(enumC1486tD2.t);
            Boolean bool = null;
            if (string != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
            }
            enumMap.put(enumC1486tD2, bool);
        }
        return new CD2(enumMap);
    }

    public static CD2 b(String str) {
        EnumMap enumMap = new EnumMap(EnumC1486tD2.class);
        if (str != null) {
            for (int i = 0; i < 2; i++) {
                EnumC1486tD2 enumC1486tD2 = EnumC1486tD2.w[i];
                int i2 = i + 2;
                if (i2 < str.length()) {
                    char cCharAt = str.charAt(i2);
                    Boolean bool = null;
                    if (cCharAt != '-') {
                        if (cCharAt == '0') {
                            bool = Boolean.FALSE;
                        } else if (cCharAt == '1') {
                            bool = Boolean.TRUE;
                        }
                    }
                    enumMap.put(enumC1486tD2, bool);
                }
            }
        }
        return new CD2(enumMap);
    }

    public final CD2 c(CD2 cd2) {
        EnumMap enumMap = new EnumMap(EnumC1486tD2.class);
        for (EnumC1486tD2 enumC1486tD2 : EnumC1486tD2.values()) {
            Boolean boolValueOf = (Boolean) this.a.get(enumC1486tD2);
            Boolean bool = (Boolean) cd2.a.get(enumC1486tD2);
            if (boolValueOf == null) {
                boolValueOf = bool;
            } else if (bool != null) {
                boolValueOf = Boolean.valueOf(boolValueOf.booleanValue() && bool.booleanValue());
            }
            enumMap.put(enumC1486tD2, boolValueOf);
        }
        return new CD2(enumMap);
    }

    public final CD2 d(CD2 cd2) {
        EnumMap enumMap = new EnumMap(EnumC1486tD2.class);
        for (EnumC1486tD2 enumC1486tD2 : EnumC1486tD2.values()) {
            Boolean bool = (Boolean) this.a.get(enumC1486tD2);
            if (bool == null) {
                bool = (Boolean) cd2.a.get(enumC1486tD2);
            }
            enumMap.put(enumC1486tD2, bool);
        }
        return new CD2(enumMap);
    }

    public final String e() {
        StringBuilder sb = new StringBuilder("G1");
        EnumC1486tD2[] enumC1486tD2Arr = EnumC1486tD2.w;
        for (int i = 0; i < 2; i++) {
            Boolean bool = (Boolean) this.a.get(enumC1486tD2Arr[i]);
            sb.append(bool == null ? '-' : bool.booleanValue() ? '1' : '0');
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CD2)) {
            return false;
        }
        CD2 cd2 = (CD2) obj;
        EnumC1486tD2[] enumC1486tD2ArrValues = EnumC1486tD2.values();
        int length = enumC1486tD2ArrValues.length;
        int i = 0;
        while (true) {
            char c = 1;
            if (i >= length) {
                return true;
            }
            EnumC1486tD2 enumC1486tD2 = enumC1486tD2ArrValues[i];
            Boolean bool = (Boolean) this.a.get(enumC1486tD2);
            char c2 = bool == null ? (char) 0 : bool.booleanValue() ? (char) 1 : (char) 2;
            Boolean bool2 = (Boolean) cd2.a.get(enumC1486tD2);
            if (bool2 == null) {
                c = 0;
            } else if (!bool2.booleanValue()) {
                c = 2;
            }
            if (c2 != c) {
                return false;
            }
            i++;
        }
    }

    public final boolean f(EnumC1486tD2 enumC1486tD2) {
        Boolean bool = (Boolean) this.a.get(enumC1486tD2);
        return bool == null || bool.booleanValue();
    }

    public final boolean g(CD2 cd2, EnumC1486tD2... enumC1486tD2Arr) {
        for (EnumC1486tD2 enumC1486tD2 : enumC1486tD2Arr) {
            Boolean bool = (Boolean) this.a.get(enumC1486tD2);
            Boolean bool2 = (Boolean) cd2.a.get(enumC1486tD2);
            Boolean bool3 = Boolean.FALSE;
            if (bool == bool3 && bool2 != bool3) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (Boolean bool : this.a.values()) {
            int i2 = i * 31;
            i = i2 + (bool == null ? 0 : bool.booleanValue() ? 1 : 2);
        }
        return i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("settings: ");
        EnumC1486tD2[] enumC1486tD2ArrValues = EnumC1486tD2.values();
        int length = enumC1486tD2ArrValues.length;
        for (int i = 0; i < length; i++) {
            EnumC1486tD2 enumC1486tD2 = enumC1486tD2ArrValues[i];
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(enumC1486tD2.name());
            sb.append("=");
            Boolean bool = (Boolean) this.a.get(enumC1486tD2);
            if (bool == null) {
                sb.append("uninitialized");
            } else {
                sb.append(true != bool.booleanValue() ? "denied" : "granted");
            }
        }
        return sb.toString();
    }

    public CD2(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(EnumC1486tD2.class);
        this.a = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
